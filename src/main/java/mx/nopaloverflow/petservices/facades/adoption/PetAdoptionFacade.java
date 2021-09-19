package mx.nopaloverflow.petservices.facades.adoption;

import mx.nopaloverflow.petservices.api.requests.PetAdoptionRequest;

public interface PetAdoptionFacade {

    /**
     * Performs the request to adopt a pet based on the id of the pet.
     * The user on the session is the one adopting.
     *
     * @param request All the info required for the adoption to be reviewed by the company.
     */
    void requestAdoption(final PetAdoptionRequest request);

}
