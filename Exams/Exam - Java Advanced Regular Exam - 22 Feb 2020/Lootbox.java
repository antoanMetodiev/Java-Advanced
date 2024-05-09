import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> firstBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> firstBox.offer(Integer.parseInt(e)));

        Deque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> secondBox.push(Integer.parseInt(e)));

        int allItemSum = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {

            int sum = firstBox.peek() + secondBox.peek();
            if (sum % 2 == 0) {
                allItemSum += sum;
                firstBox.poll();
                secondBox.pop();
            } else {
                int removedEl = secondBox.pop();
                firstBox.offer(removedEl);
            }
        }
        // print Output:
        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (allItemSum >= 100) {
            System.out.print("Your loot was epic! ");
        } else {
            System.out.print("Your loot was poor... ");
        }
        System.out.print("Value: " + allItemSum);
    }
}
