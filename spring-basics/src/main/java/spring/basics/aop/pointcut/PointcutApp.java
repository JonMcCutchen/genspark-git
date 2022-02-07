package spring.basics.aop.pointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PointcutApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PointcutConfig.class);
        Person person = context.getBean(Person.class);
        person.printFullName();
        System.out.println("Spring AOP pointcut demo");
    }
}
