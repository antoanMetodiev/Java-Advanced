import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String[]> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] grades = scanner.nextLine().split("\\s+");
            double averageGrade = 0;
            students.put(name, grades);
        }
        DecimalFormat df = new DecimalFormat("0.###################");
        students.entrySet().forEach(e -> {
            double averageGrade = 0;
            int gradeCount = 0;
            for (String el : e.getValue()) {
                averageGrade += Double.parseDouble(el);
                gradeCount++;
            }
            System.out.printf("%s is graduated with %s\n", e.getKey(), df.format(averageGrade / gradeCount));
        });
    }
}
