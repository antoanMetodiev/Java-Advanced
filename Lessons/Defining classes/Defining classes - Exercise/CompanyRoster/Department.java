package CompanyRoster;

public class Department {
    private String name;
    private double salary;
    private String email;
    private int age;

    public Department(String name, double salary, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
