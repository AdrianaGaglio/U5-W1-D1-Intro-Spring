package epicode.it.pizzeria.configuration;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;


@Configuration
public class FakerConfiguration {

    private Faker faker = new Faker(new Locale("it"));

    public Faker getFaker() {
        return faker;
    }

}
