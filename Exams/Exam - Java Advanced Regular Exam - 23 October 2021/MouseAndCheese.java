import java.util.Arrays;
import java.util.Scanner;

public class MouseAndCheese {
    private static final Scanner scanner = new Scanner(System.in);
    private static String[][] field;
    private static int currentRow;
    private static int currentCol;
    private static int eatenCheeseCount;

    public static void main(String[] args) {
        int sizes = Integer.parseInt(scanner.nextLine());
        field = new String[sizes][sizes];
        fillMatrix();
        searchMouseCoordinates();

        boolean isInside = true;
        String command = scanner.nextLine();
        while (!"end".equals(command)) {

            field[currentRow][currentCol] = "-";
            move(command);
            if (!checkIndexIsValid()) {
                isInside = false;
                System.out.println("Where is the mouse?");
                break;
            }

            if (field[currentRow][currentCol].equals("B")) {
                field[currentRow][currentCol] = "-";
                move(command);
            }

            if (field[currentRow][currentCol].equals("c")) {
                eatenCheeseCount++;
            }

            field[currentRow][currentCol] = "M";
            command = scanner.nextLine();
        }

        // Output:
        if (eatenCheeseCount >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", eatenCheeseCount);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - eatenCheeseCount);
        }
        printMatrix();
    }

    private static void printMatrix() {
        for (int i = 0; i < field.length; i++) {
            Arrays.stream(field[i]).forEach(System.out::print);
            System.out.println();
        }
    }

    private static boolean checkIndexIsValid() {
        if (currentRow < 0 || currentRow >= field.length) {
            return false;
        } else if (currentCol < 0 || currentCol >= field.length) {
            return false;
        }
        return true;
    }

    private static void move(String command) {
        if (command.equals("up")) {
            currentRow--;
        } else if (command.equals("down")) {
            currentRow++;
        } else if (command.equals("left")) {
            currentCol--;
        } else if (command.equals("right")) {
            currentCol++;
        }
    }

    private static void searchMouseCoordinates() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("M")) {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }
    }

    private static void fillMatrix() {
        for (int i = 0; i < field.length; i++) {
            field[i] = scanner.nextLine().split("");
        }
    }
}
