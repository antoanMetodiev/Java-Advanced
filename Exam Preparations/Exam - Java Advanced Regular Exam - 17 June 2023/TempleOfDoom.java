import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> tools = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> tools.offer(Integer.parseInt(e)));

        Deque<Integer> substances = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> substances.push(Integer.parseInt(e)));

        List<Integer> allChallenges = new ArrayList<>();
        allChallenges = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        while (!tools.isEmpty() && !substances.isEmpty() && !allChallenges.isEmpty()) {

            int sum = tools.peek() * substances.peek();
            if (allChallenges.contains(sum)) {
                tools.poll();
                substances.pop();
                allChallenges.remove(Integer.valueOf(sum));
            } else {
                int increasedEl = tools.poll() + 1;
                tools.offer(increasedEl);

                int decreasedEl = substances.pop() - 1;
                if (decreasedEl > 0) {
                    substances.push(decreasedEl);
                }
            }
        }

        // Output:
        if (!allChallenges.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else  {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }

        if (!tools.isEmpty()) {
            System.out.print("Tools: ");
            System.out.println(String.join(" ", tools.toString().replaceAll("[\\[\\]]", "")));
        }
        if (!substances.isEmpty()) {
            System.out.print("Substances: ");
            System.out.println(String.join(" ", substances.toString().replaceAll("[\\[\\]]", "")));
        }
        if (!allChallenges.isEmpty()) {
            System.out.print("Challenges: ");
            System.out.println(String.join(" ", allChallenges.toString().replaceAll("[\\[\\]]", "")));
        }
    }
}
