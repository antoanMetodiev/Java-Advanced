import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndColumns = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndColumns[0];  
        int columns = rowsAndColumns[1];  

        int rowsSaver = rows;
        int columnsSaver = columns;

        int[][] firstMatrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {

            String[] columnsNumbers = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columnsNumbers.length; j++) {
                firstMatrix[i][j] = Integer.parseInt(columnsNumbers[j]);
            }
        }
        
        rowsAndColumns = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        rows = rowsAndColumns[0]; 
        columns = rowsAndColumns[1];  

        if (rowsSaver != rows) {
            System.out.println("not equal");
            return;
        }
        if (columnsSaver != columns) {
            System.out.println("not equal");
            return;
        }

        int[][] secondMatrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {

            String[] columnsNumbers = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columns; j++) {
                secondMatrix[i][j] = Integer.parseInt(columnsNumbers[j]);
            }
        }

        if (equalsChecking(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean equalsChecking(int[][] firstMatrix, int[][] secondMatrix) {
        int rows = firstMatrix.length;
        int columns = firstMatrix[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                int currentFirstMatrixEl = firstMatrix[i][j];
                int currentSecondMatrixEl = secondMatrix[i][j];
                if (currentFirstMatrixEl != currentSecondMatrixEl) {
                    return false;
                }
            }
        }
        return true;
    }
}
