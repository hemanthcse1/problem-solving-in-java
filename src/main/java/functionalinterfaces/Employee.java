package functionalinterfaces;

public class Employee {
    private String name;
    private String email;
    private double salary;
    private int id;
    private int age;


    public Employee(int id, String name, String email, double salary, int age){
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
