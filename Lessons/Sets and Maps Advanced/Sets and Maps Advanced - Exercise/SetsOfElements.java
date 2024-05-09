import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<String> firstGroup = new LinkedHashSet<>();
        Set<String> secondGroup = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            firstGroup.add(scanner.nextLine());
        }
        for (int i = 0; i < m; i++) {
            secondGroup.add(scanner.nextLine());
        }
        firstGroup.retainAll(secondGroup);  
        firstGroup.forEach(e -> System.out.print(e + " "));
    }
}
