package functionalinterfaces;

@FunctionalInterface
public interface GreetingMessage {

    void sendMessage(String message);

    default void defaultMethod(String message){
        System.out.println("Default method message -> "+message);
    }

    public static void staticMethod(String message){
        System.out.println("Static method message -> "+message);
    }
}
