import java.util.Scanner;

public class Bomb {
    private static final Scanner scanner = new Scanner(System.in);
    private static String[][] field;
    private static int currentRow;
    private static int currentCol;

    private static int bombCount;
    private static boolean isDone = false;

    public static void main(String[] args) {
        int sizes = Integer.parseInt(scanner.nextLine());
        field = new String[sizes][sizes];

        String[] commands = scanner.nextLine().split(",");
        fillMatrix();
        searchMyCoordinates();

        for (String command : commands) {
            int previousRow = currentRow;
            int previousCol = currentCol;
            field[currentRow][currentCol] = "+";

            if (command.equals("up")) {
                currentRow--;
            } else if (command.equals("down")) {
                currentRow++;
            } else if (command.equals("left")) {
                currentCol--;
            } else if (command.equals("right")) {
                currentCol++;
            }

            if (!checkIndexesIsValid()) {
                currentRow = previousRow;
                currentCol = previousCol;
                field[currentRow][currentCol] = "s";
                continue;
            }

            if (field[currentRow][currentCol].equals("e")) {
                isDone = true;
                break;
            } else if (field[currentRow][currentCol].equals("B")) {
                bombCount--;
                System.out.println("You found a bomb!");
                if (bombCount == 0) {
                    System.out.println("Congratulations! You found all bombs!");
                }
            }
            field[currentRow][currentCol] = "s";
        }
        // Output:
        if (!isDone && bombCount > 0) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)\n"
                    , bombCount, currentRow, currentCol);
        } else if (isDone && bombCount > 0) {
            System.out.printf("END! %d bombs left on the field", bombCount);
        }
    }

    private static boolean checkIndexesIsValid() {
        if (currentRow < 0 || currentRow >= field.length) {
            return false;
        } else if (currentCol < 0 || currentCol >= field.length) {
            return false;
        }
        return true;
    }

    private static void searchMyCoordinates() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("s")) {
                    currentRow = i;
                    currentCol = j;
                } else if (field[i][j].equals("B")) {
                    bombCount++;
                }
            }
        }
    }

    private static void fillMatrix() {
        for (int i = 0; i < field.length; i++) {
            field[i] = scanner.nextLine().split("\\s+");
        }
    }
}
