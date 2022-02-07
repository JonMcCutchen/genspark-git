package spring.basics.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFullModeConfig {
    @Bean
    public Name getName() {
        return new Name("John", "Doe");
    }

    @Bean
    public Person getPerson() {
        return new Person(getName());
    }
}
