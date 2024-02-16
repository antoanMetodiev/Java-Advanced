import java.util.*;

public class OffroadChallenge {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Deque<Integer> initialFuel = new ArrayDeque<>();
    private static final Deque<Integer> additionalFuelConsum = new ArrayDeque<>();
    private static final Deque<Integer> altitudes = new ArrayDeque<>();
    private static int altitudeCounter = 0;

    public static void main(String[] args) {
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> initialFuel.push(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> additionalFuelConsum.offer(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> altitudes.offer(Integer.parseInt(e)));

        while (!initialFuel.isEmpty() && !additionalFuelConsum.isEmpty() && !altitudes.isEmpty()) {

            int sum = initialFuel.peek() - additionalFuelConsum.peek();
            if (sum >= altitudes.peek()) {
                initialFuel.pop();
                additionalFuelConsum.poll();
                altitudes.poll();
                altitudeCounter++;
                System.out.println("John has reached: Altitude " + altitudeCounter);
            } else {
                printOutput();  // He failed!
                return;
            }
        }

        // The other Output Result: He reached All!
        if (altitudes.isEmpty()) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }
    }

    private static void printOutput() {
        System.out.println("John did not reach: Altitude " + (altitudeCounter + 1));
        System.out.println("John failed to reach the top.");
        if (altitudeCounter > 0) {
            System.out.print("Reached altitudes: ");
            for (int i = 0; i < altitudeCounter; i++) {
                if (i == altitudeCounter - 1) {
                    System.out.printf("Altitude %d", (i + 1));
                    break;
                }
                System.out.printf("Altitude %d, ", (i + 1));
            }
        } else {
            System.out.println("John didn't reach any altitude.");
        }
    }
}
