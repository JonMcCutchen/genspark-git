package spring.basics.bean.finetuning;

import org.springframework.stereotype.Component;

@Component
@DogQualifier
public class Dog implements Animal{
    @Override
    public String move() {
        return "Run";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
