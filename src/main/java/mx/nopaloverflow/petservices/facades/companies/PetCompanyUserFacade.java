package mx.nopaloverflow.petservices.facades.companies;

import mx.nopaloverflow.petservices.dtos.SessionDto;
import mx.nopaloverflow.petservices.dtos.UserDto;
import mx.nopaloverflow.petservices.exceptions.PetCompanyMaxAccountsException;

public interface PetCompanyUserFacade {
    /**
     * Adds a new user to the pet company. It adds the user to the company
     * of the current user. It will require the new user to manually set up
     * their initial password.
     *
     * @param user The user being added.
     * @throws PetCompanyMaxAccountsException In case the maximum number of user accounts
     *                                        have already been reached for this company.
     */
    void addUser(final UserDto user) throws PetCompanyMaxAccountsException;

    /**
     * Removes the user from the company of the current user.
     *
     * @param userId The id of the user to be removed.
     */
    void removeUser(final String userId);

    /**
     * Authentication using plain username and password for an existing account.
     *
     * @param username The unique username of the user trying to login.
     * @param password The plain password of the registered user.
     * @return The data related to the session for this account.
     */
    SessionDto login(final String username, final String password);
}
