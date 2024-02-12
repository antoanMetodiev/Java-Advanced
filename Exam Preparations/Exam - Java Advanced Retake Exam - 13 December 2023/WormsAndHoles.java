import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class WormsAndHoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> worms = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> worms.push(Integer.parseInt(e)));

        Deque<Integer> holes = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> holes.offer(Integer.parseInt(e)));
        int matches = 0;
        int beginWormsCount = worms.size();
        while (!worms.isEmpty() && !holes.isEmpty()) {

            if (worms.peek().equals(holes.peek())) {
                matches++;
                worms.pop();
                holes.poll();
            } else {
                holes.poll();
                int decreasedEl = worms.pop() - 3;
                if (decreasedEl > 0) {
                    worms.push(decreasedEl);
                }
            }
        }

        // Output:
        if (matches > 0) {
            System.out.println("Matches: " + matches);
        } else {
            System.out.println("There are no matches.");
        }

        if (worms.isEmpty() && beginWormsCount == matches) {
            System.out.println("Every worm found a suitable hole!");
        } else {
            System.out.print("Worms left: ");
            if (!worms.isEmpty()) {
                int wormSize = worms.size();
                for (int i = 0; i < wormSize; i++) {
                    if (i == wormSize - 1) {
                        System.out.printf("%s\n",worms.pollFirst());
                        break;
                    }
                    System.out.printf("%s, ", worms.pollLast());
                }
            } else {
                System.out.println("none");
            }
        }

        System.out.print("Holes left: ");
        if (!holes.isEmpty()) {
            System.out.println(String.join(", ", holes.toString().replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("none");
        }
    }
}
