import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> dataStack = new ArrayDeque<>();
        for (int i = input.length - 1; i >= 0; i--) {
            dataStack.push(input[i]);
        }

        int sum = 0;
        int counter = 0;
        while (!dataStack.isEmpty()) {

            counter++;
            if (counter == 1) {
                sum += Integer.parseInt(dataStack.remove());
                continue;
            }

            switch (dataStack.peek()) {
                case "+":
                    dataStack.pop();
                    sum += Integer.parseInt(dataStack.pop());
                    break;
                case "-":
                    dataStack.pop();
                    sum -= Integer.parseInt(dataStack.pop());
                    break;
            }
        }
        System.out.println(sum);
    }
}
