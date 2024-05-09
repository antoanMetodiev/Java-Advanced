import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Cooking {
    // counters:
    private static int breadCount = 0;
    private static int cakeCount = 0;
    private static int pastryCount = 0;
    private static int fruitPieCount = 0;

    private static Deque<Integer> liquids = new ArrayDeque<>();
    private static Deque<Integer> ingredients = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> liquids.offer(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> ingredients.push(Integer.parseInt(e)));

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int sum = liquids.peek() + ingredients.peek();
            if (sum == 25) {
                breadCount++;
                liquids.poll();
                ingredients.pop();
            } else if (sum == 50) {
                cakeCount++;
                liquids.poll();
                ingredients.pop();
            } else if (sum == 75) {
                pastryCount++;
                liquids.poll();
                ingredients.pop();
            } else if (sum == 100){
                fruitPieCount++;
                liquids.poll();
                ingredients.pop();
            } else {
                liquids.poll();
                int increasedEl = ingredients.pop() + 3;
                ingredients.push(increasedEl);
            }
        }
        // Output:
        printOutput();
    }

    private static void printOutput() {
        if (breadCount >= 1 && cakeCount >= 1 && pastryCount >= 1 && fruitPieCount >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        System.out.print("Liquids left: ");
        if (liquids.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(String.join(", ", liquids.toString().replaceAll("[\\[\\]]", "")));
        }

        System.out.print("Ingredients left: ");
        if (ingredients.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(String.join(", ", ingredients.toString().replaceAll("[\\[\\]]", "")));
        }

        System.out.println("Bread: " + breadCount);
        System.out.println("Cake: " + cakeCount);
        System.out.println("Fruit Pie: " + fruitPieCount);
        System.out.println("Pastry: " + pastryCount);
    }
}
