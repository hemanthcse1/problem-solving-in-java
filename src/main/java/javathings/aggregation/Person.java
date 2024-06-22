package javathings.aggregation;

public class Person {
    String name;
    int age;
    Address address; // Aggregation

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address.getFullAddress());
    }
}
