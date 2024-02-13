package magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private List<Cloth> data;
    private String type;
    private int capacity;

    public Magazine(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    // ⦁	List<Cloth> data – collection that holds added clothes
    //⦁	Method addCloth(Cloth cloth) – adds an entity to the data if there is room for it

    public void addCloth(Cloth cloth) {
        if (this.capacity > this.data.size()) {
            this.data.add(cloth);
        }
    }

    //⦁	Method removeCloth(String color) – removes a cloth by given color,
    // if such exists, and returns boolean (true if it is removed, otherwise – false)

    public boolean removeCloth(String color) {
        return this.data.removeIf(e -> e.getColor().equals(color));
    }

    //⦁	Method getSmallestCloth() – returns the smallest cloth

    public Cloth getSmallestCloth() {
        return this.data.stream().sorted(Comparator.comparingInt(Cloth::getSize)).findFirst().orElse(null);
    }

    //⦁	Method getCloth(String color) – returns the cloth with the given color

    public Cloth getCloth(String color) {
        return this.data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    //⦁	Method getCount – returns the number of clothes

    public int getCount() {
        return this.data.size();
    }

    //⦁	Method report() – returns a string in the following format (print the clothes in order of appearance):

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("%s magazine contains:", this.type));
        this.data.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });
        return sb.toString();
    }

    //⦁	"{type} magazine contains:
    //{Cloth1}
    //{Cloth2}
    //(…)"


}
