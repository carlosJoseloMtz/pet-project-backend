package mx.nopaloverflow.petservices.facades.companies.impl;

import mx.nopaloverflow.petservices.dtos.SessionDto;
import mx.nopaloverflow.petservices.dtos.UserDto;
import mx.nopaloverflow.petservices.exceptions.PetCompanyMaxAccountsException;
import mx.nopaloverflow.petservices.facades.companies.PetCompanyUserFacade;
import org.springframework.stereotype.Component;

@Component("petCompanyUserFacade")
public class DefaultPetCompanyUserFacade implements PetCompanyUserFacade {
    @Override
    public void addUser(UserDto user) throws PetCompanyMaxAccountsException {
        // TODO
    }

    @Override
    public void removeUser(String userId) {
        // TODO
    }

    @Override
    public SessionDto login(final String username, final String password) {
        return null;
    }
}
