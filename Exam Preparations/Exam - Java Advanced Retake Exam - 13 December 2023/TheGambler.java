import java.util.Arrays;
import java.util.Scanner;

public class TheGambler {
    private static final Scanner scanner = new Scanner(System.in);
    private static String[][] field;
    private static int currentRow;
    private static int currentCol;
    private static int beginMoney = 100;

    public static void main(String[] args) {
        int sizes = Integer.parseInt(scanner.nextLine());
        field = new String[sizes][sizes];
        fillMatrix();
        searchMyCoordinates();

        String command = scanner.nextLine();
        while (!"end".equals(command)) {

            field[currentRow][currentCol] = "-";
            move(command);
            if (!checkIndexIsValid()) {
                System.out.println("Game over! You lost everything!");
                return;
            } else if (field[currentRow][currentCol].equals("W")) {
                beginMoney += 100;
            } else if (field[currentRow][currentCol].equals("P")) {

                beginMoney -= 200;
                if (beginMoney <= 0) {
                    System.out.println("Game over! You lost everything!");
                    return;
                }

            } else if (field[currentRow][currentCol].equals("J")) {
                beginMoney += 100000;
                field[currentRow][currentCol] = "G";
                System.out.println("You win the Jackpot!");
                System.out.printf("End of the game. Total amount: %d$\n", beginMoney);
                printMatrix();
                return;
            }

            field[currentRow][currentCol] = "G";
            command = scanner.nextLine();
        }

        // Output:
        if (beginMoney > 0) {
            System.out.printf("End of the game. Total amount: %d$\n", beginMoney);
            printMatrix();
        }
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
        } else if (currentCol < 0 || currentCol >= field[0].length) {
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

    private static void searchMyCoordinates() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("G")) {
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
