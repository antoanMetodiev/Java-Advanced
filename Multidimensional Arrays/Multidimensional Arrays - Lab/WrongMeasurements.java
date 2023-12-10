import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];

        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }


        String[][] collectorMatrix = new String[size][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                collectorMatrix[i][j] = "" + matrix[i][j];
            }
        }


        String[] wrongNumData = scanner.nextLine().split("\\s+");

        int wrongNumberIndexRow = Integer.parseInt(wrongNumData[0]);
        int wrongNumberIndexCol = Integer.parseInt(wrongNumData[1]);

        int wrongNumber = matrix[wrongNumberIndexRow][wrongNumberIndexCol];

        for (int i = 0; i < size; i++) {

            List<Integer> list = new ArrayList<>();
            Arrays.stream(matrix[i]).forEach(e -> list.add(e));

            while (list.contains(wrongNumber)) {

                wrongNumberIndexRow = i;
                wrongNumberIndexCol = list.indexOf(wrongNumber);

                int colLenght = list.size();

                int sum = processesMatrix(matrix, wrongNumberIndexRow, wrongNumberIndexCol, wrongNumber, colLenght, size);
                list.set(wrongNumberIndexCol, -124122);

                collectorMatrix[wrongNumberIndexRow][wrongNumberIndexCol] = "" + sum;

            }
        }

        for (int j = 0; j < collectorMatrix.length; j++) {
            for (int k = 0; k < collectorMatrix[j].length; k++) {
                System.out.print(collectorMatrix[j][k] + " ");
            }
            System.out.println();
        }


    }

    private static int processesMatrix(int[][] matrix, int wrongNumberIndexRow,
                                       int wrongNumberIndexCol, int wrongNumber, int colLenght, int size) {

//        1 2 4 4
//        4 6 4 3
//        8 9 4 2

        int sum = 0;
        int onLeftIndex = wrongNumberIndexCol - 1;

        if (onLeftIndex >= 0) {  // вървим НАЛЯВО

            if (matrix[wrongNumberIndexRow][onLeftIndex] != wrongNumber) {
                sum += matrix[wrongNumberIndexRow][onLeftIndex];
            }
        }

        int onRightIndex = wrongNumberIndexCol + 1;

        if (onRightIndex < colLenght) {  // вървим НАДЯСНО

            if (matrix[wrongNumberIndexRow][onRightIndex] != wrongNumber) {
                sum += matrix[wrongNumberIndexRow][onRightIndex];
            }
        }


//        1 2 4 4
//        4 6 4 3
//        8 9 4 2


        int onUp = wrongNumberIndexRow - 1;

        if (onUp >= 0) { // вървим НАГОРЕ

            if (matrix[onUp][wrongNumberIndexCol] != wrongNumber) {
                sum += matrix[onUp][wrongNumberIndexCol];
            }
        }

        int onDown = wrongNumberIndexRow + 1;

        if (onDown < size) { // вървим НАДОЛУ

            if (matrix[onDown][wrongNumberIndexCol] != wrongNumber) {
                sum += matrix[onDown][wrongNumberIndexCol];
            }
        }

        return sum;
    }
}