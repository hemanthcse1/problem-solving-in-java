package functionalinterfaces;

public class FunctionalInterfaceBasics {

    public static void main(String[] args){

        GreetingMessage greetingMessage = message -> System.out.println("Message is -> "+message);
        greetingMessage.sendMessage("Hello Hemanth");

        greetingMessage.defaultMethod("this is default method call -> ");
        GreetingMessage.staticMethod("Static method");


        MathAdd mathAdd = (a, b) -> a+b;
        System.out.println("Sum of 2 give numbers is = "+mathAdd.add(5,10));

    }
}
