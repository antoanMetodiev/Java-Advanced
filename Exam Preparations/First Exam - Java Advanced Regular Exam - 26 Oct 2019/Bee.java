import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];

        fillMatrix(matrix, scanner);
        int[] cordinates = returnCordinates(matrix);

        // Мойте постоянно променящи се координати:
        int currentRow = cordinates[0];
        int currentCol = cordinates[1];

        String command = scanner.nextLine();
        int pollFlowers = 0;  // Брояч на Упрашени цветя
        boolean isLost = false;
        while (!command.equals("End")) {

            String el = "";
            switch (command) {
                case "down":

                    currentRow += 1;
                    if (currentRow >= n) {
                        // пчелата е излезнала от цялото поле!
                        matrix[currentRow - 1][currentCol] = ".";
                        isLost = true;
                        break;
                    } else {

                        el = matrix[currentRow][currentCol];
                        if (el.equals("f")) {
                            pollFlowers++;
                        } else if (el.equals("O")) {

                            currentRow += 1;
                            el = matrix[currentRow][currentCol];
                            if (el.equals("f")) {
                                pollFlowers++;
                            }
                            matrix[currentRow - 2][currentCol] = ".";
                        }
                        matrix[currentRow][currentCol] = "B";
                        matrix[currentRow - 1][currentCol] = ".";
                    }
                    break;
                case "up":

                    currentRow -= 1;
                    if (currentRow < 0) {
                        // пчелата е излезнала от цялото поле!
                        matrix[currentRow + 1][currentCol] = ".";
                        isLost = true;
                        break;
                    } else {

                        el = matrix[currentRow][currentCol];
                        if (el.equals("f")) {
                            pollFlowers++;
                        } else if (el.equals("O")) {

                            currentRow -= 1;
                            el = matrix[currentRow][currentCol];
                            if (el.equals("f")) {
                                pollFlowers++;
                            }
                            matrix[currentRow + 2][currentCol] = ".";
                        }
                        matrix[currentRow][currentCol] = "B";
                        matrix[currentRow + 1][currentCol] = ".";
                    }
                    break;
                case "left":

                    currentCol -= 1;
                    if (currentCol < 0) {
                        // пчелата е излезнала от цялото поле!
                        matrix[currentRow][currentCol + 1] = ".";
                        isLost = true;
                        break;
                    } else {

                        el = matrix[currentRow][currentCol];
                        if (el.equals("f")) {
                            pollFlowers++;
                        } else if (el.equals("O")) {

                            currentCol -= 1;
                            el = matrix[currentRow][currentCol];
                            if (el.equals("f")) {
                                pollFlowers++;
                            }
                            matrix[currentRow][currentCol + 2] = ".";
                        }
                        matrix[currentRow][currentCol] = "B";
                        matrix[currentRow][currentCol + 1] = ".";
                    }
                    break;
                case "right":

                    currentCol += 1;
                    if (currentCol >= n) {
                        // пчелата е излезнала от цялото поле!
                        matrix[currentRow][currentCol - 1] = ".";
                        isLost = true;
                        break;
                    } else {

                        el = matrix[currentRow][currentCol];
                        if (el.equals("f")) {
                            pollFlowers++;
                        } else if (el.equals("O")) {

                            currentCol += 1;
                            el = matrix[currentRow][currentCol];
                            if (el.equals("f")) {
                                pollFlowers++;
                            }
                            matrix[currentRow][currentCol - 2] = ".";
                        }
                        matrix[currentRow][currentCol] = "B";
                        matrix[currentRow][currentCol - 1] = ".";
                    }
                    break;
            }

            if (isLost) {
                break;
            }
            command = scanner.nextLine();
        }
        // Output:
        if (isLost) {
            System.out.println("The bee got lost!");
        }
        if (pollFlowers >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollFlowers);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int[] returnCordinates(String[][] matrix) {
        int[] cordinates = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("B")) {
                    cordinates[0] = i;
                    cordinates[1] = j;
                    return cordinates;
                }
            }
        }
        return null;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
    }
}
