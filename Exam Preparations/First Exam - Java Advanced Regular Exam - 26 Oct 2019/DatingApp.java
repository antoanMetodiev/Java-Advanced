import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> boys = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(boys::push);

        Deque<Integer> girls = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(girls::offer);

        int matchesCounter = 0;
        while (!(boys.isEmpty()) && !(girls.isEmpty())) {

            if (checkCurrentValueIsZeroOrSmalllerNum(boys, girls)) {
                continue;  // Ако ми даде true, то това означава че съм изтрил елемент
            }

            // special case
            if (checkVallueDivideOn25(boys, girls)) {
                continue;
            }

            int boysCurrentValue = boys.peek();
            int girslCurrentValue = girls.peek();
            if (boysCurrentValue == girslCurrentValue) {
                boys.pop();
                girls.poll();
                matchesCounter++;
            } else if (boysCurrentValue != girslCurrentValue) {
                girls.poll();
                boys.pop();
                boysCurrentValue -= 2;
                boys.push(boysCurrentValue);
            }
        }

        System.out.println("Matches: " + matchesCounter);

        // Проверка дали и двете не са празни:
        if (boys.isEmpty() && girls.isEmpty()) {
            System.out.println("Males left: none");
            System.out.println("Females left: none");
            return;
        }

        if (boys.isEmpty()) {
            System.out.println("Males left: none");
            System.out.println("Females left: " + String.join(", ", girls.toString())
                    .replaceAll("[\\[\\]]", ""));
        } else if (girls.isEmpty()) {
            System.out.println("Males left: " + String.join(", ", boys.toString())
                    .replaceAll("[\\[\\]]", ""));
            System.out.println("Females left: none");
        }
    }

    private static boolean checkVallueDivideOn25(Deque<Integer> boys, Deque<Integer> girls) {

        if (boys.peek() % 25 == 0) {
            if (boys.size() >= 2) {
                boys.pop();
                boys.pop();
                return true;
            }

        } else if (girls.peek() % 25 == 0) {
            if (girls.size() >= 2) {
                girls.poll();
                girls.poll();
                return true;
            }
        }
        return false;
    }

    private static boolean checkCurrentValueIsZeroOrSmalllerNum(Deque<Integer> boys, Deque<Integer> girls) {

        // Тук трябва да се види дали е само на един или и на двата да се премахват
        if (boys.peek() <= 0) {
            boys.pop();
            return true;
        }

        if (girls.peek() <= 0) {
            girls.poll();
            return true;
        }
        return false;
    }
}
