import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<Integer, Integer> addOne = e -> e + 1;
        Function<Integer, Integer> multiplyByTwo = e -> e * 2;
        Function<Integer, Integer> substractOne = e -> e - 1;
        Consumer<Integer> printer = e -> System.out.print(e + " ");

        String command = scanner.nextLine();
        while (!"end".equals(command)) {

            switch (command) {
                case "add":
                    numbers = numbers.stream().map(e -> addOne.apply(e)).collect(Collectors.toList());
                    break;
                case "multiply":
                    numbers = numbers.stream().map(e -> multiplyByTwo.apply(e)).collect(Collectors.toList());
                    break;
                case "subtract":
                    numbers = numbers.stream().map(e -> substractOne.apply(e)).collect(Collectors.toList());
                    break;
                case "print":
                    numbers.forEach(e -> printer.accept(e));
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
