import java.util.Arrays;
import java.util.Scanner;

public class Bee {


    private static int currentRow;
    private static int currentCol;

    private static String[][] field;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        field = new String[n][n];
        fillMatrix(scanner);
        searchBeeCoordinates();

        moveMatrix(scanner);


    }

    private static void moveMatrix(Scanner scanner) {

        int flowersCount = 0;  // Упрашени цветя
        boolean isLost = false;

        String command = scanner.nextLine();
        while (!"End".equals(command)) {

            switch (command) {
                case "up":

                    currentRow--;
                    if (!checkIndexPositionIsValid()) {

                        // TODO: Излезнала е от полето.
                        System.out.println("The bee got lost!");
                        field[currentRow + 1][currentCol] = ".";
                        isLost = true;
                        break;
                    }

                    String el = field[currentRow][currentCol];
                    if (el.equals("f")) {
                        flowersCount++;
                    } else if (el.equals("O")) {

                        field[currentRow + 1][currentCol] = ".";
                        currentRow--;
                        if (field[currentRow][currentCol].equals("f")) {
                            flowersCount++;
                        }

                    }

                    // Рутинно преместване:
                    field[currentRow + 1][currentCol] = ".";
                    field[currentRow][currentCol] = "B";

                    break;
                case "down":

                    currentRow++;
                    if (!checkIndexPositionIsValid()) {

                        // TODO: Излезнала е от полето.
                        System.out.println("The bee got lost!");
                        field[currentRow - 1][currentCol] = ".";
                        isLost = true;
                        break;
                    }

                    el = field[currentRow][currentCol];
                    if (el.equals("f")) {
                        flowersCount++;
                    } else if (el.equals("O")) {

                        field[currentRow - 1][currentCol] = ".";
                        currentRow++;
                        if (field[currentRow][currentCol].equals("f")) {
                            flowersCount++;
                        }
                    }

                    // Рутинно преместване:
                    field[currentRow - 1][currentCol] = ".";
                    field[currentRow][currentCol] = "B";

                    break;
                case "left":

                    currentCol--; // Вървим наляво
                    if (!checkIndexPositionIsValid()) {

                        // TODO: Излезнала е от полето.
                        System.out.println("The bee got lost!");
                        field[currentRow][currentCol + 1] = ".";
                        isLost = true;
                        break;
                    }

                    el = field[currentRow][currentCol];
                    if (el.equals("f")) {
                        flowersCount++;
                    } else if (el.equals("O")) {

                        field[currentRow][currentCol + 1] = ".";
                        currentCol--;
                        if (field[currentRow][currentCol].equals("f")) {
                            flowersCount++;
                        }
                    }

                    // Рутинно преместване:
                    field[currentRow][currentCol + 1] = ".";
                    field[currentRow][currentCol] = "B";


                    break;
                case "right":

                    currentCol++; // Вървим надясно
                    if (!checkIndexPositionIsValid()) {

                        // TODO: Излезнала е от полето.
                        System.out.println("The bee got lost!");
                        field[currentRow][currentCol - 1] = ".";
                        isLost = true;
                        break;
                    }

                    el = field[currentRow][currentCol];
                    if (el.equals("f")) {
                        flowersCount++;
                    } else if (el.equals("O")) {

                        field[currentRow][currentCol - 1] = ".";
                        currentCol++;
                        if (field[currentRow][currentCol].equals("f")) {
                            flowersCount++;
                        }
                    }

                    // Рутинно преместване:
                    field[currentRow][currentCol - 1] = ".";
                    field[currentRow][currentCol] = "B";

                    break;
            }

            if (isLost) {
                break;
            }

            command = scanner.nextLine();
        }

        // Output:
        if (flowersCount >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", flowersCount);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - flowersCount);
        }
        printMatrix();

    }

    private static void printMatrix() {
        for (int i = 0; i < field.length; i++) {
            Arrays.stream(field[i]).forEach(System.out::print);
            System.out.println();
        }
    }

    private static boolean checkIndexPositionIsValid() {
        if (currentRow < 0 || currentRow >= field.length) {
            return false;
        } else if (currentCol < 0 || currentCol >= field.length) {
            return false;
        }
        return true;
    }

    private static void searchBeeCoordinates() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("B")) {
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
