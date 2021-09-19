package mx.nopaloverflow.petservices.exceptions;

public class EntityAlreadyRegisteredException extends Exception {

    public EntityAlreadyRegisteredException(final String message) {
        super(message);
    }

    public EntityAlreadyRegisteredException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
