import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen {
    private static Scanner scanner = new Scanner(System.in);
    private static String[][] field;
    private static int currentRow;
    private static int currentCol;
    private static int cheeseCount;

    public static void main(String[] args) {
        String[] sizes = scanner.nextLine().split(",");
        field = new String[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];
        fillMatrix();
        searchMyCoordinates();
        searchCheese();

        String command = scanner.nextLine();
        int previousRow = currentRow;
        int previousCol = currentCol;
        while (!"danger".equals(command)) {

            if (!field[currentRow][currentCol].equals("@")) {
                field[currentRow][currentCol] = "*";
            } else {
                command = scanner.nextLine();
                continue;
            }

            move(command);
            if (!checkIndexIsValid()) {
                field[previousRow][previousCol] = "M";
                System.out.println("No more cheese for tonight!");
                printMatrix();
                return;
            }

            if (field[currentRow][currentCol].equals("T")) {
                System.out.println("Mouse is trapped!");
                field[currentRow][currentCol] = "M";
                printMatrix();
                return;
            }

            if (field[currentRow][currentCol].equals("C")) {
                cheeseCount--;
                if (cheeseCount == 0) {
                    field[currentRow][currentCol] = "M";
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    printMatrix();
                    return;
                }
            }

            if (field[currentRow][currentCol].equals("@")) {
                field[previousRow][previousCol] = "M";
                currentRow = previousRow;
                currentCol = previousCol;
                command = scanner.nextLine();
                continue;
            }

            field[currentRow][currentCol] = "M";
            previousRow = currentRow;
            previousCol = currentCol;
            command = scanner.nextLine();
        }
        // Custom Output:
        System.out.println("Mouse will come back later!");
        printMatrix();
    }

    private static void printMatrix() {
        for (int i = 0; i < field.length; i++) {
            Arrays.stream(field[i]).forEach(System.out::print);
            System.out.println();
        }
    }

    private static void searchCheese() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("C")) {
                    cheeseCount++;
                }
            }
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
