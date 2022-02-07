package spring.basics.bean.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@ComponentScan
public class ScopeConfig {
    @Bean
    @Scope("singleton")
    public Address getAddress() {
        return new Address("High Street");
    }
}
