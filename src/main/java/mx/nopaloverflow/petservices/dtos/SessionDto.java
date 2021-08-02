package mx.nopaloverflow.petservices.dtos;

public class SessionDto {
    private String sessionToken;
    private UserDto user;

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
