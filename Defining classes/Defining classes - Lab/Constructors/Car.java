package Constructors;

public class Car {
    String model;
    String type;
    int horsePower;

    public String toString(){
        return String.format("The car is: %s %s - %d HP.", this.model, this.type, this.horsePower);
    }

    public String printOnlyModel(){
        return String.format("The car is: %s unknown - -1 HP.", this.model);
    }

    static String sayHello(){
        return "hello";
    }

    public Car(String model){
        this.model = model;
    }

    public Car(String model, String type, int horsePower){
        this.model = model;
        this.type = type;
        this.horsePower = horsePower;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
