package epicode.it.pizzeria.repository;

import epicode.it.pizzeria.entity.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToppingRepo extends JpaRepository<Topping, Long> {



}
