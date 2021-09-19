package mx.nopaloverflow.petservices.repositories;

import mx.nopaloverflow.petservices.models.CompanyUserModel;
import mx.nopaloverflow.petservices.models.PetCompanyModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyUserRepository extends CrudRepository<CompanyUserModel, String> {

    boolean existsByUsername(final String username);

    Iterable<CompanyUserModel> findAllByCompany(final PetCompanyModel company);

    Optional<CompanyUserModel> findCompanyUserModelByUsername(final String username);
}
