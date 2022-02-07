package spring.basics.bean.jeeannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import spring.basics.bean.scope.Address;

@ComponentScan
public class JeeConfig {
    @Bean
    public Identity getIdentity() {
        return new Identity("John Doe");
    }

    @Bean
    public Location getLocation() {
        return new Location("High Street");
    }
}
