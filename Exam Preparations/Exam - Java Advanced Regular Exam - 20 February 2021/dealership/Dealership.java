package dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        List<Car> cars = this.data.stream().sorted((e1, e2) ->
                        Integer.compare(e2.getYear(), e1.getYear()))
                .collect(Collectors.toList());

        if (cars.isEmpty()) {
            return null;
        }
        return cars.get(0);
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("The cars are in a car dealership %s:", this.name));
        for (Car car : data) {
            sb.append(System.lineSeparator());
            sb.append(car);
        }
        return sb.toString();
    }
}
