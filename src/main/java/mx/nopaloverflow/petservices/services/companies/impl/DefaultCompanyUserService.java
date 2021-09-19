package mx.nopaloverflow.petservices.services.companies.impl;

import mx.nopaloverflow.petservices.exceptions.EntityNotFoundException;
import mx.nopaloverflow.petservices.models.CompanyUserModel;
import mx.nopaloverflow.petservices.repositories.CompanyUserRepository;
import mx.nopaloverflow.petservices.services.companies.CompanyUserService;
import mx.nopaloverflow.petservices.strategies.PasswordPolicyStrategy;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("companyUserService")
public class DefaultCompanyUserService implements CompanyUserService {

    private final CompanyUserRepository companyUserRepository;
    private final PasswordPolicyStrategy passwordPolicyStrategy;

    public DefaultCompanyUserService(final CompanyUserRepository companyUserRepository,
                                     final PasswordPolicyStrategy passwordPolicyStrategy) {
        this.companyUserRepository = companyUserRepository;
        this.passwordPolicyStrategy = passwordPolicyStrategy;
    }

    @Override
    public CompanyUserModel getUserForLogin(final String username, final String password) {

        final var user = getCompanyUserRepository().findCompanyUserModelByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("username", CompanyUserModel.class));


        Assert.isTrue(user.isEnabled(), String.format("User [%s] should be enabled", username));

        final var isPasswordMatch = getPasswordPolicyStrategy().isPasswordMatch(password, user.getPassword());
        // TODO: handle here brute force attack for the account

        Assert.isTrue(isPasswordMatch, String.format("Password mismatch for user [%s]", username));


        return null;
    }

    public CompanyUserRepository getCompanyUserRepository() {
        return companyUserRepository;
    }

    public PasswordPolicyStrategy getPasswordPolicyStrategy() {
        return passwordPolicyStrategy;
    }
}
