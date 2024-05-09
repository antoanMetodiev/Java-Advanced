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
    
    public void addCloth(Cloth cloth) {
        if (this.capacity > this.data.size()) {
            this.data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        return this.data.removeIf(e -> e.getColor().equals(color));
    }

    public Cloth getSmallestCloth() {
        return this.data.stream().sorted(Comparator.comparingInt(Cloth::getSize)).findFirst().orElse(null);
    }

    public Cloth getCloth(String color) {
        return this.data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("%s magazine contains:", this.type));
        this.data.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });
        return sb.toString();
    }
}
