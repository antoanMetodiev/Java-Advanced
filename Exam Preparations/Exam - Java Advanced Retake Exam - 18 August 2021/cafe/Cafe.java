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

    public void addEmployee(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        return this.employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge())).findFirst().orElse(null);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Employees working at Cafe %s:", this.name));
        this.employees.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });
        return sb.toString();
    }
}
