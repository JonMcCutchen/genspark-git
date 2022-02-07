package spring.basics.bean.ditype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private final Name name;
    private Address address;
    @Autowired
    private Occupation occupation;

    public Person(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    public Occupation getOccupation() {
        return occupation;
    }
}
