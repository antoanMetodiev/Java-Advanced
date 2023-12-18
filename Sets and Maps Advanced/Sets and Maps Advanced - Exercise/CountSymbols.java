import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        Map<Character, Integer> charMap = new TreeMap<>();
        for (int i = 0; i < input.length; i++) {

            if (!charMap.containsKey(input[i])) {
                charMap.put(input[i], 1);
            } else {
                int oldValue = charMap.get(input[i]);
                charMap.put(input[i], ++oldValue);
            }
        }
        charMap.forEach((key, value) -> System.out.printf("%c: %d time/s\n", key, value));
    }
}
