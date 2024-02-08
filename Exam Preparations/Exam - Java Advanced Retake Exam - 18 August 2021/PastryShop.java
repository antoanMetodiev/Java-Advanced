import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class PastryShop {
    private static int biscuitCount = 0;
    private static int cakeCount = 0;
    private static int pastryCount = 0;
    private static int pieCount = 0;
    private static Deque<Integer> liquids;
    private static Deque<Integer> ingredients;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(e -> liquids.offer(Integer.parseInt(e)));

        ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(e -> ingredients.push(Integer.parseInt(e)));

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int sum = liquids.peek() + ingredients.peek();

            // Biscuit	25
            //Cake	50
            //Pastry	75
            //Pie	100

            if (sum == 25) {
                biscuitCount++;
            } else if (sum == 50) {
                cakeCount++;
            } else if (sum == 75) {
                pastryCount++;
            } else if (sum == 100) {
                pieCount++;
            } else {

                liquids.poll();
                int increasedEl = ingredients.pop() + 3;
                ingredients.push(increasedEl);
                continue;
            }
            liquids.poll();
            ingredients.pop();
        }
        // Output:
        printTheOutput();
    }

    private static void printTheOutput() {
        if (cakeCount >= 1 && biscuitCount >= 1 && pastryCount >= 1 && pieCount >= 1) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        System.out.print("Liquids left: ");
        if (!liquids.isEmpty()) {
            System.out.println(String.join(", ", liquids.toString().replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("none");
        }

        System.out.print("Ingredients left: ");
        if (!ingredients.isEmpty()) {
            System.out.println(String.join(", ", ingredients.toString().replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("none");
        }

        System.out.println("Biscuit: " + biscuitCount);
        System.out.println("Cake: " + cakeCount);
        System.out.println("Pie: " + pieCount);
        System.out.println("Pastry: " + pastryCount);
    }
}
