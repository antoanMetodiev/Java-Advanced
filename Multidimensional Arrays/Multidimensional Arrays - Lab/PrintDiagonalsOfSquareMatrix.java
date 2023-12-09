import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {

            String[] els = scanner.nextLine().split("\\s+");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(els[j]);
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        int counter = size - 1;
        for (int i = 0; i < size; i++) {
            System.out.print(matrix[counter][i] + " ");
            counter--;
        }
    }
}
