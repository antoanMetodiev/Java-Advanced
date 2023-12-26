import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).contains(".")) {
                numbers.remove(numbers.get(i));
                i--;
            }
        }
        if (!numbers.isEmpty()) {
            int minNum = numbers.stream().mapToInt(Integer::parseInt).min().getAsInt();
            System.out.println(numbers.lastIndexOf("" + minNum));
        }
    }
}
