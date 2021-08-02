package mx.nopaloverflow.petservices.models;

import org.springframework.data.mongodb.core.mapping.Document;


@Document("adoptionmessages")
public class AdoptionMessageModel extends BaseModel {
    private String message;
    private UserModel by;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserModel getBy() {
        return by;
    }

    public void setBy(UserModel by) {
        this.by = by;
    }
}
