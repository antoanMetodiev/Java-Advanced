package automotiveRepairShop;

public class Main {
    public static void main(String[] args) {
        RepairShop repairShop = new RepairShop(5);
        Vehicle vehicle1 = new Vehicle("1HGCM82633A123456", 50000, "Oil leakage");
        System.out.println(vehicle1);
        repairShop.addVehicle(vehicle1);
        System.out.println(repairShop.removeVehicle("1HGCM82633A123459")); 
        System.out.println(repairShop.removeVehicle("1HGCM82633A123456"));

        Vehicle vehicle2 = new Vehicle("5YJSA1CN7DFP12345", 80000, "Overheating issue");
        Vehicle vehicle3 = new Vehicle("JM1GJ1W56F1234567", 120000, "Coolant leakage");
        Vehicle vehicle4 = new Vehicle("2C3CDXAT4CH123456", 95000, "Timing belt failure");
        Vehicle vehicle5 = new Vehicle("WAUZZZ8K9FA123456", 66000, "Cylinder misfire");
        Vehicle vehicle6 = new Vehicle("1G1BL52P3RR123456", 150000, "Transmission failure");
        Vehicle vehicle7 = new Vehicle("JTDKB20U993123456", 65000, "Piston damage");

        repairShop.addVehicle(vehicle2);
        repairShop.addVehicle(vehicle3);
        repairShop.addVehicle(vehicle4);
        repairShop.addVehicle(vehicle5);

        System.out.println(repairShop.getCount()); 
        repairShop.addVehicle(vehicle6);
        repairShop.addVehicle(vehicle7);
        System.out.println(repairShop.getCount()); 
        System.out.println(repairShop.getLowestMileage()); 
        System.out.println(repairShop.report());
    }
}
