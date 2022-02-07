package spring.basics.bean.profile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ProfileApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ProfileConfig.class);
        context.getEnvironment().setActiveProfiles("dev", "prod");
        context.refresh();
        Arrays.stream(context.getBeanDefinitionNames())
                .filter(beanName -> !beanName.startsWith("org.springframework.context"))
                .filter(beanName -> !beanName.equals("profileConfig"))
                .forEach(System.out::println);


    }
}
