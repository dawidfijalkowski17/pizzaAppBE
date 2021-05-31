package projekt.psk.PizzaApp.loginModule.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import projekt.psk.PizzaApp.loginModule.models.ERole;
import projekt.psk.PizzaApp.loginModule.models.Role;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}