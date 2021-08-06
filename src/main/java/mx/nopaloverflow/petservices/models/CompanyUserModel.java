package mx.nopaloverflow.petservices.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("companyusers")
public class CompanyUserModel extends UserModel {

    /**
     * In case of being part of a company, this is the company
     * that the person is working in.
     * To avoid conflicts of interest, it's better to keep them to
     * work only in one company per user.
     */
    private PetCompanyModel company;

    public PetCompanyModel getCompany() {
        return company;
    }

    public void setCompany(PetCompanyModel company) {
        this.company = company;
    }

    @Override
    public boolean isCompanyWorker() {
        return true;
    }
}
