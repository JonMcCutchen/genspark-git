package spring.basics.bean.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class Person {
    private Name name;
    private Address address;
    private int age;

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

    public int getAge() {
        return age;
    }

    @Autowired
    public void setAge(Environment environment) {
        this.age = environment.getProperty("age", Integer.class, 0);
    }
}
