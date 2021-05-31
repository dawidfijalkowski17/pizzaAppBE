package projekt.psk.PizzaApp.userModule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projekt.psk.PizzaApp.pizzaModule.models.Pizza;
import projekt.psk.PizzaApp.userModule.models.User;
import projekt.psk.PizzaApp.userModule.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
    @GetMapping("/getUnactivatedUsers")
    public List<User> getAllUnactivatedUsers() {
        return this.userService.getAllUsers().stream()
                .filter(user -> user.isActive() == false)
                .collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    public Optional<User> getUser(@PathVariable(value="id", required=true) String id){
        return this.userService.getUser(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(value="id", required=true) String id, @RequestBody User user){
        this.userService.updateUser(user, id);
        return ResponseEntity.ok("Zaktualizowano pomyślnie");
    }

    @PostMapping("/activate")
    public void activateUser(@RequestBody String id){
        User user = this.userService.getUser(id).get();
        user.activate();
        this.userService.updateUserWithoutId(user);
    }
}
