import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> realNumbers = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            if (realNumbers.containsKey(input[i])) {
                int oldValue = realNumbers.get(input[i]);
                realNumbers.put(input[i], oldValue + 1);
            } else {
                realNumbers.put(input[i], 1);
            }
        }
        realNumbers.forEach((key, value) -> System.out.printf("%.1f -> %d\n", key, value));
    }
}
