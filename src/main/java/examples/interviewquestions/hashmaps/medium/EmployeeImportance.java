package examples.interviewquestions.hashmaps.medium;


import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee emp : employees) {
            employeeMap.put(emp.id, emp);
        }

        int totalImportance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);

        while (!queue.isEmpty()) {
            int currentId = queue.poll();
            Employee employee = employeeMap.get(currentId);
            totalImportance += employee.importance;
            for (int subId : employee.subordinates) {
                queue.offer(subId);
            }
        }

        return totalImportance;
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.id = 1;
        emp1.importance = 5;
        emp1.subordinates = Arrays.asList(2, 3);

        Employee emp2 = new Employee();
        emp2.id = 2;
        emp2.importance = 3;
        emp2.subordinates = new ArrayList<>();

        Employee emp3 = new Employee();
        emp3.id = 3;
        emp3.importance = 3;
        emp3.subordinates = new ArrayList<>();

        List<Employee> employees = Arrays.asList(emp1, emp2, emp3);

        EmployeeImportance importance = new EmployeeImportance();
        int result = importance.getImportance(employees, 1);

        System.out.println("Total importance for employee with ID 1: " + result);
    }
}
