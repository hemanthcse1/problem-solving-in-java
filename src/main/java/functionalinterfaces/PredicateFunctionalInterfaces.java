package functionalinterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFunctionalInterfaces {

    public static void main(String[] args) {


        // Predicate
        // original Predicate interface
        Predicate<Integer> integerPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        System.out.println(integerPredicate.test(4));


        System.out.println("\n-------------------------\n");


        // using lambda
        Predicate<Integer> predicate = n -> n % 2 == 0;
        System.out.println(predicate.test(5));


        List<Integer> integers = new ArrayList<>(Arrays.asList(2, 5, 4, 6, 3, 7, 9, 8));
        List<Integer> collect = integers.stream()
                .filter(x -> x % 2 == 0)
                .toList();

        for (Integer i: collect){
            System.out.print(i+", ");
        }

        System.out.println("\n-------------------------\n");
        /*In this example, we'll filter a list of strings to find those that are longer than a certain length */

        List<String> names = Arrays.asList("Hemanth","Kumar", "Teja","Anil", "Kiran","Harish");

        Predicate<String> lengthGreaterThanFive = s -> s.length() >= 5;
        Predicate<String> startWithH = s -> s.startsWith("H");

        Predicate<String> lengthAndFilter = lengthGreaterThanFive.and(startWithH);
        Predicate<String> lengthOrFilter = lengthGreaterThanFive.or(startWithH);

        List<String> filteredNames = names.stream()
                .filter(lengthOrFilter)
                .toList();

        for (String s: filteredNames){
            System.out.println(s);
        }


        Predicate<String> isEqualToHemanth = Predicate.isEqual("Hemanth");

        List<String> nameFilter = names.stream()
                .filter(isEqualToHemanth)
                .toList();

        System.out.println(nameFilter);

        // using custom class filtering


        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Hemanth","hemanth@gmail.com",600000,32));
        employees.add(new Employee(2,"Kumar","Kumar@gmail.com",500000,31));
        employees.add(new Employee(3, "Anil","anil@gmail.com",400000,27));
        employees.add(new Employee(4, "Kiran","kiran@gmail.com",70000,27));
        employees.add(new Employee(5,"Teja","teja@gmail.com",937493,21));

        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> ((e.getSalary() >= 500000) && (e.getAge() > 30)))
                .toList();

        for (Employee e: filteredEmployees){
            System.out.println("Name -> "+e.getName());
        }




    }
}
