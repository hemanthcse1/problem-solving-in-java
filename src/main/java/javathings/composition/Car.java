package javathings.composition;

public class Car {

    private Engine engine;
    private Wheel[] wheels;

    public Car(String engineType, String wheelBrand) {
        this.engine = new Engine(engineType);
        this.wheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            this.wheels[i] = new Wheel(wheelBrand);
        }
    }

    public Engine getEngine() {
        return engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }
}
