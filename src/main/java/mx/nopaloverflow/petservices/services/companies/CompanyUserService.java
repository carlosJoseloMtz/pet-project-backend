package mx.nopaloverflow.petservices.services.companies;

import mx.nopaloverflow.petservices.models.CompanyUserModel;

public interface CompanyUserService {

    CompanyUserModel getUserForLogin(final String username, final String password);
}
