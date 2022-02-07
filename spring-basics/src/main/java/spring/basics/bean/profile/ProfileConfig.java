package spring.basics.bean.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@ComponentScan
public class ProfileConfig {
    @Bean
    @Profile("default")
    public DefaultBean defaultBean() {
        return new DefaultBean();
    }
}
