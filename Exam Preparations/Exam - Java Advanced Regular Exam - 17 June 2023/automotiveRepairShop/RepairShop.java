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

    // ⦁	Method addVehicle(Vehicle vehicle) – adds an entity to the collection
    // of Vehicles, if the Capacity allows it.
    public void addVehicle(Vehicle vehicle) {
        if (this.capacity > this.vehicles.size()) {
            this.vehicles.add(vehicle);
        }
    }

    //⦁	Method removeVehicle(String vin) – removes a vehicle by given vin,
    // f such exists, and returns boolean (true if it is removed, otherwise – false)

    public boolean removeVehicle(String vin) {
        return this.vehicles.removeIf(e -> e.getVIN().equals(vin));
    }

    //⦁	Method getCount() – returns the number of vehicles
    // , registered in the RepairShop

    public int getCount() {
        return this.vehicles.size();
    }

    //⦁	Method getLowestMileage() – returns the Vehicle
    // with the lowest value of Mileage property.

    public Vehicle getLowestMileage() {
        return this.vehicles.stream().sorted(Comparator.comparingInt(Vehicle::getMileage))
                .findFirst().orElse(null);
    }

    //⦁	Method report() – returns a string in the following format:

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Vehicles in the preparatory:"));
        this.vehicles.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });
        return sb.toString();
    }

    //⦁	"Vehicles in the preparatory:
    //{Vehicle1}
    //{Vehicle2}
    //(…)"


}
