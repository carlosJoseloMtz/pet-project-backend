package mx.nopaloverflow.petservices.facades.companies;

import mx.nopaloverflow.petservices.api.requests.CompanyRegistrationRequest;
import mx.nopaloverflow.petservices.dtos.AddressDto;
import mx.nopaloverflow.petservices.dtos.PetCompanyDto;
import mx.nopaloverflow.petservices.dtos.UserDto;
import mx.nopaloverflow.petservices.exceptions.EntityAlreadyRegisteredException;

public interface CompanyRegistrationFacade {
    /**
     * Registers the company within the system,
     * it will be validated in the background and will send notification
     * to the user's email when the registration has been successfully completed.
     *
     * @param registrationForm The main information of the company to be registered with one location and only one user.
     * @return The user who is the face of the new company.
     */
    UserDto registerCompany(final CompanyRegistrationRequest registrationForm) throws EntityAlreadyRegisteredException;

    /**
     * Enables the company in the system to start working on their users and pets.
     * Will validate internally if the user performing the operation has the right privileges
     * to perform the operation:
     * {@link mx.nopaloverflow.petservices.models.enums.UserGroupEnum#ADMIN}
     *
     * @param companyId The id of the company that we're manually enabling.
     */
    void enableCompany(final String companyId);
}
