package examples.maps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataTransform {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Hemanth", 50000),
                new Employee("Priyansh", 60000),
                new Employee("Sudhir", 70000)
        );

        List<String> namesWithSalary = employees.stream()
                .map(emp -> emp.getName() + " earns " + emp.getSalary())
                .collect(Collectors.toList());
        System.out.println(namesWithSalary);
    }
}
