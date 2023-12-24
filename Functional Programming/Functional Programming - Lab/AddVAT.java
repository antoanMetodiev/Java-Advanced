import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Double, Double> addTwentyPercent = e -> e += e * 0.20;


        List<Double> digits = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(addTwentyPercent)
                .collect(Collectors.toList());

        System.out.println("Prices with VAT:");
        digits.forEach(e -> System.out.printf("%.2f\n", e));
    }
}
