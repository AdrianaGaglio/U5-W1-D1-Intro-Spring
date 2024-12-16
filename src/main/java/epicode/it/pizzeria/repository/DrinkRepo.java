package epicode.it.pizzeria.repository;

import epicode.it.pizzeria.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepo extends JpaRepository<Drink,Long> {
}
