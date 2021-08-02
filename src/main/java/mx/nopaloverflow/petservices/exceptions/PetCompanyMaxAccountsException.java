package mx.nopaloverflow.petservices.exceptions;

public class PetCompanyMaxAccountsException extends Exception {
    public PetCompanyMaxAccountsException() {
        super("Reached the maximum account number for this account");
    }

    public PetCompanyMaxAccountsException(final String message) {
        super(message);
    }
}
