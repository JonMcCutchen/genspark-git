package spring.basics.bean.finetuning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Creature {
    private Animal bird;
    private Animal cat;
    private Animal dog;
    private Animal fish;
    private Map<String, Animal> animals;

    public Animal getBird() {
        return bird;
    }

    @Autowired
    public void setBird(Animal bird) {
        this.bird = bird;
    }

    public Animal getCat() {
        return cat;
    }

    @Autowired
    public void setCat(@Qualifier("catBean") Animal cat) {
        this.cat = cat;
    }

    public Animal getDog() {
        return dog;
    }

    @Autowired
    public void setDog(@DogQualifier Animal dog) {
        this.dog = dog;
    }

    public Animal getFish() {
        return fish;
    }

    @Autowired(required = false)
    public void setFish(@Qualifier("fish") Animal fish) {
        this.fish = fish;
    }

    public Map<String, Animal> getAnimals() {
        return animals;
    }

    @Autowired
    public void setAnimals(Map<String, Animal> animals) {
        this.animals = animals;
    }
}
