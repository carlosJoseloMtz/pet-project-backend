package mx.nopaloverflow.petservices.services.companies.impl;

import mx.nopaloverflow.petservices.repositories.PetCompanyRepository;
import mx.nopaloverflow.petservices.services.companies.PetCompanyService;
import org.springframework.util.Assert;

public class DefaultPetCompanyService implements PetCompanyService {

    private final PetCompanyRepository petCompanyRepository;

    public DefaultPetCompanyService(final PetCompanyRepository petCompanyRepository) {
        this.petCompanyRepository = petCompanyRepository;
    }

    // TODO: implement abstract methods from interface

    public PetCompanyRepository getPetCompanyRepository() {
        return petCompanyRepository;
    }
}
