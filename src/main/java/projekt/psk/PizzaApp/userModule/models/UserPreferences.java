package projekt.psk.PizzaApp.userModule.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPreferences {
    private int budget;
    @Size(max = 5, min = 1)
    private int peopleAmount;
}
