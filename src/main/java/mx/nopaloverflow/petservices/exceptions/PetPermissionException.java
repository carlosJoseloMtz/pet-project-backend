package mx.nopaloverflow.petservices.exceptions;

public class PetPermissionException extends Exception {
    public PetPermissionException() {
        super("The user used for this operation does not have enough privileges");
    }

    public PetPermissionException(final String message) {
        super(message);
    }
}
