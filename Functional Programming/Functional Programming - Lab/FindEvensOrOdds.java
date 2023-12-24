import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int start = data[0];
        int end = data[1];
        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }

        Predicate<Integer> predicate;
        String type = scanner.nextLine(); // Even or Odd
        if (type.equals("even")) {
            predicate = e -> e % 2 == 0;
        } else {
            predicate = e -> e % 2 != 0;
        }

        Consumer<Integer> printer = e -> System.out.print(e + " ");
        numbers.stream().filter(predicate).forEach(printer);
    }
}
