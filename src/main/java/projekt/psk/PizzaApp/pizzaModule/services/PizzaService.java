package projekt.psk.PizzaApp.pizzaModule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.psk.PizzaApp.pizzaModule.models.Pizza;
import projekt.psk.PizzaApp.pizzaModule.repositories.PizzaRepository;

import java.util.*;

@Service
public class PizzaService {
    @Autowired
    PizzaRepository pizzaRepository;


    public String savePizza(Pizza pizza){
       return this.pizzaRepository.save(pizza).getId();
    }
    public void deletePizza(String id){
        this.pizzaRepository.deleteById(id);
    }

    public void updatePizza(Pizza newPizza, String id){
        Optional<Pizza> pizza = this.pizzaRepository.findById(id);
        pizza.ifPresent(piz -> {
            if(newPizza.getName() != null){
                piz.setName(newPizza.getName());
            }
            if(newPizza.getDescription() != null){
                piz.setDescription(newPizza.getDescription());
            }
            this.pizzaRepository.save(piz);
        });
    }

    public List<Pizza> getAllPizzas(){
        return this.pizzaRepository.findAll();
    }

    public List<Pizza> getAllOwnedPizzas(String id){
        return this.pizzaRepository.findByOwnerId(id);
    }





    public Optional<Pizza> getPizza(String id){
        return this.pizzaRepository.findById(id);
    }




    }


