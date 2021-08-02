package mx.nopaloverflow.petservices.dtos;


public class UserDto extends BaseDto {
    private String username;
    private String name;
    private PetCompanyDto company;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetCompanyDto getCompany() {
        return company;
    }

    public void setCompany(PetCompanyDto company) {
        this.company = company;
    }

    private boolean isCompanyWorker() {
        return this.company != null;
    }
}
