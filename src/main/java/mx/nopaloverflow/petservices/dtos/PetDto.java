package mx.nopaloverflow.petservices.dtos;

public class PetDto extends BaseDto {
    private String name;
    private String description;
    private PetCompanyDto company;
    private AddressDto location;
    private boolean adopted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PetCompanyDto getCompany() {
        return company;
    }

    public void setCompany(PetCompanyDto company) {
        this.company = company;
    }

    public AddressDto getLocation() {
        return location;
    }

    public void setLocation(AddressDto location) {
        this.location = location;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }
}
