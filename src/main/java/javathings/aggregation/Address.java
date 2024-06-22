package javathings.aggregation;

public class Address {
    String street;
    String city;
    String state;
    String zipcode;

    public Address(String street, String city, String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getFullAddress() {
        return street + ", " + city + ", " + state + " - " + zipcode;
    }
}
