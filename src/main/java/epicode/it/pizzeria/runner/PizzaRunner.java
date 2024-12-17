package epicode.it.pizzeria.runner;

import epicode.it.pizzeria.entity.Pizza;
import epicode.it.pizzeria.entity.Topping;
import epicode.it.pizzeria.repository.PizzaRepo;
import epicode.it.pizzeria.repository.ToppingRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(3)
public class PizzaRunner implements ApplicationRunner {

    @Autowired
    @Qualifier("ham")
    private Topping ham;

    @Autowired
    @Qualifier("cheese")
    private Topping cheese;

    @Autowired
    @Qualifier("tomato")
    private Topping tomato;

    @Autowired
    @Qualifier("pineapple")
    private Topping pineapple;

    @Autowired
    @Qualifier("salami")
    private Topping salami;

    @Autowired
    @Qualifier("onions")
    private Topping onions;

    @Autowired
    private ObjectProvider<Pizza> pizzaProvider;

    @Autowired
    private PizzaRepo pizzaRepo;

    @Autowired
    private ToppingRepo toppingRepo;




    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        if(pizzaRepo.count() == 0) {
            // pizza margherita
            Pizza margherita = pizzaProvider.getObject();
            pizzaRepo.save(margherita);

            // pizza hawaiian
            Pizza hawaiianPizza = pizzaProvider.getObject();
            hawaiianPizza.setName("Hawaiian Pizza");
            hawaiianPizza.setPrice(6.49);
            Topping ham = toppingRepo.findByName("ham");
            hawaiianPizza.getToppings().add(ham);
            Topping pineapple = toppingRepo.findByName("pineapple");
            hawaiianPizza.getToppings().add(pineapple);
            ham.getPizzas().add(hawaiianPizza);
            pineapple.getPizzas().add(hawaiianPizza);
            hawaiianPizza.setCalories(hawaiianPizza.getCalories() + ham.getCalories() + pineapple.getCalories());
            pizzaRepo.save(hawaiianPizza);


            // pizza salame
            Pizza salamiPizza = pizzaProvider.getObject();
            salamiPizza.setName("Salami Pizza");
            salamiPizza.setPrice(5.99);
            Topping salami = toppingRepo.findByName("salami");
            salamiPizza.getToppings().add(salami);
            salami.getPizzas().add(salamiPizza);
            salamiPizza.setCalories(salamiPizza.getCalories() + salami.getCalories());
            pizzaRepo.save(salamiPizza);
        }

    }
}
