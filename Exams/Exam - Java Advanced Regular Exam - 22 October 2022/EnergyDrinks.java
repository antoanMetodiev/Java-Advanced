import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> mgCaffeine = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).forEach(e -> mgCaffeine.push(Integer.parseInt(e.trim())));

        Deque<Integer> energyDrinks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).forEach(e -> energyDrinks.offer(Integer.parseInt(e.trim())));
        int drinkedCaffeine = 0;
        while (!mgCaffeine.isEmpty() && !energyDrinks.isEmpty()) {

            int sum = mgCaffeine.peek() * energyDrinks.peek();
            if ((sum + drinkedCaffeine) <= 300) {
                drinkedCaffeine += sum;
                mgCaffeine.pop();
                energyDrinks.poll();
            } else {

                mgCaffeine.pop();
                int removedEl = energyDrinks.poll();
                energyDrinks.offer(removedEl);
                if ((drinkedCaffeine - 30) < 0) {
                    drinkedCaffeine = 0;
                } else {
                    drinkedCaffeine -= 30;
                }
            }
        }
        
        // Output:
        if (!energyDrinks.isEmpty()) {
            System.out.print("Drinks left: ");
            System.out.println(String.join(", ", energyDrinks.toString())
                    .replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", drinkedCaffeine);
    }
}
