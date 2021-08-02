package mx.nopaloverflow.petservices.facades.adopters;

import mx.nopaloverflow.petservices.dtos.SessionDto;
import mx.nopaloverflow.petservices.dtos.UserDto;

public interface PetAdopterUserFacade {

    /**
     * Registers a pet adopter user into the system.
     *
     * @param user The user to be registered.
     * @return The info for the session created for this user.
     */
    SessionDto registerUser(final UserDto user);

    /**
     * Updates the current user with the full information passed.
     *
     * @param user The info to update the current user's info in the DB.
     * @return The information of the user with the updates applied.
     */
    UserDto updateProfile(final UserDto user);
}
