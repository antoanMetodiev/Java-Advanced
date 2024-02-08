import java.util.Arrays;
import java.util.Scanner;

public class FormulaOne {
    private static Scanner scanner = new Scanner(System.in);
    private static String[][] field;
    private static int currentRow;
    private static int currentCol;

    public static void main(String[] args) {
        int sizes = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());
        field = new String[sizes][sizes];
        fillMatrix();
        searchCoordinates();

        boolean isWinner = false;

        for (int i = 0; i < commandsCount; i++) {

            String command = scanner.nextLine();

            int previousRow = currentRow;
            int previousCol = currentCol;

            // .....
            // .P...
            // .B...
            // ..T..
            // .F...

            field[currentRow][currentCol] = ".";
            move(command);
            checkIndexIsValid();

            if (field[currentRow][currentCol].equals("T")) {
                field[previousRow][previousCol] = "P";
                currentRow = previousRow;
                currentCol = previousCol;
                continue;
            }

            if (field[currentRow][currentCol].equals("B")) {
                move(command);
                checkIndexIsValid();
            }

            if (field[currentRow][currentCol].equals("F")) {
                // TODO:
                isWinner = true;
                field[currentRow][currentCol] = "P";
                break;
            }

            field[currentRow][currentCol] = "P";
        }

        if (isWinner) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        // printMatrix:
        Arrays.stream(field).forEach(e -> {
            Arrays.stream(e).forEach(System.out::print);
            System.out.println();
        });
    }

    private static void checkIndexIsValid() {
        if (currentRow < 0) {
            currentRow = field.length - 1;
        } else if (currentRow >= field.length) {
            currentRow = 0;
        }
        if (currentCol < 0) {
            currentCol = field.length - 1;
        } else if (currentCol >= field.length) {
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
                if (field[i][j].equals("P")) {
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
