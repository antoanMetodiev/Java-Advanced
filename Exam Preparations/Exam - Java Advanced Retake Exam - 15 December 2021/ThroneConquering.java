import java.util.Arrays;
import java.util.Scanner;

public class ThroneConquering {
    private static Scanner scanner = new Scanner(System.in);
    private static String[][] field;
    private static int currentRow = -1;
    private static int currentCol = -1;
    private static int myEnergy = 0;

    private static boolean isDead = false;
    private static boolean isFound = false;

    public static void main(String[] args) {
        myEnergy = Integer.parseInt(scanner.nextLine());
        int sizes = Integer.parseInt(scanner.nextLine());
        field = new String[sizes][sizes];
        fillMatrix();
        searchMyCoordinates();

        String command = scanner.nextLine();
        while (true) {

            field[currentRow][currentCol] = "-";
            move(command.split("\\s+")[0], Integer.parseInt(command.split("\\s+")[1]),
                    Integer.parseInt(command.split("\\s+")[2]));

            myEnergy--;
            if (!checkIndexIsValid()) {
                field[currentRow][currentCol] = "P";
                if (myEnergy <= 0) {
                    field[currentRow][currentCol] = "X";
                    isDead = true;
                    break;
                }
                // Това continue може и да не трябва да е тук!
                command = scanner.nextLine();
                continue;
            }

            if (myEnergy <= 0) {
                field[currentRow][currentCol] = "X";
                isDead = true;
                break;
            }

            if (field[currentRow][currentCol].equals("S")) {

                myEnergy -= 2;
                if (myEnergy <= 0) {
                    field[currentRow][currentCol] = "X";
                    isDead = true;
                    break;
                }
                field[currentRow][currentCol] = "P";

            } else if (field[currentRow][currentCol].equals("H")) {

                isFound = true; // Helena is founded!
                field[currentRow][currentCol] = "-";
                break;

            } else if (field[currentRow][currentCol].equals("-")) {
                field[currentRow][currentCol] = "P";
            }

            command = scanner.nextLine();
        }

        // Output:
        if (isFound) {
            System.out.print("Paris has successfully abducted Helen! ");
            System.out.println("Energy left: " + myEnergy);
        } else {
            System.out.printf("Paris died at %d;%d.\n", currentRow, currentCol);
        }
        printMatrix();
    }

    private static void fillMatrix() {
        for (int i = 0; i < field.length; i++) {
            field[i] = scanner.nextLine().split("");
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < field.length; i++) {
            Arrays.stream(field[i]).forEach(System.out::print);
            System.out.println();
        }
    }

    private static boolean checkIndexIsValid() {
        if (currentRow < 0) {
            currentRow = 0;
            return false;
        } else if (currentRow >= field.length) {
            currentRow = field.length - 1;
            return false;
        }
        if (currentCol < 0) {
            currentCol = 0;
            return false;
        } else if (currentCol >= field.length) {
            currentCol = field.length - 1;
            return false;
        }
        return true;
    }

    private static void move(String command, int enemyRow, int enemyCol) {
        field[enemyRow][enemyCol] = "S";
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

    private static void searchMyCoordinates() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("P")) {
                    currentRow = i;
                    currentCol = j;
                    return;
                }
            }
        }
    }
}
