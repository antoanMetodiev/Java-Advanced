import java.util.Arrays;
import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine()
                .split(",\\s+");

        System.out.println("Count = " + input.length);
        System.out.printf("Sum = %d", Arrays.stream(input).mapToInt(Integer::parseInt).sum());
    }
}
