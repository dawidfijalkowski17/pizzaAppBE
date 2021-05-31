package projekt.psk.PizzaApp.pizzaModule.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import projekt.psk.PizzaApp.pizzaModule.models.Pizza;

import java.util.List;
import java.util.Optional;


public interface PizzaRepository extends MongoRepository<Pizza, String> {
        Optional<Pizza> findById(String id);
        List<Pizza> findByOwnerId(String id);
        }
