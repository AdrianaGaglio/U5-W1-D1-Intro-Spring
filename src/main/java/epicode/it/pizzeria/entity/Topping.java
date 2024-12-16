package epicode.it.pizzeria.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="toppings")
public class Topping extends FoodAndDrink {

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    @ManyToOne
    private Menu menu;

}