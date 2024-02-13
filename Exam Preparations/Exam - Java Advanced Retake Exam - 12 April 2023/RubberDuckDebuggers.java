import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class RubberDuckDebuggers {
    private static int darthVaderDucks = 0;
    private static int thorDucks = 0;
    private static int blueRubberDucks = 0;
    private static int yellowRubberDucks = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> times = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> times.offer(Integer.parseInt(e)));

        Deque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> tasks.push(Integer.parseInt(e)));
        while (!times.isEmpty() && !tasks.isEmpty()) {

            int sum = times.peek() * tasks.peek();
            if (sum > 0 && sum <= 60) {
                darthVaderDucks++;
            } else if (sum >= 61 && sum <= 120) {
                thorDucks++;
            } else if (sum >= 121 && sum <= 180) {
                blueRubberDucks++;
            } else if (sum >= 181 && sum <= 240) {
                yellowRubberDucks++;
            } else if (sum > 240) {
                int decreasedValue = tasks.pop() - 2;
                tasks.push(decreasedValue);
                int time = times.poll();
                times.offer(time);
                continue;
            }
            times.poll();
            tasks.pop();
        }
        // Output:
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.println("Darth Vader Ducky: " + darthVaderDucks);
        System.out.println("Thor Ducky: " + thorDucks);
        System.out.println("Big Blue Rubber Ducky: " + blueRubberDucks);
        System.out.println("Small Yellow Rubber Ducky: " + yellowRubberDucks);
    }
}
