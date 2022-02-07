package spring.basics.bean.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        Person person1 = context.getBean(Person.class);
        Person person2 = context.getBean(Person.class);
        System.out.println(person1 == person2);

        Address address1 = person1.getAddress();
        Address address2 = person2.getAddress();
        System.out.println(address1 == address2);
    }
}
