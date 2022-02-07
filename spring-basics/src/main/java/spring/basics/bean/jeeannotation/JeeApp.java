package spring.basics.bean.jeeannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JeeApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JeeConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person.getIdentity().getFullName());
        System.out.println(person.getLocation().getAddress());

    }
}
