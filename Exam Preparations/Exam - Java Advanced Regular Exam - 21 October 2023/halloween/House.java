package halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Kid> data;
    private int capacity;

    public House(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void addKid(Kid kid) {
        if (this.capacity > this.data.size()) {
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        return this.data.removeIf(e -> e.getName().equals(name));
    }

    public Kid getKid(String street) {
        return this.data.stream().filter(e -> e.getStreet().equals(street)).findFirst().orElse(null);
    }

    public int getAllKids() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("Children who visited a house for candy:");
        this.data.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(String.format("%s from %s street", e.getName(), e.getStreet()));
        });
        return sb.toString();
    }
}
