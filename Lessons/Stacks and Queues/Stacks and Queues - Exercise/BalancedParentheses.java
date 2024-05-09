import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = (scanner.nextLine().split(""));
        Deque<String> openBracets = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {

            String currentBracet = input[i]; 
            switch (currentBracet) {
                case ")":

                    if (openBracets.isEmpty()) {
                        System.out.println("NO");
                        return;
                    }
                    if (!openBracets.pop().equals("(")) {
                        System.out.println("NO");
                        return;
                    }
                    break;
                case "]":

                    if (openBracets.isEmpty()) {
                        System.out.println("NO");
                        return;
                    }
                    if (!openBracets.pop().equals("[")) {
                        System.out.println("NO");
                        return;
                    }
                    break;
                case "}":

                    if (openBracets.isEmpty()) {
                        System.out.println("NO");
                        return;
                    }
                    if (!openBracets.pop().equals("{")) {
                        System.out.println("NO");
                        return;
                    }
                    break;
                default:
                    openBracets.push(currentBracet);
                    break;
            }
        }
        System.out.println("YES");
    }
}
