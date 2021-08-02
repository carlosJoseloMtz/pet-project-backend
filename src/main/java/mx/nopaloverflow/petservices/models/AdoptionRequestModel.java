package mx.nopaloverflow.petservices.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document("adoptionrequests")
public class AdoptionRequestModel extends BaseModel {
    private UserModel potentialAdopter;
    private PetModel pet;
    private String phoneNumber;
    private String email;
    private Set<AdoptionMessageModel> messages;

    public UserModel getPotentialAdopter() {
        return potentialAdopter;
    }

    public void setPotentialAdopter(UserModel potentialAdopter) {
        this.potentialAdopter = potentialAdopter;
    }

    public PetModel getPet() {
        return pet;
    }

    public void setPet(PetModel pet) {
        this.pet = pet;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<AdoptionMessageModel> getMessages() {
        return messages;
    }

    public void setMessages(Set<AdoptionMessageModel> messages) {
        this.messages = messages;
    }
}
