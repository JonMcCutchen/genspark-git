package spring.basics.aop.pointcut;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
@EnableAspectJAutoProxy
public class PointcutConfig {
    @Bean
    public Person getPerson() {
        return new Person("John Doe");
    }
}
