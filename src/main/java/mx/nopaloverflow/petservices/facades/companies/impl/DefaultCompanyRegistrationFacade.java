package mx.nopaloverflow.petservices.facades.companies.impl;

import mx.nopaloverflow.petservices.api.requests.CompanyRegistrationRequest;
import mx.nopaloverflow.petservices.dtos.AddressDto;
import mx.nopaloverflow.petservices.dtos.PetCompanyDto;
import mx.nopaloverflow.petservices.dtos.UserDto;
import mx.nopaloverflow.petservices.exceptions.EntityAlreadyRegisteredException;
import mx.nopaloverflow.petservices.exceptions.EntityNotFoundException;
import mx.nopaloverflow.petservices.facades.companies.CompanyRegistrationFacade;
import mx.nopaloverflow.petservices.models.CompanyUserModel;
import mx.nopaloverflow.petservices.models.PetCompanyModel;
import mx.nopaloverflow.petservices.repositories.CompanyUserRepository;
import mx.nopaloverflow.petservices.repositories.PetCompanyRepository;
import mx.nopaloverflow.petservices.strategies.PasswordPolicyStrategy;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Collections;

@Component("companyRegistrationFacade")
public class DefaultCompanyRegistrationFacade implements CompanyRegistrationFacade {

    private final ModelMapper modelMapper;
    private final PetCompanyRepository petCompanyRepository;
    private final CompanyUserRepository companyUserRepository;
    private final PasswordPolicyStrategy passwordPolicyStrategy;

    public DefaultCompanyRegistrationFacade(final ModelMapper modelMapper,
                                            final CompanyUserRepository companyUserRepository,
                                            final PetCompanyRepository petCompanyRepository,
                                            final PasswordPolicyStrategy passwordPolicyStrategy) {
        this.modelMapper = modelMapper;
        this.petCompanyRepository = petCompanyRepository;
        this.companyUserRepository = companyUserRepository;
        this.passwordPolicyStrategy = passwordPolicyStrategy;
    }

    @Override
    public UserDto registerCompany(final CompanyRegistrationRequest registrationForm) throws EntityAlreadyRegisteredException {
        Assert.notNull(registrationForm, "Form can not be null to register a new company");

        final var company = registrationForm.getCompanyInfo();
        final var address = registrationForm.getAddress();
        final var user = registrationForm.getUser();

        Assert.notNull(company, "Company can not be null");
        Assert.notNull(address, "Address can not be null");
        Assert.notNull(user, "User can not be null");
        Assert.hasLength(user.getPassword(), "Password should be included");
        Assert.isTrue(getPasswordPolicyStrategy().isPasswordValid(user.getPassword()), "Password should match the specifications");
        Assert.isTrue(user.getPassword().equals(user.getRepeatedPassword()), "Passwords should match");

        if (getPetCompanyRepository().existsByUid(company.getUid())) {
            throw new EntityAlreadyRegisteredException(String.format("The company [%s] is already registered", company.getUid()));
        }

        if (getCompanyUserRepository().existsByUsername(user.getUsername())) {
            throw new EntityAlreadyRegisteredException(String.format("User [%s] is already registered in the system for a different company", user.getUsername()));
        }

        // make sure we're only using one during the registration
        company.setLocations(Collections.singleton(address));

        final var newCompany = getModelMapper().map(company, PetCompanyModel.class);
        // FIXME: the locations should be populated based on the address being passed here
        //  momentarily removed the mapping because there's no initial data to match against and the references would break
        newCompany.setLocations(null);
        newCompany.setEnabled(false);
        getPetCompanyRepository().save(newCompany);

        final var newUser = getModelMapper().map(user, CompanyUserModel.class);
        newUser.setCompany(newCompany);
        newUser.setPassword(getPasswordPolicyStrategy().hashPassword(user.getPassword()));
        getCompanyUserRepository().save(newUser);

        user.setId(newUser.getId());
        company.setId(newCompany.getId());
        user.setCompany(company);

        return user;
    }

    @Override
    public void enableCompany(final String companyId) {
        final var company = getPetCompanyRepository().findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException(companyId, PetCompanyModel.class));

        company.setEnabled(true);
        getPetCompanyRepository().save(company);

        final var users = getCompanyUserRepository().findAllByCompany(company);

        // enable all the users for this company
        for (final CompanyUserModel user : users) {
            user.setEnabled(true);
        }

        getCompanyUserRepository().saveAll(users);
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public PetCompanyRepository getPetCompanyRepository() {
        return petCompanyRepository;
    }

    public CompanyUserRepository getCompanyUserRepository() {
        return companyUserRepository;
    }

    public PasswordPolicyStrategy getPasswordPolicyStrategy() {
        return passwordPolicyStrategy;
    }
}
