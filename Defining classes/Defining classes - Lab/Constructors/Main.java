package Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Car.sayHello());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            Car car;

            System.out.println(Car.sayHello());

            if (carData.length == 3) {
                String type = carData[1];
                int horsePower = Integer.parseInt(carData[2]);
                car = new Car(model, type, horsePower);
                System.out.println(car.toString());
            } else {
                car = new Car(model);
                System.out.println(car.printOnlyModel());
            }
        }
    }
}
