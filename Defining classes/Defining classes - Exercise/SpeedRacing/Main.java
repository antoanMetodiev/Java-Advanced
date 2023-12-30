package SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Car>> carsCollector = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String carModel = tokens[0];
            int quantityFuel = Integer.parseInt(tokens[1]);
            double fuelExpense = Double.parseDouble(tokens[2]); // Това е разход, НО САМО ЗА 1КМ.
            Car car = new Car(quantityFuel, fuelExpense, 0);
            carsCollector.put(carModel, new ArrayList<>());
            carsCollector.get(carModel).add(car);
        }

        String line = scanner.nextLine();
        while (!"End".equals(line)) {

            String[] tokens = line.split("\\s+");

            String carModel = tokens[1];
            int traveledDistance = Integer.parseInt(tokens[2]);


            Car.checkForEnoughFuel(carModel, traveledDistance, carsCollector);


            line = scanner.nextLine();
        }


        carsCollector.forEach((key, value) -> System.out.printf("%s %.2f %d\n"
                , key, value.get(0).getQuantityFuel(), value.get(0).getTraveledDistance()));



    }
}
