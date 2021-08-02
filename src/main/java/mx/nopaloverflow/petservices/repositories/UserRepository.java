package mx.nopaloverflow.petservices.repositories;

import mx.nopaloverflow.petservices.models.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, String> {
}
