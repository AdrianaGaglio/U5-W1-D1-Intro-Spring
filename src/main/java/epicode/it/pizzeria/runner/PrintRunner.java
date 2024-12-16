package epicode.it.pizzeria.runner;

import epicode.it.pizzeria.entity.Menu;
import epicode.it.pizzeria.entity.Pizza;
import epicode.it.pizzeria.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PrintRunner implements ApplicationRunner {

    @Autowired
    private MenuRepo menuRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Menu menu = menuRepo.findAll().get(0);

        System.out.printf("%-15s %-10s %-10s%n", "Pizzas", "Calories", "Price");

        for (int i = 0; i < menu.getPizzas().size(); i++) {
            Pizza pizza = menu.getPizzas().get(i);
            System.out.println(pizza);
        }
    }
}
