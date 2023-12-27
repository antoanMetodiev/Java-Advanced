package CarInfo;

public class Car {
    private String brand;
    private String type;
    private int hp;

    public Car(String brand, String type, int hp) {
        this.brand = brand;
        this.type = type;
        this.hp = hp;
    }

    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.brand, this.type, this.hp);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
