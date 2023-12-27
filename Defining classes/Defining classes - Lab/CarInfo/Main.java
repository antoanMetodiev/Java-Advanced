package CarInfo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String[] carData = scanner.nextLine().split("\\s+");
            String brand = carData[0];
            String type = carData[1];
            int hp = Integer.parseInt(carData[2]);

            Car car = new Car(brand, type, hp);
            System.out.println(car.toString());
        }
    }
}
