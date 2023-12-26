import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 1; i <= n; i++) {
            if (checkNumberValidation(i, numbers)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean checkNumberValidation(int i, List<Integer> numbers) {
        for (int j = 0; j < numbers.size(); j++) {
            int num = numbers.get(j);
            if (!(i % num == 0)) {
                return false;
            }
        }
        return true;
    }
}
