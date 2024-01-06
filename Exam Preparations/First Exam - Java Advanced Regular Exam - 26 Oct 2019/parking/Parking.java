package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }
    
    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer)
                && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        return this.data.stream()
                .max(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }
    
    public Car getCar(String manufacturer, String model) {
        return this.data.stream()
                .filter(car -> car.getManufacturer().equals(manufacturer) &&
                        car.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:", this.type));
        this.data.forEach(car -> {
            sb.append(System.lineSeparator());
            sb.append(car.toString());
        });
        return sb.toString();
    }
}
