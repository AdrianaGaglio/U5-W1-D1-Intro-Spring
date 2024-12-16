package epicode.it.pizzeria.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@NamedQuery(name="findAll_Alcohol", query="SELECT a FROM Alcohol a")
public class Alcohol extends Drink {
    private double volume;
}