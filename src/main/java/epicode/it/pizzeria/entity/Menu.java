package epicode.it.pizzeria.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pizza> pizzas = new ArrayList<>();

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topping> toppings = new ArrayList<>();

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Drink> drinks = new ArrayList<>();

}