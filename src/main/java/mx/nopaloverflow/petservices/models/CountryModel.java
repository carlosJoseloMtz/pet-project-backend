package mx.nopaloverflow.petservices.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


// TODO: seed initial data for this
@Document("countries")
public class CountryModel extends BaseModel {
    @Indexed(unique = true)
    private String isoCode;
    private String name;

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
