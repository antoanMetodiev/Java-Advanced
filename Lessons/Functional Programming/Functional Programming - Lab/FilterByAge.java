import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(",\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1]));
            personList.add(person);
        }
        String ageType = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        BiPredicate<Integer, Integer> checkerPredicate;
        if (ageType.equals("older")) {
            checkerPredicate = (e, type) -> e >= type;
        } else {
            checkerPredicate = (e, type) -> e <= type;
        }

        personList = personList.stream().filter(e -> checkerPredicate.test(e.getAge(), age)).collect(Collectors.toList());

        String[] nameOrAge = scanner.nextLine().split("\\s+");
        if (nameOrAge.length > 1) {
            personList.forEach(e -> System.out.printf("%s - %d\n", e.getName(), e.getAge()));
            return;
        }

        if (nameOrAge[0].equals("name")) {
            personList.forEach(e -> System.out.println(e.getName()));
        } else {
            personList.forEach(e -> System.out.println(e.getAge()));
        }
    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
