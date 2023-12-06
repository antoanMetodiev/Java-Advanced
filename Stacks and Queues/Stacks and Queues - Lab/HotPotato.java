import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, names);

        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        while (kids.size() > 1) {
            
            if (counter == n) {
                System.out.println("Removed " + kids.pollLast());
                counter = 0;
            } else {     
                counter++;
                String currentName = kids.poll();
                kids.offerLast(currentName);
            }
        }
        System.out.println("Last is " + kids.poll());
    }
}
