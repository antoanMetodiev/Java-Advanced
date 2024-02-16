import java.util.Scanner;

public class FishingCompetition {
    private static final Scanner scanner = new Scanner(System.in);
    private static char[][] field;
    private static int currentRow;
    private static int currentCol;
    private static int fishingIncome = 0;
    private static boolean isDoneIt = false;

    public static void main(String[] args) {
        int sizes = Integer.parseInt(scanner.nextLine());
        field = new char[sizes][sizes];
        fillMatrix();
        searchCoordinates();

        String command = scanner.nextLine();
        while (!"collect the nets".equals(command)) {

            field[currentRow][currentCol] = '-';
            move(command);
            checkIndexIsValid();
            if (field[currentRow][currentCol] == 'W') {
                System.out.printf("You fell into a whirlpool! " +
                        "The ship sank and you lost the fish you caught. " +
                        "Last coordinates of the ship: [%d,%d]", currentRow, currentCol);
                return;
            } else if (Character.isDigit(field[currentRow][currentCol])) {
                fishingIncome += Integer.parseInt("" + field[currentRow][currentCol]);
                field[currentRow][currentCol] = 'S';
            }

            field[currentRow][currentCol] = 'S';
            command = scanner.nextLine();
        }

        // Output:
        if (fishingIncome >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.\n", 20 - fishingIncome);
        }

        if (fishingIncome > 0) {
            System.out.printf("Amount of fish caught: %d tons.\n", fishingIncome);
        }
        printMatrix();
    }

    private static void printMatrix() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    private static void checkIndexIsValid() {
        if (currentRow < 0) {
            currentRow = field.length - 1;
        } else if (currentRow >= field.length) {
            currentRow = 0;
        }

        if (currentCol < 0) {
            currentCol = field[0].length - 1;
        } else if (currentCol >= field[0].length) {
            currentCol = 0;
        }
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

    private static void searchCoordinates() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'S') {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }
    }

    private static void fillMatrix() {
        for (int i = 0; i < field.length; i++) {
            field[i] = scanner.nextLine().toCharArray();
        }
    }
}
