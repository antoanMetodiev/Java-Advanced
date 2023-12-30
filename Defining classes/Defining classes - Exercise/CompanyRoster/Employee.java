package CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department) { // Ако size-a на tokens[] е == 4
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public Employee(String name, double salary, String position, String department, String email, int age) { 
        this(name, salary, position, department);                                                        
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, int age, String email) { 
        this(name, salary, position, department);                                                        
        this.age = age;
        this.email = email;
    }

    public Employee(String name, double salary, String position, String department, String email) { 
        this(name, salary, position, department);
        this.email = email;
        this.age = -1;
    }

    public Employee(String name, double salary, String position, String department, int age) { 
        this(name, salary, position, department);
        this.age = age;
        this.email = "n/a";
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
