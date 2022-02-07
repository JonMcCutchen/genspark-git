package spring.basics.aop.aspectj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
@EnableAspectJAutoProxy
public class AspectJConfig {
    @Bean
    public Person getPerson() {
        return new Person("John Doe");
    }
}
