package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            // "{Model} {EngineSpeed} {EnginePower} {CargoWeight}
            // {CargoType} {Tire1Pressure} {Tire1Age} {Tire2Pressure}
            // {Tire2Age} {Tire3Pressure} {Tire3Age} {Tire4Pressure}

            String carModel = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tireList = putsTireData(tokens);

            Car car = new Car(carModel, engine, cargo, tireList);
            carsList.add(car);
        }

        String command = scanner.nextLine();
        if (command.equals("fragile")) {

            carsList.stream()
                    .filter(e -> e.getCargo().getCargoType().equals(command))
                    .filter(e -> {
                        int size = e.getTireList().stream().filter(t -> t.getPressure() < 1).collect(Collectors.toList()).size();
                        if (size > 0) {
                            return true;
                        }
                        return false;
                    })
                    .forEach(e -> System.out.println(e.getCarModel()));

        } else {

            carsList.stream()
                    .filter(e-> e.getCargo().getCargoType().equals(command))
                    .filter(e-> e.getEngine().getEnginePower() > 250).forEach(e-> System.out.println(e.getCarModel()));

        }
    }

    private static List<Tire> putsTireData(String[] tokens) {
        List<Tire> tireList = new ArrayList<>();
        for (int i = 5; i < tokens.length - 1; i += 2) {
            double tirePressure = Double.parseDouble(tokens[i]);
            int tireAge = Integer.parseInt(tokens[i + 1]);
            Tire tire = new Tire(tirePressure, tireAge);
            tireList.add(tire);
        }
        return tireList;
    }
}
