package spring.basics.bean.finetuning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FineTuningApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(FineTuningConfig.class);
        Creature creature = context.getBean(Creature.class);
        System.out.println(creature.getBird().move());
        System.out.println(creature.getCat().move());
        System.out.println(creature.getDog().move());
        System.out.println(creature.getAnimals());
    }
}
