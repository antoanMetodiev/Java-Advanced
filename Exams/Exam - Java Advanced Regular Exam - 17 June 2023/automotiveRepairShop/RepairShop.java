package automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {
    private List<Vehicle> vehicles;
    private int capacity;

    public RepairShop(int capacity) {
        this.vehicles = new ArrayList<>();
        this.capacity = capacity;
    }

    public void addVehicle(Vehicle vehicle) {
        if (this.capacity > this.vehicles.size()) {
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        return this.vehicles.removeIf(e -> e.getVIN().equals(vin));
    }

    public int getCount() {
        return this.vehicles.size();
    }

    public Vehicle getLowestMileage() {
        return this.vehicles.stream().sorted(Comparator.comparingInt(Vehicle::getMileage))
                .findFirst().orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Vehicles in the preparatory:"));
        this.vehicles.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });
        return sb.toString();
    }
}
