package spring.basics.resource.loading;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class LoadingApp {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(LoadingConfig.class);
        Whizlabs whizlabs = context.getBean(Whizlabs.class);
        whizlabs.loadResourceFromClassPath();
        whizlabs.loadResourceFromFileSystem();
    }
}
