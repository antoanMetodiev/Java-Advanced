import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        ArrayDeque<Integer> openBracketsIndexes = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {

            char symbol = text.charAt(i);
            if (symbol == '(') {
                openBracketsIndexes.push(i);
            } else if (symbol == ')') {

                int startIndex = openBracketsIndexes.pop();
                int endIndex = i;
                String currentResult = text.substring(startIndex, endIndex + 1);
                System.out.println(currentResult);
            }
        }
    }
}
