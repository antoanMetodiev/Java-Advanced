package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        return this.employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return this.employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Employees working at Cafe %s:", this.name));

        this.employees.stream().forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });
        return sb.toString();
    }
}
