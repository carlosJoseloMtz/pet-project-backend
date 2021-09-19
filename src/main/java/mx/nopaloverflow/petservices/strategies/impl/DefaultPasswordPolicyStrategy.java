package mx.nopaloverflow.petservices.strategies.impl;

import mx.nopaloverflow.petservices.strategies.PasswordPolicyStrategy;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("passwordPolicyStrategy")
public class DefaultPasswordPolicyStrategy implements PasswordPolicyStrategy {
    private static final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.@#$%^&+=])(?=\\S+$).{8,}$";
    private static final int SALT = 10;

    @Override
    public boolean isPasswordValid(final String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        return password.matches(PATTERN);
    }

    @Override
    public String hashPassword(final String password) {
        Assert.hasLength(password, "Password to be hashed should not be empty");

        final var salt = BCrypt.gensalt(SALT);
        return BCrypt.hashpw(password, salt);
    }

    @Override
    public boolean isPasswordMatch(final String plainPassword, final String hash) {
        Assert.hasLength(plainPassword, "Password should not be empty");
        Assert.hasLength(hash, "Hash should not be empty");

        return BCrypt.checkpw(plainPassword, hash);
    }
}
