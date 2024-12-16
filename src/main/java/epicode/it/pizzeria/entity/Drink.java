package epicode.it.pizzeria.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="drinks")
public class Drink extends FoodAndDrink {
    private double quantity;

    @ManyToOne
    private Menu menu;
}