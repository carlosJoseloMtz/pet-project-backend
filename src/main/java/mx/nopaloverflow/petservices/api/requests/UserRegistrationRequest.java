package mx.nopaloverflow.petservices.api.requests;

import mx.nopaloverflow.petservices.dtos.UserDto;

public class UserRegistrationRequest extends UserDto {
    private String password;
    private String repeatedPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
