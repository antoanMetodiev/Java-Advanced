package RawData;

public class Tire {
    private double pressure;
    private int tireAge;

    public Tire(double pressure, int tireAge) {
        this.pressure = pressure;
        this.tireAge = tireAge;
    }

    public double getPressure() {
        return pressure;
    }

    public int getTireAge() {
        return tireAge;
    }
}
