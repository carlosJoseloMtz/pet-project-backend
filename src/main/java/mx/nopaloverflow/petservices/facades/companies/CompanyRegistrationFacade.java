package mx.nopaloverflow.petservices.facades.companies;

import mx.nopaloverflow.petservices.dtos.PetCompanyDto;
import mx.nopaloverflow.petservices.exceptions.PetPermissionException;

public interface CompanyRegistrationFacade {
    /**
     * Registers the company within the system,
     * it will be validated in the background and will send notification
     * to the user's email when the registration has been successfully completed.
     *
     * @param company The company to be registered in the system.
     */
    void registerCompany(final PetCompanyDto company);

    /**
     * Enables the company in the system to start working on their users and pets.
     * Will validate internally if the user performing the operation has the right privileges
     * to perform the operation:
     * {@link mx.nopaloverflow.petservices.models.enums.UserGroupEnum#ADMIN}
     *
     * @param companyId The id of the company that we're manually enabling.
     */
    void enableCompany(final String companyId) throws PetPermissionException;
}
