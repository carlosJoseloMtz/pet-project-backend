package mx.nopaloverflow.petservices.models;

import com.mongodb.lang.Nullable;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;


@Document("petcompanies")
public class PetCompanyModel extends BaseModel {
    @Indexed(unique = true)
    private String uid;
    private String name;
    private String description;
    @Nullable
    private Set<AddressModel> locations;

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

    public Set<AddressModel> getLocations() {
        return locations;
    }

    public void setLocations(Set<AddressModel> locations) {
        this.locations = locations;
    }
}
