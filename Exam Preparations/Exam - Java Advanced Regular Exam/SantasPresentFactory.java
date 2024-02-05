import java.util.*;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> materialsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e -> materialsStack.push(Integer.parseInt(e)));

        Deque<Integer> magicQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e -> magicQueue.offer(Integer.parseInt(e)));

        int dollCount = 0;  
        int trainCount = 0; 
        int bearCount = 0;  
        int bicycleCount = 0; 

        while (!(materialsStack.isEmpty()) && !(magicQueue.isEmpty())) {
            
            int materialsCurrentValue = materialsStack.peek();
            int magicCurrentValue = magicQueue.peek();
            int result = materialsCurrentValue * magicCurrentValue;
            
            if (result == 150) {
                dollCount++;
                materialsStack.pop();
                magicQueue.poll();
            } else if (result == 250) {
                trainCount++;
                materialsStack.pop();
                magicQueue.poll();
            } else if (result == 300) {
                bearCount++;
                materialsStack.pop();
                magicQueue.poll();
            } else if (result == 400) {
                bicycleCount++;
                materialsStack.pop();
                magicQueue.poll();
            } else if (result < 0) {
                result = materialsCurrentValue + magicCurrentValue;
                materialsStack.pop();
                magicQueue.poll();
                materialsStack.push(result);
            } else if (result > 0) {
                materialsStack.pop();
                magicQueue.poll();
                materialsStack.push(materialsCurrentValue + 15);
            }
            if (materialsCurrentValue == 0) {
                materialsStack.pop();
            }
            if (magicCurrentValue == 0) {
                magicQueue.poll();
            }
        }

        // Output:
        if ((dollCount > 0 && trainCount > 0) || (bicycleCount > 0 && bearCount > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(String.join(", ", materialsStack.toString())
                    .replaceAll("[\\[\\]]", ""));
        } else if (!magicQueue.isEmpty()){
            System.out.print("Magic left: ");
            System.out.println(String.join(", ", magicQueue.toString())
                    .replaceAll("[\\[\\]]", ""));
        }

        Map<String, Integer> map = new TreeMap<>();
        map.put("Doll: ", dollCount);
        map.put("Wooden train: ", trainCount);
        map.put("Bicycle: ", bicycleCount);
        map.put("Teddy bear: ", bearCount);

        map.entrySet().stream().filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.println(e.getKey() + e.getValue()));
    }
}
