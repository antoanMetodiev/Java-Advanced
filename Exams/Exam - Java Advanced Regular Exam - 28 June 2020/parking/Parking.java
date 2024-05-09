package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        List<Car> collect = this.data.stream()
                .filter(e -> e.getManufacturer().equals(manufacturer))
                .filter(e -> e.getModel().equals(model))
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            return false;
        }
        this.data.remove(collect.get(0));
        return true;
    }

    public Car getLatestCar() {
        if (this.data.isEmpty()) {
            return null;
        }
        return this.data.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getYear(), e1.getYear()))
                .collect(Collectors.toList()).get(0);
    }

    public Car getCar(String manufacturer, String model) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getManufacturer().equals(manufacturer) &&
                    this.data.get(i).getModel().equals(model)) {

                return this.data.get(i);
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder(String.format("The cars are parked in %s:", this.type));
        for (int i = 0; i < this.data.size(); i++) {
            result.append(System.lineSeparator());
            result.append(this.data.get(i).toString());
        }
        return result.toString();
    }
}
