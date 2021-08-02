package mx.nopaloverflow.petservices.models;

import org.springframework.data.mongodb.core.mapping.Document;


@Document("pets")
public class PetModel extends BaseModel {
    private String name;
    private String description;
    /**
     * The company that is putting this pet into adoption.
     */
    private PetCompanyModel company;
    /**
     * Where the pet is physically located, since the company might have multiple locations,
     * it's better to specify this for the adoption since that will mean to physically interact within this location.
     */
    private AddressModel location;
    /**
     * Indicates if the pet has already been adopted or not.
     */
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

    public PetCompanyModel getCompany() {
        return company;
    }

    public void setCompany(PetCompanyModel company) {
        this.company = company;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public AddressModel getLocation() {
        return location;
    }

    public void setLocation(AddressModel location) {
        this.location = location;
    }
}
