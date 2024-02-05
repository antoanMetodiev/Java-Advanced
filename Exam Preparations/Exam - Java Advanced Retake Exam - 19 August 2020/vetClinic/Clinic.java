package vetClinic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name) && this.data.get(i).getOwner().equals(owner)) {
                return this.data.get(i);
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        return this.data.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                .collect(Collectors.toList()).get(0);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder(String.format("The clinic has the following patients:"));
        for (int i = 0; i < this.data.size(); i++) {
            result.append(System.lineSeparator());
            result.append(String.format("%s %s", this.data.get(i).getName(), this.data.get(i).getOwner()));
        }
        return result.toString();
    }


}
