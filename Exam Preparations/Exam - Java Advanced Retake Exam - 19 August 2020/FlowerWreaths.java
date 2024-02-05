import java.util.*;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).forEach(e -> lilies.push(Integer.parseInt(e)));

        Deque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).forEach(e -> roses.offer(Integer.parseInt(e)));

        int wreathCount = 0; // Брой венци
        List<Integer> additionalFlowers = new ArrayList<>();
        while (!roses.isEmpty() && !lilies.isEmpty()) {

            int sum = roses.peek() + lilies.peek();
            if (sum == 15) {
                wreathCount++;
                roses.poll();
                lilies.pop();
            } else if (sum > 15) {

                int decreasedValue = lilies.pop() - 2;
                lilies.push(decreasedValue);
            } else if (sum < 15) {

                int forLater = roses.poll() + lilies.pop();
                additionalFlowers.add(forLater);
            }
        }

        // Output:
        // check for Additional wreath:
        int moreWreathCount = additionalFlowers.stream().mapToInt(e -> e).sum() / 15;
        wreathCount += moreWreathCount;

        if (wreathCount >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathCount);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreathCount);
        }
    }
}
