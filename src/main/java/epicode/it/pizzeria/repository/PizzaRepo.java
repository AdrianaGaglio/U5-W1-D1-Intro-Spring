package epicode.it.pizzeria.repository;

import epicode.it.pizzeria.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepo extends JpaRepository<Pizza, Long> {
}
