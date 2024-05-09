package parking;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking("Underground parking garage", 5);
        Car volvo = new Car("Volvo", "XC70", 2010);
        System.out.println(volvo); // Volvo XC70 (2010)

        parking.add(volvo);
        System.out.println(parking.remove("Volvo", "XC90")); // false
        System.out.println(parking.remove("Volvo", "XC70")); // true

        Car peugeot = new Car("Peugeot", "307", 2011);
        Car audi = new Car("Audi", "S4", 2005);

        parking.add(peugeot);
        parking.add(audi);

        Car latestCar = parking.getLatestCar();
        System.out.println(latestCar); // Peugeot 307 (2011)

        Car audiS4 = parking.getCar("Audi", "S4");
        
        System.out.println(audiS4); // Audi S4 (2005)
        System.out.println(parking.getCount()); // 2
        System.out.println(parking.getStatistics());
    }
}
