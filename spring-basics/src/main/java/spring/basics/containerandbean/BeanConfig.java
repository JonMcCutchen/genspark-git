package spring.basics.containerandbean;

import org.springframework.context.annotation.Bean;

public class BeanConfig {
    @Bean({"address", "kingAvenue"})
    Address getAddress() {
        return new Address(200, "King Avenue");
    }

    @Bean
    Person getPerson() {
        Person person = new Person();
        person.setFullName("Jane Roe");
        person.setAddress(getAddress());
        return person;
    }
}
