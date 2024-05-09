import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizeOfMatrix = Arrays.stream(scanner.nextLine()
                        .split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = sizeOfMatrix[0];
        int col = sizeOfMatrix[1];

        int[][] numbersCollector = new int[rows][col];
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            
            String[] numbers = scanner.nextLine().split(",\\s+");
            for (int j = 0; j < col; j++) {
                numbersCollector[i][j] = Integer.parseInt(numbers[j]);
                sum += Integer.parseInt(numbers[j]);
            }
        }
        System.out.println(rows);
        System.out.println(col);
        System.out.println(sum);
    }
}
