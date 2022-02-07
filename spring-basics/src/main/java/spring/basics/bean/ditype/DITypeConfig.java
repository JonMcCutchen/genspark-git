package spring.basics.bean.ditype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
public class DITypeConfig {
    @Bean
    public Name getName() {
        return new Name("Rod", "Johnson");
    }

    @Bean
    public Address getAddress() {
        return new Address("High Street");
    }

    @Bean
    public Occupation getOccupation() {
        return new Occupation("Java Developer");
    }
}
