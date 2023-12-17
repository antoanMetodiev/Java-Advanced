import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> words = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            words.add(line);
        }
        words.forEach(System.out::println);
    }
}
