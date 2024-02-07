import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class AutumnCocktails {
    private static int pearSour = 0;
    private static int theHarvest = 0;
    private static int appleHinny = 0;
    private static int highFashion = 0;
    private static Deque<Integer> ingredients;
    private static Deque<Integer> freshness;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> ingredients.offer(Integer.parseInt(e)));

        freshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> freshness.push(Integer.parseInt(e)));
        while (!ingredients.isEmpty() && !freshness.isEmpty()) {

            int sum = ingredients.peek() * freshness.peek();
            if (ingredients.peek() == 0) {
                ingredients.poll();
                continue;
            }

            if (sum == 150) {
                pearSour++;
            } else if (sum == 250) {
                theHarvest++;
            } else if (sum == 300) {
                appleHinny++;
            } else if (sum == 400) {
                highFashion++;
            } else {
                int increasedEl = ingredients.poll() + 5;
                ingredients.offer(increasedEl);
                freshness.pop();
                continue;
            }
            ingredients.poll();
            freshness.pop();
        }
        // Output:
        printOutput();
    }

    private static void printOutput() {
        if (pearSour >= 1 && theHarvest >= 1 && appleHinny >= 1 && highFashion >= 1) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int ingredientsSum = ingredients.stream().mapToInt(e -> e).sum();
        if (ingredientsSum > 0) {
            System.out.println("Ingredients left: " + ingredientsSum);
        }

        if (appleHinny >= 1) {
            System.out.println("# Apple Hinny --> " + appleHinny);
        }
        if (highFashion >= 1) {
            System.out.println("# High Fashion --> " + highFashion);
        }
        if (pearSour >= 1) {
            System.out.println("# Pear Sour --> " + pearSour);
        }
        if (theHarvest >= 1) {
            System.out.println("# The Harvest --> " + theHarvest);
        }
    }
}
