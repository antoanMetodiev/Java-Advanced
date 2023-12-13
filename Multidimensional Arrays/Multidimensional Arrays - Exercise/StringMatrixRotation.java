import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputRotation = scanner.nextLine();
        int rotation = Integer.parseInt(inputRotation.replaceAll("[\\(\\)A-Za-z]", ""));
        rotation /= 90;

        // НАМИРАМЕ СИ РАЗМЕРИТЕ НА ПЪРВОНАЧАЛНАТА НИ МАТРИЦА:
        List<String> list = new ArrayList<>();
        String line = scanner.nextLine();
        int maxLenght = Integer.MIN_VALUE;
        while (!line.equals("END")) {
            list.add(line);
            int lenght = line.length();
            if (lenght > maxLenght) {
                maxLenght = lenght;
            }
            line = scanner.nextLine();
        }
        //==================================================

        // ПЪЛНИМ СИ МАТРИЦАТА:
        int rows = list.size();
        int cols = maxLenght;
        char[][] matrix = new char[rows][cols];
        fillBeginMatrix(matrix, list, rows, cols);
        //======================================

        rotateOn90(matrix, rows, cols, rotation);
    }

    private static void fillBeginMatrix(char[][] matrix, List<String> list, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!(j >= list.get(i).length())) {
                    matrix[i][j] = list.get(i).charAt(j);
                } else {
                    break;
                }
            }
        }
    }

    private static void rotateOn90(char[][] matrix, int rows, int cols, int rotation) {

        char[][] rotatedMatrix = new char[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                rotatedMatrix[i][j] = matrix[rows - 1 - j][i];
            }
        }

        rotation--;
        // АКО Е РАВНА НА 0 - СИ Я ПЕЧАТАМЕ И НЯМА ДА ПРАВИМ ОЩЕ ЗАВЪРТАНИЯ:
        if (rotation == 0) {
            for (int i = 0; i < rotatedMatrix.length; i++) {

                for (int j = 0; j < rotatedMatrix[i].length; j++) {

                    // default value: \u0000
                    if (rotatedMatrix[i][j] == '\u0000') {
                        System.out.print(" ");
                        continue;
                    }
                    System.out.print(rotatedMatrix[i][j]);
                }
                System.out.println();
            }
        } else {
            // ПРЕПРАЩАМЕ КЪМ ДРУГ МЕТОД:
            rotateOn180(rotatedMatrix, rows, cols, rotation);
        }
    }

    private static void rotateOn180(char[][] matrix, int rows, int cols, int rotation) {
        char[][] rotatedMatrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                rotatedMatrix[i][cols - 1 - j] = matrix[j][i];
            }
        }

        rotation--;
        // АКО Е РАВНА НА 0 - СИ Я ПЕЧАТАМЕ И НЯМА ДА ПРАВИМ ОЩЕ ЗАВЪРТАНИЯ:
        if (rotation == 0) {

            for (int i = 0; i < rotatedMatrix.length; i++) {

                for (int j = 0; j < rotatedMatrix[i].length; j++) {

                    // default value: \u0000
                    if (rotatedMatrix[i][j] == '\u0000') {
                        System.out.print(" ");
                        continue;
                    }
                    System.out.print(rotatedMatrix[i][j]);
                }
                System.out.println();
            }
        } else {
            // ПРЕПРАЩАШ КЪМ ДРУГ МЕТОД:
            rotateOn270(rotatedMatrix, rows, cols, rotation);
        }
    }

    private static void rotateOn270(char[][] matrix, int rows, int cols, int rotation) {
        char[][] rotatedMatrix = new char[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                rotatedMatrix[cols - 1 - j][rows - 1 - i] = matrix[i][cols - 1 - j];
            }
        }

        rotation--;
        // АКО Е РАВНА НА 0 - СИ Я ПЕЧАТАМЕ И НЯМА ДА ПРАВИМ ПОВЕЧЕ ЗАВЪРТАНИЯ:
        if (rotation == 0) {
            for (int i = 0; i < cols; i++) {

                for (int j = 0; j < rows; j++) {

                    // default value: \u0000
                    if (rotatedMatrix[i][j] == '\u0000') {
                        System.out.print(" ");
                        continue;
                    }
                    System.out.print(rotatedMatrix[i][j]);
                }
                System.out.println();
            }

        } else {
            rotateOn360(rotatedMatrix, rows, cols, rotation);
        }
    }

    private static void rotateOn360(char[][] matrix, int rows, int cols, int rotation) {

        char[][] rotatedMatrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                rotatedMatrix[i][j] = matrix[cols - 1 - j][i];
            }
        }

        rotation--;
        // АКО Е РАВНА НА 0 - СИ Я ПЕЧАТАМЕ И НЯМА ДА ПРАВИМ ПОВЕЧЕ ЗАВЪРТАНИЯ:
        if (rotation == 0) {

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    // default value: \u0000
                    if (rotatedMatrix[i][j] == '\u0000') {
                        System.out.print(" ");
                        continue;
                    }
                    System.out.print(rotatedMatrix[i][j]);
                }
                System.out.println();
            }

        } else {
            rotateOn90(rotatedMatrix, rows, cols, rotation);
        }
    }
}
