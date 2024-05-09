import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> compounds = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Arrays.stream(scanner.nextLine()
                            .split("\\s+"))
                    .forEach(e -> compounds.add(e));
        }
        compounds.forEach(e -> System.out.print(e + " "));
    }
}
