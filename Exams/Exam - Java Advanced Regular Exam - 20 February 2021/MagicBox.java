import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> firstBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> firstBox.offer(Integer.parseInt(e)));

        Deque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> secondBox.push(Integer.parseInt(e)));

        int collectionSum = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            if ((firstBox.peek() + secondBox.peek()) % 2 == 0) {
                collectionSum += firstBox.peek() + secondBox.peek();
                firstBox.poll();
                secondBox.pop();
            } else {
                firstBox.offer(secondBox.pop());
            }
        }
        // Output:
        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (collectionSum >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + collectionSum);
        } else {
            System.out.println("Poor prey... Value: " + collectionSum);
        }
    }
}
