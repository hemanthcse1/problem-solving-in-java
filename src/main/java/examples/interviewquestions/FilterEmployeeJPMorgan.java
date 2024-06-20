package examples.interviewquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterEmployeeJPMorgan {

    public static void main(String[] args){


        List<Employee>  employees = Arrays.asList(
                new Employee("Hemanth","Software Engineer",3000.0),
                new Employee("Sharath", "Architect",4000.0),
                new Employee("Suchitha","HR",3500.0),
                new Employee("Kumar","Architect",4000.0)
        );

        Map<String,Double> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDesignation,Collectors.summingDouble(Employee::getSalary)));

        for (Map.Entry<String,Double> entry: result.entrySet()){
            System.out.println("Key -> "+entry.getKey()+" : "+entry.getValue());
        }
    }
}
