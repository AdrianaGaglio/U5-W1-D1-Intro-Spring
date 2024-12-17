package epicode.it.pizzeria.runner;

import epicode.it.pizzeria.entity.Drink;
import epicode.it.pizzeria.entity.Menu;
import epicode.it.pizzeria.entity.Pizza;
import epicode.it.pizzeria.entity.Topping;
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
        System.out.println();
        System.out.printf("%-50s %-15s %-15s%n", "Pizzas", "Calories", "Price");

        for (int i = 0; i < menu.getPizzas().size(); i++) {
            Pizza pizza = menu.getPizzas().get(i);
            String toppings = "";
            for (int j = 0; j < pizza.getToppings().size(); j++) {
                String toppingName = pizza.getToppings().get(j).getName();
                if(j < pizza.getToppings().size() - 1) {
                    toppings += toppingName + ", ";
                } else {
                    toppings += toppingName;
                }
            }
            System.out.printf("%-50s %-15s %-15s%n", pizza.getName() +
                    " (" + toppings + ")", pizza.getCalories(), pizza.getPrice());
        }
        System.out.println();
        System.out.printf("%-50s %-15s %-15s%n", "Toppings", "Calories", "Price");

        for (int i = 0; i < menu.getToppings().size(); i++) {
            Topping topping = menu.getToppings().get(i);
            System.out.printf("%-50s %-15s %-15s%n", topping.getName(), topping.getCalories(), topping.getPrice());
        }
        System.out.println();
        System.out.printf("%-50s %-15s %-15s%n", "Drinks", "Calories", "Price");
        for (int i = 0; i < menu.getDrinks().size(); i++) {
            Drink drink = menu.getDrinks().get(i);
            System.out.printf("%-50s %-15s %-15s%n", drink.getName(), drink.getCalories(), drink.getPrice());
        }
        System.out.println();
    }
}
