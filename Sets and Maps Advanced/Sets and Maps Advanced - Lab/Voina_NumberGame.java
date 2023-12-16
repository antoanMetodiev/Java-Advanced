import java.util.*;
import java.util.stream.Collectors;

public class Voina_NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayer = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50; i++) {

            if (firstPlayer.isEmpty()) {
                System.out.println("Second player win!");
                return;
            }
            if (secondPlayer.isEmpty()) {
                System.out.println("First player win!");
                return;
            }
            int topCardOnFirstPlayer = firstPlayer.iterator().next();
            int topCardOnSecondPlayer = secondPlayer.iterator().next();

            firstPlayer.remove(topCardOnFirstPlayer);
            secondPlayer.remove(topCardOnSecondPlayer);

            if (topCardOnFirstPlayer > topCardOnSecondPlayer) {
                firstPlayer.add(topCardOnFirstPlayer);
                firstPlayer.add(topCardOnSecondPlayer);
            } else if (topCardOnFirstPlayer < topCardOnSecondPlayer) {
                secondPlayer.add(topCardOnFirstPlayer);
                secondPlayer.add(topCardOnSecondPlayer);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
