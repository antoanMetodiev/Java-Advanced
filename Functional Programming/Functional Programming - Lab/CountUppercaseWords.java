import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .filter(e -> e.charAt(0) >= 65 && e.charAt(0) <= 90).collect(Collectors.toList());

        System.out.println(input.size());
        input.forEach(System.out::println);
    }
}
