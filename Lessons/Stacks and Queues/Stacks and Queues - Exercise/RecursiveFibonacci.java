import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Deque<Long> stack = new ArrayDeque<>();
        stack.push(1L);
        stack.push(1L);
        for (int i = 0; i < n - 1; i++) {

            long secondEl = stack.pop();
            long firstEl = stack.pop();
            long newLastEl = firstEl + secondEl;

            stack.push(firstEl);
            stack.push(secondEl);
            stack.push(newLastEl);
        }
        System.out.println(stack.pop());
    }
}
