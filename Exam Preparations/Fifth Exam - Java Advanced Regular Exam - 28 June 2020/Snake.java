import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Snake {
    // counters:
    private static int currentRow;
    private static int currentCol;
    private static int amountFood; 
    
    private static List<List<Integer>> lairsCoordinates; 
    private static String[][] field;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        field = new String[n][n];

        fillMatrix(field, scanner);
        searchSnakeCoordinates(field);
        searchBedsCoordinates(field);

        boolean isOver = false;
        String command = scanner.nextLine();
        while (amountFood < 10) {

            switch (command) {
                case "up":

                    currentRow--;
                    if (checkIsSnakeLeftField(field)) {
                        System.out.println("Game over!");
                        field[currentRow + 1][currentCol] = ".";
                        isOver = true;
                        break;
                    }

                    String el = field[currentRow][currentCol];
                    if (el.equals("*")) {
                        amountFood++;
                    } else if (el.equals("B")) {
                        field[currentRow + 1][currentCol] = ".";
                        removeLair();
                        field[currentRow][currentCol] = "S";
                    }

                    // Рутинно местене:
                    if (!el.equals("B")) {
                        field[currentRow + 1][currentCol] = ".";
                        field[currentRow][currentCol] = "S";
                    }
                    break;
                case "down":

                    currentRow++;
                    if (checkIsSnakeLeftField(field)) {
                        System.out.println("Game over!");
                        field[currentRow - 1][currentCol] = ".";  // Връщане на позиция
                        isOver = true;
                        break;
                    }

                    el = field[currentRow][currentCol];
                    if (el.equals("*")) {
                        amountFood++;
                    } else if (el.equals("B")) {
                        field[currentRow - 1][currentCol] = ".";  // Връщане на позиция
                        removeLair();
                        field[currentRow][currentCol] = "S";
                    }

                    // Рутинно местене:
                    if (!el.equals("B")) {
                        field[currentRow - 1][currentCol] = ".";
                        field[currentRow][currentCol] = "S";
                    }
                    break;
                case "left":

                    currentCol--;
                    if (checkIsSnakeLeftField(field)) {
                        System.out.println("Game over!");
                        field[currentRow][currentCol + 1] = ".";  // Връщане на позиция
                        isOver = true;
                        break;
                    }

                    el = field[currentRow][currentCol];
                    if (el.equals("*")) {
                        amountFood++;
                    } else if (el.equals("B")) {
                        field[currentRow][currentCol + 1] = ".";  // Връщане на позиция
                        removeLair();
                        field[currentRow][currentCol] = "S";
                    }

                    // Рутинно местене:
                    if (!el.equals("B")) {
                        field[currentRow][currentCol + 1] = ".";
                        field[currentRow][currentCol] = "S";
                    }
                    break;
                case "right":

                    currentCol++;
                    if (checkIsSnakeLeftField(field)) {
                        System.out.println("Game over!");
                        field[currentRow][currentCol - 1] = ".";  // Връщане на позиция
                        isOver = true;
                        break;
                    }

                    el = field[currentRow][currentCol];
                    if (el.equals("*")) {
                        amountFood++;
                    } else if (el.equals("B")) {
                        field[currentRow][currentCol - 1] = ".";  // Връщане на позиция
                        removeLair();
                        field[currentRow][currentCol] = "S";
                    }

                    // Рутинно местене:
                    if (!el.equals("B")) {
                        field[currentRow][currentCol - 1] = ".";
                        field[currentRow][currentCol] = "S";
                    }
                    break;
            }

            if (isOver) {
                break;
            }
            if (amountFood == 10) {
                break;
            }
            
            command = scanner.nextLine();
        }
        // Output:
        if (!isOver) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + amountFood);
        printMatrix();
    }

    private static void printMatrix() {
        for (int i = 0; i < field.length; i++) {
            Arrays.stream(field[i]).forEach(System.out::print);
            System.out.println();
        }
    }

    private static void removeLair() {
        for (int i = 0; i < lairsCoordinates.size(); i++) {
            if (lairsCoordinates.get(i).get(0) == currentRow && lairsCoordinates.get(i).get(1) == currentCol) {
                int row = lairsCoordinates.get(i).remove(0);
                int col = lairsCoordinates.get(i).remove(0);

                field[row][col] = ".";
                lairsCoordinates.remove(i);
            }
        }
        currentRow = lairsCoordinates.get(0).get(0);
        currentCol = lairsCoordinates.get(0).get(1);
    }

    private static void searchBedsCoordinates(String[][] field) {
        lairsCoordinates = new ArrayList<>();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("B")) {
                    List<Integer> coordinates = new ArrayList<>();
                    coordinates.add(i);
                    coordinates.add(j);
                    lairsCoordinates.add(coordinates);
                }
            }
        }
    }

    private static boolean checkIsSnakeLeftField(String[][] field) {
        if (currentRow < 0 || currentRow >= field.length) {
            return true;
        } else if (currentCol < 0 || currentCol >= field.length) {
            return true;
        }
        return false;
    }
    
    private static void searchSnakeCoordinates(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("S")) {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }
    }

    private static void fillMatrix(String[][] field, Scanner scanner) {
        for (int i = 0; i < field.length; i++) {
            field[i] = scanner.nextLine().split("");
        }
    }
}
