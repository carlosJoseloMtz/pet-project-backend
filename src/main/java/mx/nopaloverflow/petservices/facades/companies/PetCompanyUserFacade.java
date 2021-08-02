package mx.nopaloverflow.petservices.facades.companies;

import mx.nopaloverflow.petservices.dtos.UserDto;
import mx.nopaloverflow.petservices.exceptions.PetCompanyMaxAccountsException;
import mx.nopaloverflow.petservices.exceptions.PetPermissionException;

public interface PetCompanyUserFacade {
    /**
     * Adds a new user to the pet company. It adds the user to the company
     * of the current user. It will require the new user to manually set up
     * their initial password.
     *
     * @param user The user being added.
     * @throws PetPermissionException         If the user performing this operation is not a pet-company user
     *                                        or does not have a user assigned.
     * @throws PetCompanyMaxAccountsException In case the maximum number of user accounts
     *                                        have already been reached for this company.
     */
    void addUser(final UserDto user) throws PetPermissionException, PetCompanyMaxAccountsException;

    /**
     * Removes the user from the company of the current user.
     *
     * @param userId The id of the user to be removed.
     * @throws PetPermissionException In case the user executing the operation is not a
     *                                {@link mx.nopaloverflow.petservices.models.enums.UserGroupEnum#PET_COMPANY_ADMIN}
     */
    void removeUser(final String userId) throws PetPermissionException;
}
