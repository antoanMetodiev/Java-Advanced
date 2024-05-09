import java.util.Arrays;
import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];
        fillMatrix(matrix, scanner);

        int[] myCoordinates = returnCoordinates(matrix);
        int currentRow = myCoordinates[0];
        int currentCol = myCoordinates[1];

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            String el = "";
            switch (command) {
                case "up":

                    currentRow--;
                    if (!(validateRowAndCol(currentRow, currentCol, n))) {
                        word = word.substring(0, word.length() - 1);
                        currentRow++;
                        command = scanner.nextLine();
                        continue;
                    }

                    el = matrix[currentRow][currentCol];
                    char symbol = el.charAt(0);
                    if (el.equals("-")) {
                        matrix[currentRow + 1][currentCol] = "-";
                        matrix[currentRow][currentCol] = "P";
                    } else if (validateSymbol(symbol)) {
                        word += el;
                        matrix[currentRow + 1][currentCol] = "-";
                        matrix[currentRow][currentCol] = "P";
                    }
                    break;
                case "right":

                    currentCol++;
                    if (!(validateRowAndCol(currentRow, currentCol, n))) {
                        word = word.substring(0, word.length() - 1);
                        currentCol--;
                        command = scanner.nextLine();
                        continue;
                    }

                    el = matrix[currentRow][currentCol];
                    symbol = el.charAt(0);
                    if (el.equals("-")) {
                        matrix[currentRow][currentCol - 1] = "-";
                        matrix[currentRow][currentCol] = "P";
                    } else if (validateSymbol(symbol)) {
                        word += el;
                        matrix[currentRow][currentCol - 1] = "-";
                        matrix[currentRow][currentCol] = "P";
                    }
                    break;
                case "left":

                    currentCol--;
                    if (!(validateRowAndCol(currentRow, currentCol, n))) {
                        word = word.substring(0, word.length() - 1);
                        currentCol++;
                        command = scanner.nextLine();
                        continue;
                    }

                    el = matrix[currentRow][currentCol];
                    symbol = el.charAt(0);
                    if (el.equals("-")) {
                        matrix[currentRow][currentCol + 1] = "-";
                        matrix[currentRow][currentCol] = "P";
                    } else if (validateSymbol(symbol)) {
                        word += el;
                        matrix[currentRow][currentCol + 1] = "-";
                        matrix[currentRow][currentCol] = "P";
                    }
                    break;
                case "down":

                    currentRow++;
                    if (!(validateRowAndCol(currentRow, currentCol, n))) {
                        word = word.substring(0, word.length() - 1);
                        currentRow--;
                        command = scanner.nextLine();
                        continue;
                    }

                    el = matrix[currentRow][currentCol];
                    symbol = el.charAt(0);
                    if (el.equals("-")) {
                        matrix[currentRow - 1][currentCol] = "-";
                        matrix[currentRow][currentCol] = "P";
                    } else if (validateSymbol(symbol)) {
                        word += el;
                        matrix[currentRow - 1][currentCol] = "-";
                        matrix[currentRow][currentCol] = "P";
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        // Output:
        System.out.println(word);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.stream(matrix[i]).forEach(System.out::print);
            System.out.println();
        }
    }

    private static boolean validateSymbol(char symbol) {
        return (symbol >= 65 && symbol <= 90) || (symbol >= 97 && symbol <= 122);
    }

    private static boolean validateRowAndCol(int currentRow, int currentCol, int n) {
        return (currentRow >= 0 && currentRow < n) && (currentCol >= 0 && currentCol < n);
    }

    private static int[] returnCoordinates(String[][] matrix) {
        int[] coordinates = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("P")) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
        }
        return coordinates;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
    }
}
