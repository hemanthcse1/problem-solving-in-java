package javathings.aggregation;

public class AggregationExample {
    public static void main(String[] args) {
        Address address = new Address("123 Main St", "Hyderabad", "Telangana", "500001");
        Person person = new Person("Hemanth Kumar", 30, address);

        person.displayPersonInfo();
    }
}
