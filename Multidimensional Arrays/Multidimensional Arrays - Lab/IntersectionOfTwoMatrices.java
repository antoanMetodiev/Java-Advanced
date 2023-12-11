import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firsrtMatrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {

            String[] symbols = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                firsrtMatrix[i][j] = symbols[j].charAt(0);
            }
        }

        char[][] secondMatrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {

            String[] symbols = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                secondMatrix[i][j] = symbols[j].charAt(0);
            }
        }
        compareMatrix(firsrtMatrix, secondMatrix);
    }

    private static void compareMatrix(char[][] firsrtMatrix, char[][] secondMatrix) {
        for (int i = 0; i < firsrtMatrix.length; i++) {
            for (int j = 0; j < firsrtMatrix[i].length; j++) {

                if (firsrtMatrix[i][j] == secondMatrix[i][j]) {
                    System.out.print(firsrtMatrix[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
