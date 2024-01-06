import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] cityField = new String[n][n];

        String[] commandsList = scanner.nextLine().split(",");
        fillMatrix(cityField, scanner);
        int[] myCordinates = returnCordinates(cityField);

        int currentRow = myCordinates[0];
        int currentCol = myCordinates[1];

        int stolenMoney = 0; 
        for (String command : commandsList) {

            String el = "";
            switch (command) {
                case "up":

                    currentRow -= 1;
                    if (!(checkValidation(currentRow, currentCol, n))) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        currentRow++; 
                        continue;
                    }
                    el = cityField[currentRow][currentCol];
                    if (el.equals("$")) {

                        cityField[currentRow + 1][currentCol] = "+"; 
                        cityField[currentRow][currentCol] = "D";

                        System.out.printf("You successfully stole %d$.\n", currentRow * currentCol);
                        stolenMoney += currentRow * currentCol;
                    } else if (el.equals("P")) {
                        cityField[currentRow][currentCol] = "#";
                        cityField[currentRow + 1][currentCol] = "+"; 
                        System.out.printf("You got caught with %d$, and you are going to jail.\n", stolenMoney);
                        printMatrix(cityField);
                        return;
                    } else if (el.equals("+")) {
                        cityField[currentRow + 1][currentCol] = "+"; 
                        cityField[currentRow][currentCol] = "D";
                    }
                    break;
                case "left":

                    currentCol -= 1;
                    if (!(checkValidation(currentRow, currentCol, n))) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        currentCol++;
                        continue;
                    }
                    el = cityField[currentRow][currentCol];
                    if (el.equals("$")) {

                        cityField[currentRow][currentCol + 1] = "+"; 
                        cityField[currentRow][currentCol] = "D";

                        System.out.printf("You successfully stole %d$.\n", currentRow * currentCol);
                        stolenMoney += currentRow * currentCol;
                    } else if (el.equals("P")) {
                        cityField[currentRow][currentCol] = "#";
                        cityField[currentRow][currentCol + 1] = "+"; 
                        System.out.printf("You got caught with %d$, and you are going to jail.\n", stolenMoney);
                        printMatrix(cityField);
                        return;
                    } else if (el.equals("+")) {
                        cityField[currentRow][currentCol + 1] = "+"; 
                        cityField[currentRow][currentCol] = "D";
                    }
                    break;
                case "right":
                    currentCol += 1;
                    if (!(checkValidation(currentRow, currentCol, n))) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        currentCol--; 
                        continue;
                    }
                    el = cityField[currentRow][currentCol];
                    if (el.equals("$")) {

                        cityField[currentRow][currentCol - 1] = "+"; 
                        cityField[currentRow][currentCol] = "D";

                        System.out.printf("You successfully stole %d$.\n", currentRow * currentCol);
                        stolenMoney += currentRow * currentCol;

                    } else if (el.equals("P")) {
                        cityField[currentRow][currentCol] = "#";
                        cityField[currentRow][currentCol - 1] = "+"; 
                        System.out.printf("You got caught with %d$, and you are going to jail.\n", stolenMoney);
                        printMatrix(cityField);
                        return;
                    } else if (el.equals("+")) {
                        cityField[currentRow][currentCol - 1] = "+"; 
                        cityField[currentRow][currentCol] = "D";
                    }

                    break;
                case "down":

                    currentRow += 1;
                    if (!(checkValidation(currentRow, currentCol, n))) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        currentRow--; 
                        continue;
                    }
                    el = cityField[currentRow][currentCol];
                    if (el.equals("$")) {

                        cityField[currentRow - 1][currentCol] = "+"; 
                        cityField[currentRow][currentCol] = "D";

                        System.out.printf("You successfully stole %d$.\n", currentRow * currentCol);
                        stolenMoney += currentRow * currentCol;
                    } else if (el.equals("P")) {
                        cityField[currentRow][currentCol] = "#";
                        cityField[currentRow - 1][currentCol] = "+"; 
                        System.out.printf("You got caught with %d$, and you are going to jail.\n", stolenMoney);
                        printMatrix(cityField);
                        return;
                    } else if (el.equals("+")) {
                        cityField[currentRow - 1][currentCol] = "+"; 
                        cityField[currentRow][currentCol] = "D";
                    }
                    break;
            }
        }
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", stolenMoney);
        printMatrix(cityField);
    }

    private static void printMatrix(String[][] cityField) {
        for (int i = 0; i < cityField.length; i++) {
            Arrays.stream(cityField[i]).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static boolean checkValidation(int currentRow, int currentCol, int n) {
        return (currentRow >= 0 && currentRow < n) && (currentCol >= 0 && currentCol < n);
    }

    private static int[] returnCordinates(String[][] bankField) {
        int[] cordinates = new int[2];
        for (int i = 0; i < bankField.length; i++) {
            for (int j = 0; j < bankField.length; j++) {
                if (bankField[i][j].equals("D")) {
                    cordinates[0] = i;
                    cordinates[1] = j;
                }
            }
        }
        return cordinates;
    }

    private static void fillMatrix(String[][] bankField, Scanner scanner) {
        for (int i = 0; i < bankField.length; i++) {
            bankField[i] = scanner.nextLine().split(" ");
        }
    }
}
