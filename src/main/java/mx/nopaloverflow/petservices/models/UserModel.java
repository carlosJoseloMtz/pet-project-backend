package mx.nopaloverflow.petservices.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("users")
public class UserModel extends BaseModel {

    @Indexed(unique = true)
    private String username;
    private String name;
    private String password;
    /**
     * In case of being part of a company, this is the company
     * that the person is working in.
     * To avoid conflicts of interest, it's better to keep them to
     * work only in one company per user.
     */
    private PetCompanyModel company;
    private String userType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PetCompanyModel getCompany() {
        return company;
    }

    public void setCompany(PetCompanyModel company) {
        this.company = company;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isCompanyWorker() {
        return this.company != null;
    }
}
