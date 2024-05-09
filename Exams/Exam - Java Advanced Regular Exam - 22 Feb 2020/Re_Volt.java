import java.util.Arrays;
import java.util.Scanner;

public class Re_Volt {
    private static int currentRow;
    private static int currentCol;

    private static String[][] field;
    private static boolean isWin = false;
    private static boolean isValid = true;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        field = new String[n][n];

        int commandsCount = Integer.parseInt(scanner.nextLine()); 
        fillMatrix(scanner);
        searchCoordinates();

        for (int i = 0; i < commandsCount; i++) {

            String command = scanner.nextLine();
            isValid = true;  // нулиране на стойноста
            switch (command) {
                case "up":

                    currentRow--;
                    validateIndexes();
                    if (field[currentRow][currentCol].equals("T")) {
                        currentRow++; // връщам си индекса
                        continue;
                    }

                    String el = field[currentRow][currentCol];
                    if (el.equals("F")) {
                        isWin = true;
                        if (isValid) {
                            field[currentRow + 1][currentCol] = "-";
                            field[currentRow][currentCol] = "f";
                        }
                        break;
                    } else if (el.equals("B")) {

                        field[currentRow + 1][currentCol] = "-"; 
                        currentRow--;
                        validateIndexes();
                        field[currentRow][currentCol] = "f";
                    }

                    if (isValid && !el.equals("B")) {

                        // Рутинно преместване:
                        field[currentRow + 1][currentCol] = "-";
                        field[currentRow][currentCol] = "f";
                    }

                    break;
                case "down":

                    currentRow++;
                    validateIndexes();

                    if (field[currentRow][currentCol].equals("T")) {
                        currentRow--;
                        continue;
                    }

                    el = field[currentRow][currentCol];
                    if (el.equals("F")) {
                        isWin = true;
                        if (isValid) {
                            field[currentRow - 1][currentCol] = "-";
                            field[currentRow][currentCol] = "f";
                        }
                        break;
                    } else if (el.equals("B")) {

                        field[currentRow - 1][currentCol] = "-";
                        currentRow++;
                        validateIndexes();
                        field[currentRow][currentCol] = "f";
                    }

                    if (isValid && !el.equals("B")) {

                        // Рутинно преместване:
                        field[currentRow - 1][currentCol] = "-";
                        field[currentRow][currentCol] = "f";
                    }


                    break;
                case "left":

                    currentCol--;
                    validateIndexes();

                    if (field[currentRow][currentCol].equals("T")) {
                        currentCol++; // връщам си индекса
                        continue;
                    }

                    el = field[currentRow][currentCol];
                    if (el.equals("F")) {
                        isWin = true;
                        if (isValid) {
                            field[currentRow][currentCol + 1] = "-";
                            field[currentRow][currentCol] = "f";
                        }
                        break;
                    } else if (el.equals("B")) {

                        field[currentRow][currentCol + 1] = "-"; // Връщане на позиция:
                        currentCol--;
                        validateIndexes();
                        field[currentRow][currentCol] = "f";
                    }

                    // ----
                    // ---B
                    // --T-
                    // -f-F

                    if (isValid && !el.equals("B")) {

                        // Рутинно преместване:
                        field[currentRow][currentCol + 1] = "-";
                        field[currentRow][currentCol] = "f";
                    }

                    break;
                case "right":

                    currentCol++;
                    validateIndexes();

                    if (field[currentRow][currentCol].equals("T")) {
                        currentCol--; // връщам си индекса
                        continue;
                    }

                    el = field[currentRow][currentCol];
                    if (el.equals("F")) {
                        isWin = true;
                        if (isValid) {
                            field[currentRow][currentCol - 1] = "-";
                            field[currentRow][currentCol] = "f";
                        }
                        break;
                    } else if (el.equals("B")) {

                        field[currentRow][currentCol - 1] = "-"; // Връщане на позиция:
                        currentCol++;
                        validateIndexes();
                        field[currentRow][currentCol] = "f";
                    }

                    // -----
                    //-f---
                    //-B---
                    //--T--
                    //-F---

                    if (isValid && !el.equals("B")) {

                        // Рутинно преместване:
                        field[currentRow][currentCol - 1] = "-";
                        field[currentRow][currentCol] = "f";
                    }
                    break;
            }

            // Излизаме от цикъла:
            if (isWin) {
                break;
            }
        }

        // Output:
        if (isWin) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix();


    }

    private static void printMatrix() {
        for (int i = 0; i < field.length; i++) {
            Arrays.stream(field[i]).forEach(System.out::print);
            System.out.println();
        }
    }

    private static void validateIndexes() {
        // -----
        //-f---
        //-B---
        //--T--
        //-F---
        if (currentRow < 0) {

            currentRow = 0;
            if (!field[currentRow][currentCol].equals("B") && !field[currentRow][currentCol].equals("T")) {
                field[currentRow][currentCol] = "-"; // оставям си празно място
            }

            currentRow = field.length - 1;
            isValid = false;
            if (field[currentRow][currentCol].equals("F")) {
                isWin = true;
                field[currentRow][currentCol] = "f"; // настанявам се
                return;
            }

            field[currentRow][currentCol] = "f"; // настанявам се
        }

        if (currentRow >= field.length) {

            currentRow = field.length - 1;
            if (!field[currentRow][currentCol].equals("B") && !field[currentRow][currentCol].equals("T")) {
                field[currentRow][currentCol] = "-"; // оставям си празно място
            }

            currentRow = 0;
            isValid = false;
            if (field[currentRow][currentCol].equals("F")) {
                isWin = true;
                field[currentRow][currentCol] = "f"; // настанявам се
                return;
            }

            field[currentRow][currentCol] = "f"; // настанявам се

        }


        if (currentCol < 0) {

            currentCol = 0;

            if (!field[currentRow][currentCol].equals("B") && !field[currentRow][currentCol].equals("T")) {
                field[currentRow][currentCol] = "-"; // оставям си празно място
            }

            currentCol = field.length - 1;
            isValid = false;
            if (field[currentRow][currentCol].equals("F")) {
                isWin = true;
                field[currentRow][currentCol] = "f"; // настанявам се
                return;
            }

            field[currentRow][currentCol] = "f"; // настанявам се

        }

        if (currentCol >= field.length) {

            currentCol = field.length - 1;
            if (!field[currentRow][currentCol].equals("B") && !field[currentRow][currentCol].equals("T")) {
                field[currentRow][currentCol] = "-"; // оставям си празно място
            }

            currentCol = 0;
            isValid = false;
            if (field[currentRow][currentCol].equals("F")) {
                isWin = true;
                field[currentRow][currentCol] = "f"; // настанявам се
                return;
            }

            field[currentRow][currentCol] = "f"; // настанявам се

        }

    }

    private static void searchCoordinates() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("f")) {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }
    }

    private static void fillMatrix(Scanner scanner) {
        for (int i = 0; i < field.length; i++) {
            field[i] = scanner.nextLine().split("");
        }
    }
}
