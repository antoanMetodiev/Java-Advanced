import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RallyRacing {
    private static final Scanner scanner = new Scanner(System.in);
    private static String[][] field;
    private static int currentRow = 0;
    private static int currentCol = 0;
    private static List<List<Integer>> trapsCoordinates = new ArrayList<>();
    private static int distanceCovered = 0;

    public static void main(String[] args) {
        int sizes = Integer.parseInt(scanner.nextLine());
        field = new String[sizes][sizes];
        String carNumber = scanner.nextLine();
        fillMatrix();
        searchTrapsCoordinates();

        field[0][0] = "C"; // we start always in [0,0];
        String command = scanner.nextLine();
        while (!"End".equals(command)) {

            field[currentRow][currentCol] = ".";
            move(command);
            if (field[currentRow][currentCol].equals("T")) {
                distanceCovered += 30;
                field[currentRow][currentCol] = ".";
                moveAcrossTunnel();
                field[currentRow][currentCol] = "C";
                command = scanner.nextLine();
                continue;
            } else if (field[currentRow][currentCol].equals("F")) {

                distanceCovered += 10;
                field[currentRow][currentCol] = "C";
                System.out.printf("Racing car %s finished the stage!\n", carNumber);
                System.out.printf("Distance covered %d km.\n", distanceCovered);
                printMatrix();
                return;
            }
            distanceCovered += 10;
            field[currentRow][currentCol] = "C";
            command = scanner.nextLine();
        }
        
        // Output:
        System.out.printf("Racing car %s DNF.\n", carNumber);
        System.out.printf("Distance covered %d km.\n", distanceCovered);
        printMatrix();
    }

    private static void printMatrix() {
        for (int i = 0; i < field.length; i++) {
            Arrays.stream(field[i]).forEach(System.out::print);
            System.out.println();
        }
    }

    private static void moveAcrossTunnel() {
        for (int i = 0; i < trapsCoordinates.size(); i++) {
            if ((trapsCoordinates.get(i).get(0) == currentRow)
                    && (trapsCoordinates.get(i).get(1) == currentCol)) {

                trapsCoordinates.remove(i);
                break;
            }
        }
        currentRow = trapsCoordinates.get(0).get(0);
        currentCol = trapsCoordinates.get(0).get(1);
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

    private static void searchTrapsCoordinates() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("T")) {
                    List<Integer> currentTrapCoordinates = new ArrayList<>();
                    currentTrapCoordinates.add(i);
                    currentTrapCoordinates.add(j);
                    trapsCoordinates.add(currentTrapCoordinates);
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
