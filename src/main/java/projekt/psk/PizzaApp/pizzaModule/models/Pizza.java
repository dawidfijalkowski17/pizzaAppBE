package projekt.psk.PizzaApp.pizzaModule.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {
    @Id
    private String id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 120)
    private String description;

    @NotBlank
    @Size(max = 10)
    private String price;


    private String ownerId;
}
