import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNames = scanner.nextLine().split("\\s+");

        Consumer<String> printer = e -> System.out.println("Sir " + e);

        Arrays.stream(inputNames).forEach(printer);

    }
}
