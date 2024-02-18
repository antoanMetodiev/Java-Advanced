package halloween;

public class Main {
    public static void main(String[] args) {
        House house = new House(6);
        Kid firstKid = new Kid("Yoana", 10, "Osogovska");
        System.out.println(firstKid);
        house.addKid(firstKid);
        System.out.println(house.removeKid("Sara"));
        System.out.println(house.removeKid("Yoana"));

        Kid secondKid = new Kid("Lily", 5, "Pirina");
        Kid thirdKid = new Kid("Anna", 7, "Pirotska");
        Kid fourthKid = new Kid("Selin", 8, "Solunska");
        house.addKid(secondKid);
        house.addKid(thirdKid);
        house.addKid(fourthKid);

        Kid kid = house.getKid("Pirotska");
        System.out.println(kid); 
        System.out.println(house.getAllKids()); 
        System.out.println(house.getStatistics());
    }
}
