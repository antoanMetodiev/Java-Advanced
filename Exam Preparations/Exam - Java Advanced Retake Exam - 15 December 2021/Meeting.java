import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Meeting {
    private static Scanner scanner = new Scanner(System.in);
    private static Deque<Integer> males = new ArrayDeque<>();
    private static Deque<Integer> females = new ArrayDeque<>();

    public static void main(String[] args) {
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> males.push(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> females.offer(Integer.parseInt(e)));
        
        int matchesCount = 0;
        while (!males.isEmpty() && !females.isEmpty()) {
            
            if (males.peek() <= 0) {
                males.pop();
                continue;
            }
            if (females.peek() <= 0) {
                females.poll();
                continue;
            }

            // Special case:
            if (isSpecialCase()) {
                continue;
            }

            if (males.peek().equals(females.peek())) {
                matchesCount++;
                males.pop();
                females.poll();
            } else {
                int decreasedEl = males.pop() - 2;
                males.push(decreasedEl);
                females.poll();
            }
        }
        
        // Output:
        System.out.println("Matches: " + matchesCount);
        System.out.print("Males left: ");
        if (males.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(String.join(", ", males.toString()
                    .replaceAll("[\\[\\]]", "")));
        }

        System.out.print("Females left: ");
        if (females.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(String.join(", ", females.toString()
                    .replaceAll("[\\[\\]]", "")));
        }
    }

    private static boolean isSpecialCase() {
        if (males.peek() % 25 == 0) {
            males.pop();
            if (!males.isEmpty()) {
                males.pop();
            }
            return true;
        }
        
        if (females.peek() % 25 == 0) {
            females.poll();
            if (!females.isEmpty()) {
                females.poll();
            }
            return true;
        }
        return false;
    }
}
