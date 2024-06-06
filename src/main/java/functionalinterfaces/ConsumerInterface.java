package functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerInterface {

    public static void main(String[] args){

        List<String> names = Arrays.asList("Hemanth","Kumar","Kushal","Priyansh","Micheal","Andrea");


        // original predicate interface
        Consumer<String> consumerNames = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumerNames.accept("Hemanth");


        // using lambda
        Consumer<String> myName = s -> System.out.println(s);
        myName.accept("Hemanth");


        System.out.println("\n-------------------------\n");
        // print names using forEach
        printNames(names);

        System.out.println("\n-------------------------\n");
        // modify the data and collect
        modifyData(names);


        System.out.println("\n-------------------------\n");
        // print name and length
        nameAndLength(names);


    }

    public static void printNames(List<String> names){

         names.stream()
                .forEach(System.out::println);

    }

    public static void modifyData(List<String> names){

        names.stream()
                .map(String::toUpperCase)
                .peek(System.out::println)
                .toList();
    }

    public static void nameAndLength(List<String> names){

        Consumer<String> name = System.out::print;
        Consumer<String> length = s -> System.out.println(" -> "+s.length());

        Consumer<String> nameAndLength = name.andThen(length);

        names.stream()
                .forEach(nameAndLength);
    }
}
