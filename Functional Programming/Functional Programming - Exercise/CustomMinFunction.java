import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println(Arrays.stream(scanner.nextLine()
//                .split("\\s+"))
//                .mapToInt(Integer::parseInt).min().orElse(0));

        // Да си прегледам кода внимателно :
        Integer[] numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);
        //------------------------------------------------------->

        Function<Integer[], Integer> findMinNum = arr -> Collections.min(List.of(arr));

        System.out.println(findMinNum.apply(numbers));
    }
}
