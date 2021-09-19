package mx.nopaloverflow.petservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity not found")
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(final String id) {
        super(String.format("Entity with id [%s] not found", id));
    }

    public <T> EntityNotFoundException(final String id, final Class<T> type) {
        super(String.format("Entity with id [%s] of type [%s] was not found", id, type.getSimpleName()));
    }
}
