import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        if (number == 0) {
            System.out.println(0);
            return;
        }

        ArrayDeque<Integer> inBinary = new ArrayDeque<>();
        while (number > 0) {
            inBinary.push(number % 2);
            number /= 2;
        }

        while (!inBinary.isEmpty()) {
            System.out.print(inBinary.pop());
        }
    }
}
