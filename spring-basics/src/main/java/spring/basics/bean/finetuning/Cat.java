package spring.basics.bean.finetuning;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("catBean")
public class Cat implements Animal{
    @Override
    public String move() {
        return "Jump";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
