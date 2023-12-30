package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            checkTokensSizeAndChooseConstructor(tokens, name, salary, position, department, employeeList);
        }

        findAverageDepartmentSalary(employeeList);

    }

    private static void findAverageDepartmentSalary(List<Employee> employeeList) {

        // На финала трябва да принтирам него:
        Map<String, List<Department>> departmentsMap = new LinkedHashMap<>();
        //---------------------------------------------------------------
        for (Employee employee : employeeList) {

            String department = employee.getDepartment();
            if (!departmentsMap.containsKey(department)) {

                departmentsMap.put(department, new ArrayList<>());

                Department dp = new Department(employee.getName(), employee.getSalary(),
                        employee.getEmail(), employee.getAge());

                departmentsMap.get(department).add(dp);
            } else {

                Department dp = new Department(employee.getName(), employee.getSalary(),
                        employee.getEmail(), employee.getAge());

                departmentsMap.get(department).add(dp);
            }
        }


        String biggestSalaryDepartment = "";  // Само с тази променлива ще разберем кой е отдела с най-добра заплатка
        double maxAverageSalary = Double.MIN_VALUE;


        for (Map.Entry<String, List<Department>> department : departmentsMap.entrySet()) {

            String key = department.getKey();
            int currentDepartmentValues = 0;

            double money = 0;
            for (int i = 0; i < department.getValue().size(); i++) {
                money += department.getValue().get(i).getSalary();
            }

            double averageSalary = money / department.getValue().size();
            if (averageSalary > maxAverageSalary) {
                maxAverageSalary = averageSalary;
                biggestSalaryDepartment = key;
            }
        }

        // Output:
        for (Map.Entry<String, List<Department>> department : departmentsMap.entrySet()) {

            String currentDepartment = department.getKey();
            if (currentDepartment.equals(biggestSalaryDepartment)) {

                System.out.println("Highest Average Salary: " + biggestSalaryDepartment);
                department.getValue().stream().sorted((e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                        .forEach(e-> System.out.printf("%s %.2f %s %d\n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
                return;
            }


        }




    }

    private static void checkTokensSizeAndChooseConstructor(String[] tokens, String name, double salary,
                                                            String position, String department, List<Employee> employeeList) {

        Employee employee;
        if (tokens.length == 4) {
            employee = new Employee(name, salary, position, department);
        } else if (tokens.length == 5) {
            employee = checkEmailOrAgeIsFifthEl(tokens, name, salary, position, department);
        } else {
            employee = checkEmailOrAgeIsSixthEl(tokens, name, salary, position, department);
        }
        employeeList.add(employee);
    }

    private static Employee checkEmailOrAgeIsSixthEl(String[] tokens, String name, double salary, String position, String department) {

        String fifthEl = tokens[tokens.length - 2];
        String sixtEl = tokens[tokens.length - 1];

        if (fifthEl.contains("@")) {
            return new Employee(name, salary, position, department, fifthEl, Integer.parseInt(sixtEl));
        }

        return new Employee(name, salary, position, department, sixtEl, Integer.parseInt(fifthEl));
    }

    private static Employee checkEmailOrAgeIsFifthEl(String[] tokens, String name, double salary, String position, String department) {

        String lastEl = tokens[tokens.length - 1];

        if (lastEl.contains("@")) {
            return new Employee(name, salary, position, department, lastEl);
        }

        return new Employee(name, salary, position, department, Integer.parseInt(lastEl));
    }
}
