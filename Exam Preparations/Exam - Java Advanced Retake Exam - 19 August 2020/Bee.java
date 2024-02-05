import java.util.Scanner;

public class Bee {
    private static Scanner scanner = new Scanner(System.in);
    private static String[][] myField;

    private static int currentRow;
    private static int currentCol;
    private static int flowersCount = 0;

    private static boolean isLeft = false;

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine()); // sizes
        myField = new String[n][n];

        fillMatrix();
        searchMyCoordinates();
        processData();
        printOutput();
    }

    private static void printOutput() {
        if (isLeft) {
            System.out.println("The bee got lost!");
        }

        if (flowersCount >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", flowersCount);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - flowersCount);
        }

        // print Matrix:
        for (int i = 0; i < myField.length; i++) {
            for (int j = 0; j < myField[i].length; j++) {
                System.out.print(myField[i][j]);
            }
            System.out.println();
        }
    }

    private static void processData() {
        String command = scanner.nextLine();
        while (!"End".equals(command)) {

            myField[currentRow][currentCol] = ".";
            moveMatrix(command);
            if (isLeft) {
                break;
            }
            if (myField[currentRow][currentCol].equals("O")) {

                myField[currentRow][currentCol] = ".";
                moveMatrix(command);
                if (isLeft) {
                    break;
                }
            }
            if (myField[currentRow][currentCol].equals("f")) {
                flowersCount++;
            }
            // my new coordinates:
            myField[currentRow][currentCol] = "B";

            command = scanner.nextLine();
        }
    }

    private static void moveMatrix(String command) {
        switch (command) {
            case "up":
                currentRow--;
                break;
            case "down":
                currentRow++;
                break;
            case "right":
                currentCol++;
                break;
            case "left":
                currentCol--;
                break;
        }
        // check indexes after move:
        checkIndexesIsValid();
    }

    private static void checkIndexesIsValid() {
        if (currentRow < 0 || currentRow >= myField.length) {
            isLeft = true;
        } else if (currentCol < 0 || currentCol >= myField.length) {
            isLeft = true;
        }
    }

    private static void searchMyCoordinates() {
        for (int i = 0; i < myField.length; i++) {
            for (int j = 0; j < myField[i].length; j++) {
                if (myField[i][j].equals("B")) {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }
    }

    private static void fillMatrix() {
        for (int i = 0; i < myField.length; i++) {
            myField[i] = scanner.nextLine().split("");
        }
    }
}
