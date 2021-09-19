package mx.nopaloverflow.petservices.strategies;

public interface PasswordPolicyStrategy {
    boolean isPasswordValid(final String password);

    String hashPassword(final String password);

    boolean isPasswordMatch(final String plainPassword, final String hash);
}
