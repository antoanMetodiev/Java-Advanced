import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> firstCollection = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(e -> "" + e)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", firstCollection));

        System.out.println(String.join(", ", firstCollection.stream()
                .map(Integer::parseInt)
                .sorted((n1, n2) -> Integer.compare(n1, n2))
                .map(e-> "" + e).collect(Collectors.toList())));
    }
}
