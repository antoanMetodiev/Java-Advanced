import java.util.*;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputData = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputData[0];
        int s = inputData[1];
        int x = (inputData[2]);

        inputData = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> numbersQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            numbersQueue.offer((inputData[i]));
        }

        for (int i = 0; i < s; i++) {
            numbersQueue.poll();
        }

        if (numbersQueue.isEmpty()) {
            System.out.println(0);
        } else if (numbersQueue.contains(x)){
            System.out.println("true");
        } else {
            System.out.println(Collections.min(numbersQueue));
        }
    }
}
