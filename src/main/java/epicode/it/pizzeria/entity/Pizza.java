package epicode.it.pizzeria.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="pizzas")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private int calories = 300;
    private double price;

    @OneToMany(mappedBy = "pizza", cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private List<Topping> toppings = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Menu menu;
}