package epicode.it.pizzeria.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

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

    @ManyToMany(mappedBy = "pizzas", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Topping> toppings = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @ToString.Exclude
    private Menu menu;
}