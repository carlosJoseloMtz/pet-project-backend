package mx.nopaloverflow.petservices.dtos;

import java.util.Set;

public class PetCompanyDto extends BaseDto {
    private String uid;
    private String name;
    private String description;
    private Set<AddressDto> locations;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

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

    public Set<AddressDto> getLocations() {
        return locations;
    }

    public void setLocations(Set<AddressDto> locations) {
        this.locations = locations;
    }
}
