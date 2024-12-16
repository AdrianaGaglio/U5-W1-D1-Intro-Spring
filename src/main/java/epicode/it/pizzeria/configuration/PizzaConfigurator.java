package epicode.it.pizzeria.configuration;

import epicode.it.pizzeria.entity.Pizza;
import epicode.it.pizzeria.entity.Topping;
import epicode.it.pizzeria.repository.ToppingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PizzaConfigurator {

    @Autowired
    @Qualifier("cheese")
    private Topping cheese;

    @Autowired
    @Qualifier("tomato")
    private Topping tomato;



    @Bean
    @Scope("prototype")
    public Pizza getBase() {
        Pizza margherita = new Pizza();
        margherita.setName("Pizza Margherita");
        margherita.setPrice(4.99);
        margherita.getToppings().add(cheese);
        margherita.getToppings().add(tomato);
        margherita.setCalories(margherita.getCalories() + cheese.getCalories() + tomato.getCalories());
        return margherita;
    }


}
