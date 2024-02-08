package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    //⦁	Method addEmployee(Employee employee) – adds an entity to the data if there is room for him/her.
    public void addEmployee(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    //⦁	Method removeEmployee(String name) – removes an employee by given name, if such exists, and returns a bool.
    public boolean removeEmployee(String name) {
        return this.employees.removeIf(e -> e.getName().equals(name));
    }

    //⦁	Method getOldestEmployee() – returns the oldest employee.

    // TODO: moje i da ne raboti .max();
    public Employee getOldestEmployee() {
        return this.employees.stream().sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge())).findFirst().orElse(null);
    }

    //⦁	Method getEmployee(string name) – returns the employee with the given name.

    // TODO: MOJE DA E GRESHNO
    public Employee getEmployee(String name) {
        return this.employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    //⦁	Getter getCount() – returns the number of employees.
    public int getCount() {
        return this.employees.size();
    }

    //⦁	report() – returns a string in the following format:
    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Employees working at Cafe %s:", this.name));
        this.employees.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });
        return sb.toString();
    }
}
