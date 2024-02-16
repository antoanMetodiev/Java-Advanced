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

    // ⦁	Method addKid(Kid kid) – adds an entity to the data if there is an empty space for the kid.

    public void addKid(Kid kid) {
        if (this.capacity > this.data.size()) {
            this.data.add(kid);
        }
    }

    //⦁	Method removeKid(String name) – removes the kid by given name, if such exists, and returns boolean.

    public boolean removeKid(String name) {
        return this.data.removeIf(e -> e.getName().equals(name));
    }

    //⦁	Method getKid(String street) – returns the kid of a given street or null if no such kid exists.

    public Kid getKid(String street) {
        return this.data.stream().filter(e -> e.getStreet().equals(street)).findFirst().orElse(null);
    }

    //⦁	Getter getAllKids() – returns the number of kids.

    public int getAllKids() {
        return this.data.size();
    }

    //⦁	getStatistics() – returns a String in the following format:

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("Children who visited a house for candy:");
        this.data.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(String.format("%s from %s street", e.getName(), e.getStreet()));
        });
        return sb.toString();
    }

    //" Children who visited a house for candy:
    //		 {name} from {street} street
    //          {name} from {street} street
    //          (…)"


}
