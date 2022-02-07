package spring.basics.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigApp {
    public static void main(String[] args) {
        ApplicationContext contextWithLiteModeConfig = new AnnotationConfigApplicationContext(BeanLiteModeConfig.class);
        Name nameWithLiteModeConfig = contextWithLiteModeConfig.getBean(Name.class);
        Person personWithLiteModeConfig = contextWithLiteModeConfig.getBean(Person.class);

        System.out.println(nameWithLiteModeConfig == personWithLiteModeConfig.getName());

        ApplicationContext contextWithFullModeConfig = new AnnotationConfigApplicationContext(BeanFullModeConfig.class);
        Name nameWithFullModeConfig = contextWithFullModeConfig.getBean(Name.class);
        Person personWithFullModeConfig = contextWithFullModeConfig.getBean(Person.class);

        System.out.println(nameWithFullModeConfig == personWithFullModeConfig.getName());
    }
}
