import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputs = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        while (!inputs.equals("Home")) {

            if (inputs.equals("back")) {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                    inputs = scanner.nextLine();
                    continue;
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            } else {
                stack.push(inputs);
                System.out.println(inputs);
            }
            inputs = scanner.nextLine();
        }
    }
}
