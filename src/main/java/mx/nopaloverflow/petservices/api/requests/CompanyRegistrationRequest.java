package mx.nopaloverflow.petservices.api.requests;

import mx.nopaloverflow.petservices.dtos.AddressDto;
import mx.nopaloverflow.petservices.dtos.PetCompanyDto;

public class CompanyRegistrationRequest {
    private UserRegistrationRequest user;
    private PetCompanyDto companyInfo;
    private AddressDto address;

    public UserRegistrationRequest getUser() {
        return user;
    }

    public void setUser(UserRegistrationRequest user) {
        this.user = user;
    }

    public PetCompanyDto getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(PetCompanyDto companyInfo) {
        this.companyInfo = companyInfo;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
