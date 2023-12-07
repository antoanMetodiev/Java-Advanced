import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputData[0]);  
        int s = Integer.parseInt(inputData[1]); 
        int x = Integer.parseInt(inputData[2]); 

        String[] inputNumbers = scanner.nextLine().split("\\s+");

        Deque<Integer> numbersStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int el = Integer.parseInt(inputNumbers[i]);
            numbersStack.push(el);
        }

        while (s > 0) {
            numbersStack.pop();
            s--;
        }

        if (!numbersStack.isEmpty()) {
            if (numbersStack.contains(x)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(numbersStack));
            }
        } else {
            System.out.println(0);
        }
    }
}
