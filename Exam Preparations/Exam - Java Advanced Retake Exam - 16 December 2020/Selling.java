import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Selling {
    private static Scanner scanner = new Scanner(System.in);
    private static String[][] field;
    private static int currentRow;
    private static int currentCol;

    private static List<List<Integer>> pillars = new ArrayList<>();
    
    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        field = new String[n][n];
        fillMatrix();
        searchMyCoordinates();
        searchPillarsCoordinates();

        int myMoney = 0;
        boolean isOutside = false;
        String command = scanner.nextLine();
        while (myMoney < 50) {

            switch (command) {
                case "up":
                    currentRow--;
                    if (!checkIndexesIsValid()) {
                        isOutside = true;
                        field[currentRow + 1][currentCol] = "-"; 
                        field[currentRow + 1][currentCol] = "-";
                        break;
                    }

                    String el = field[currentRow][currentCol];
                    if (Character.isDigit(el.charAt(0))) {

                        myMoney += Integer.parseInt(el);
                        if (myMoney >=  50) {
                            isOutside = true;
                            field[currentRow + 1][currentCol] = "-"; 
                            field[currentRow][currentCol] = "S";
                            break;
                        }

                    } else if (el.equals("O")) {
                        field[currentRow + 1][currentCol] = "-"; 
                        field[currentRow][currentCol] = "-";

                        moveOnTheOtherPillar();
                        field[currentRow][currentCol] = "S";
                    }

                    if (!el.equals("O")) {
                        field[currentRow + 1][currentCol] = "-"; 
                        field[currentRow][currentCol] = "S";
                    }

                    break;
                case "down":

                    currentRow++;
                    if (!checkIndexesIsValid()) {
                        isOutside = true;
                        field[currentRow - 1][currentCol] = "-"; 
                        break;
                    }

                    el = field[currentRow][currentCol];
                    if (Character.isDigit(el.charAt(0))) {

                        myMoney += Integer.parseInt(el);
                        if (myMoney >=  50) {
                            isOutside = true;
                            field[currentRow - 1][currentCol] = "-"; 
                            field[currentRow][currentCol] = "S";
                            break;
                        }

                    } else if (el.equals("O")) {
                        field[currentRow - 1][currentCol] = "-"; 
                        field[currentRow][currentCol] = "-"; 

                        moveOnTheOtherPillar();
                        field[currentRow][currentCol] = "S";
                    }

                    if (!el.equals("O")) {
                        field[currentRow - 1][currentCol] = "-"; 
                        field[currentRow][currentCol] = "S";
                    }

                    break;
                case "left":

                    currentCol--;
                    if (!checkIndexesIsValid()) {
                        isOutside = true;
                        field[currentRow][currentCol + 1] = "-";
                        break;
                    }

                    el = field[currentRow][currentCol];
                    if (Character.isDigit(el.charAt(0))) {
                        myMoney += Integer.parseInt(el);
                        if (myMoney >=  50) {
                            isOutside = true;
                            field[currentRow][currentCol + 1] = "-"; 
                            field[currentRow][currentCol] = "S";
                            break;
                        }

                    } else if (el.equals("O")) {
                        field[currentRow][currentCol + 1] = "-"; 
                        field[currentRow][currentCol] = "-"; 

                        moveOnTheOtherPillar();
                        field[currentRow][currentCol] = "S";
                    }

                    if (!el.equals("O")) {
                        field[currentRow][currentCol + 1] = "-";
                        field[currentRow][currentCol] = "S";
                    }
                    break;
                case "right":

                    currentCol++;
                    if (!checkIndexesIsValid()) {
                        isOutside = true;
                        field[currentRow][currentCol - 1] = "-"; 
                        break;
                    }

                    el = field[currentRow][currentCol];
                    if (Character.isDigit(el.charAt(0))) {

                        myMoney += Integer.parseInt(el);
                        if (myMoney >=  50) {
                            isOutside = true;
                            field[currentRow][currentCol - 1] = "-"; 
                            field[currentRow][currentCol] = "S";
                            break;
                        }

                    } else if (el.equals("O")) {
                        field[currentRow][currentCol - 1] = "-"; 
                        field[currentRow][currentCol] = "-"; 

                        moveOnTheOtherPillar();
                        field[currentRow][currentCol] = "S";
                    }

                    if (!el.equals("O")) {
                        field[currentRow][currentCol - 1] = "-"; 
                        field[currentRow][currentCol] = "S";
                    }
                    break;
            }

            if (isOutside) {
                break;
            }
            command = scanner.nextLine();
        }
        // Output:
        if (myMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the bakery.");
        }
        System.out.println("Money: " + myMoney);
        printMatrix();
    }

    private static void printMatrix() {
        for (int i = 0; i < field.length; i++) {
            Arrays.stream(field[i]).forEach(System.out::print);
            System.out.println();
        }
    }

    private static void moveOnTheOtherPillar() {
        for (List<Integer> pillar : pillars) {
            if (pillar.get(0) == currentRow && pillar.get(1) == currentCol) {
                pillars.remove(pillar);
            }
        }
        currentRow = pillars.get(0).get(0);
        currentCol = pillars.get(0).get(1);
    }

    private static boolean checkIndexesIsValid() {
        if (currentRow < 0 || currentRow >= field.length) {
            return false;
        } else if (currentCol < 0 || currentCol >= field.length) {
            return false;
        }
        return true;
    }

    private static void searchPillarsCoordinates() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("O")) {
                    List<Integer> coordinates = new ArrayList<>();
                    coordinates.add(i);
                    coordinates.add(j);
                    pillars.add(coordinates);
                }
            }
        }
    }

    private static void searchMyCoordinates() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("S")) {
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
