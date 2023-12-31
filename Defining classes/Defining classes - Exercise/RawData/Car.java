package RawData;

import java.util.List;

public class Car {
    private String carModel;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tireList;

    public Car(String carModel, Engine engine, Cargo cargo, List<Tire> tire) {
        this.carModel = carModel;
        this.engine = engine;
        this.cargo = cargo;
        this.tireList = tire;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Tire> getTireList() {
        return tireList;
    }

    public void setTireList(List<Tire> tireList) {
        this.tireList = tireList;
    }
}
