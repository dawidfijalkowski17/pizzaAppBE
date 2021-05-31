package projekt.psk.PizzaApp.pizzaModule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projekt.psk.PizzaApp.pizzaModule.models.Pizza;
import projekt.psk.PizzaApp.pizzaModule.services.PizzaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {

    @Autowired
    PizzaService pizzaService;

    @PostMapping("/add")
    public String savePizza(@RequestBody Pizza pizza) {
        return this.pizzaService.savePizza(pizza);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updatePizza(@PathVariable(value="id", required=true) String id, @RequestBody Pizza pizza){
        this.pizzaService.updatePizza(pizza, id);
        return ResponseEntity.ok("Zaktualizowano pomyślnie");
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deletePizza(@RequestBody String id){
        this.pizzaService.deletePizza(id);
        return ResponseEntity.ok("Pizza została usunięta");
    }

    @GetMapping("/get/{id}")
    public Optional<Pizza> getPizza(@PathVariable(value="id", required=true) String id){
        return this.pizzaService.getPizza(id);
    }

    @GetMapping("/get")
    public List<Pizza> getAllPizzas() {
        return this.pizzaService.getAllPizzas();
    }

    @GetMapping("/get-owned/{id}")
    public List<Pizza> getAllOwnedPizzas(@PathVariable(value="id", required=true) String id) {
        return this.pizzaService.getAllOwnedPizzas(id);
    }


}
