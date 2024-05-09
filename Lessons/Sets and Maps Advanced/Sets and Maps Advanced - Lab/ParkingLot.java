import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> carNumbers = new LinkedHashSet<>();
        String line = scanner.nextLine();
        while (!"END".equals(line)) {

            String[] tokens = line.split(",\\s+");
            String action = tokens[0];
            String number = tokens[1];
            
            switch (action) {
                case "IN":
                    carNumbers.add(number);
                    break;
                case "OUT":
                    carNumbers.remove(number);
                    break;
            }
            line = scanner.nextLine();
        }

        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }else {
            carNumbers.forEach(System.out::println);
        }
    }
}
