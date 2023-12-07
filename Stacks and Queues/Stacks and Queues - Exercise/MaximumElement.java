import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stackNumbers = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            String[] data = scanner.nextLine().split(" ");
            String command = data[0];

            switch (command) {
                case "1":

                    int number = Integer.parseInt(data[1]);
                    stackNumbers.push(number);

                    break;
                case "2":

                    stackNumbers.pop();

                    break;
                case "3":

                    System.out.println(Collections.max(stackNumbers));

                    break;
            }
        }
    }
}
