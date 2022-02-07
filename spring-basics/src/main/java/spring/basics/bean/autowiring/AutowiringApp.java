package spring.basics.bean.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiringApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AutowiringConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person.getName());
        System.out.println(person.getAddress());
        System.out.println(person.getAge());
    }
}
