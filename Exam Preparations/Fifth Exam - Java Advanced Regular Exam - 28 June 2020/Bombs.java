import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> bombEffects = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).forEach(e -> bombEffects.offer(Integer.parseInt(e)));


        Deque<Integer> bombCasing = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).forEach(e -> bombCasing.push(Integer.parseInt(e)));

        int daturaBombs = 0; // 40
        int cherryBombs = 0; // 60
        int smokeDecoyBombs = 0; // 120

        boolean isDone = false;

        while (!bombEffects.isEmpty() && !bombCasing.isEmpty()) {

            int bombResult = bombEffects.peek() + bombCasing.peek();

            boolean isInside = false;
            if (bombResult == 40) {
                daturaBombs++;
                isInside = true;
            } else if (bombResult == 60) {
                cherryBombs++;
                isInside = true;
            } else if (bombResult == 120) {
                smokeDecoyBombs++;
                isInside = true;
            }

            if (!isInside) {
                int decreasedValue = bombCasing.pop() - 5;
                bombCasing.push(decreasedValue);
            } else {
                bombCasing.pop();
                bombEffects.poll();
            }

            // Ако има по 3 бомби от всеки вид:
            if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
                System.out.println("Bene! You have successfully filled the bomb pouch!");
                isDone = true;
                break;
            }

        }

        printOutput(isDone, daturaBombs, cherryBombs, smokeDecoyBombs, bombEffects, bombCasing);


    }

    private static void printOutput(boolean isDone, int daturaBombs, int cherryBombs, int smokeDecoyBombs, Deque<Integer> bombEffects, Deque<Integer> bombCasing) {
        if (!isDone) {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.print("Bomb Effects: ");
        if (!bombEffects.isEmpty()) {
            System.out.println(String.join(", ", bombEffects.toString().replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("empty");
        }

        System.out.print("Bomb Casings: ");
        if (!bombCasing.isEmpty()) {
            System.out.println(String.join(", ", bombCasing.toString().replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("empty");
        }

        // printBombCounts:
        System.out.println("Cherry Bombs: " + cherryBombs);
        System.out.println("Datura Bombs: " + daturaBombs);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBombs);
    }
}
