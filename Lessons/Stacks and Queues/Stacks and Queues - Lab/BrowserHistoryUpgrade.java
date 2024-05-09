import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Deque<String> stack = new ArrayDeque<>();
        Deque<String> forwardUrl = new ArrayDeque<>();
        while (!line.equals("Home")) {
            switch (line) {
                case "back":
                    if (stack.size() <= 1) {
                        System.out.println("no previous URLs");
                    } else {
                        forwardUrl.push(stack.pop());
                        System.out.println(stack.peek());
                    }
                    break;
                case "forward":
                    if (forwardUrl.isEmpty()) {
                        System.out.println("no next URLs");
                    } else {
                        stack.push(forwardUrl.pop());
                        System.out.println(stack.peek());
                    }
                    break;
                default:
                    stack.push(line);
                    forwardUrl.clear();
                    System.out.println(line);
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
