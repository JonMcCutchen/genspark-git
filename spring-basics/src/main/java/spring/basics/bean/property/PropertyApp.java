package spring.basics.bean.property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertyApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PropertyConfig.class);
        PropertyBean propertyBean = context.getBean(PropertyBean.class);
        System.out.println(propertyBean.getCourse());
        System.out.println(propertyBean.getPublishedYear());
    }
}
