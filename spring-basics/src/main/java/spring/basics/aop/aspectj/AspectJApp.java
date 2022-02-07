package spring.basics.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectJApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectJConfig.class);
        Printable person = context.getBean(Printable.class);
        person.printFullName();
        System.out.println(person.getClass().getName());
    }
}
