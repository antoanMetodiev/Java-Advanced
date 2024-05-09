import java.util.Scanner;

public class TheSquirrel {
    private static Scanner scanner = new Scanner(System.in);
    private static String[][] field;
    private static int currentRow;
    private static int currentCol;
    private static int hazelCount = 0;
    private static boolean isInside = true;

    public static void main(String[] args) {
        int sizes = Integer.parseInt(scanner.nextLine());
        field = new String[sizes][sizes];
        String[] commands = scanner.nextLine().split(",\\s+");
        fillMatrix();
        searchMyCoordinates();

        for (int i = 0; i < commands.length; i++) {

            field[currentRow][currentCol] = "*";
            move(commands[i]);
            if (!checkIndexIsValid()) {
                System.out.println("The squirrel is out of the field.");
                System.out.println("Hazelnuts collected: " + hazelCount);
                return;
            } else if (field[currentRow][currentCol].equals("h")) {
                
                hazelCount++;
                if (hazelCount == 3) {
                    System.out.println("Good job! You have collected all hazelnuts!");
                    System.out.println("Hazelnuts collected: " + hazelCount);
                    return;
                }
                
            } else if (field[currentRow][currentCol].equals("t")) {
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                System.out.println("Hazelnuts collected: " + hazelCount);
                return;
            }
            field[currentRow][currentCol] = "s";
        }
        // Output:
        if (hazelCount < 3 && isInside) {
            System.out.println("There are more hazelnuts to collect.");
            System.out.println("Hazelnuts collected: " + hazelCount);
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

    private static boolean checkIndexIsValid() {
        if (currentRow < 0 || currentRow >= field.length) {
            return false;
        } else if (currentCol < 0 || currentCol >= field.length) {
            return false;
        }
        return true;
    }


    private static void fillMatrix() {
        for (int i = 0; i < field.length; i++) {
            field[i] = scanner.nextLine().split("");
        }
    }

    private static void searchMyCoordinates() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("s")) {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }
    }
}
