package spring.basics.containerandbean;

public class Address {
    private int number;
    private String street;

    public Address(int number, String street) {
        this.number = number;
        this.street = street;
    }

    @Override
    public String toString() {
        return number + "  " + street;
    }
}
