package spring.basics.resource.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@ComponentScan
public class InjectionApp {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(InjectionApp.class);
        Whizlabs whizlabs = context.getBean(Whizlabs.class);
        whizlabs.printResourceContent();
    }
}
