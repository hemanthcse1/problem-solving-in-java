package javathings.composition;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("V8", "Michelin");
        System.out.println("Engine Type: " + car.getEngine().getType());
        for (Wheel wheel : car.getWheels()) {
            System.out.println("Wheel Brand: " + wheel.getBrand());
        }
    }
}
