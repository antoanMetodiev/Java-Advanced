import java.util.*;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e -> milkQueue.offer(Double.parseDouble(e)));

        Deque<Double> cacaoStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e -> cacaoStack.push(Double.parseDouble(e)));

        int bakingChocolate = 0; // 100
        int darkChocolate = 0;  // 50
        int milkChocolate = 0;  // 30

        while (!(milkQueue.isEmpty()) && !(cacaoStack.isEmpty())) {


            double milkValue = milkQueue.peek(); // Стойноста на първото мляко
            double cacaoValue = cacaoStack.peek(); // Стойноста на последното какао

            double cacaoPercent = cacaoValue / (milkValue + cacaoValue);

            if (cacaoPercent * 100 == 30) {
                milkChocolate++;
                milkQueue.poll();
                cacaoStack.pop();
            } else if (cacaoPercent * 100 == 50) {
                darkChocolate++;
                milkQueue.poll();
                cacaoStack.pop();
            } else if (cacaoPercent * 100 == 100) {
                bakingChocolate++;
                milkQueue.poll();
                cacaoStack.pop();
            } else {
                cacaoStack.pop();

                // Увеличаваме стойноста на млякото с 10:
                milkQueue.poll();
                milkQueue.offer(milkValue + 10);
            }

        }

        printOutputs(bakingChocolate, darkChocolate, milkChocolate);
    }

    private static void printOutputs(int bakingChocolate, int darkChocolate, int milkChocolate) {
        if (bakingChocolate > 0 && darkChocolate > 0 && milkChocolate > 0) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        Map<String, Integer> chocolates = new LinkedHashMap<>();
        chocolates.put("# Baking Chocolate -->", bakingChocolate);
        chocolates.put("# Dark Chocolate -->", darkChocolate);
        chocolates.put("# Milk Chocolate -->", milkChocolate);

        chocolates.entrySet().stream().filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.printf("%s %d\n", e.getKey(), e.getValue()));


    }
}