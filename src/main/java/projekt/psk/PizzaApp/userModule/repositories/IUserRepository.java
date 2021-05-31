package projekt.psk.PizzaApp.userModule.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import projekt.psk.PizzaApp.userModule.models.User;

import java.util.Optional;

public interface IUserRepository extends MongoRepository<User, String> {
    Optional<User> findById(String id);
}
