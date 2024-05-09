import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());
        Function<Integer, Integer> removeIfDivideByN = e -> {
            if (e % n != 0) {
                return e;
            }
            return 0;
        };
        numbers = numbers.stream().map(e -> removeIfDivideByN.apply(e)).collect(Collectors.toList());
        Collections.reverse(numbers);
        numbers.stream().filter(e -> e != 0).forEach(e -> System.out.print(e + " "));
    }
}
