package mx.nopaloverflow.petservices.repositories;

import mx.nopaloverflow.petservices.models.PetCompanyModel;
import org.springframework.data.repository.CrudRepository;

public interface PetCompanyRepository extends CrudRepository<PetCompanyModel, String> {

    boolean existsByUid(final String uid);
}
