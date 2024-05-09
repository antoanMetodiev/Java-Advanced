package SpeedRacing;

import java.util.List;
import java.util.Map;

public class Car {
    private double quantityFuel;
    private double fuelExpense; 
    private int traveledDistance;

    public Car(int quantityFuel, double fuelExpense, int traveledDistance) {
        this.quantityFuel = quantityFuel;
        this.fuelExpense = fuelExpense;
        this.traveledDistance = traveledDistance;
    }

    public static void checkForEnoughFuel(String carModel, int traveledDistance, Map<String, List<Car>> carsCollector) {

        double spentFuel = carsCollector.get(carModel).get(0).getFuelExpense();
        spentFuel *= traveledDistance;
        double previousFuel = carsCollector.get(carModel).get(0).getQuantityFuel();

        if (previousFuel - spentFuel >= 0) {
        
            carsCollector.get(carModel).get(0).setQuantityFuel(previousFuel - spentFuel);
            int previousTraveledKm = carsCollector.get(carModel).get(0).getTraveledDistance();
            carsCollector.get(carModel).get(0).setTraveledDistance(previousTraveledKm + traveledDistance);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public double getQuantityFuel() {
        return quantityFuel;
    }

    public void setQuantityFuel(double quantityFuel) {
        this.quantityFuel = quantityFuel;
    }

    public double getFuelExpense() {
        return fuelExpense;
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }

    public void setTraveledDistance(int traveledDistance) {
        this.traveledDistance = traveledDistance;
    }
}
