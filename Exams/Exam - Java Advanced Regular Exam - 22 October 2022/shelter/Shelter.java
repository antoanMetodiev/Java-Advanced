package shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (this.capacity > this.data.size()) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(e -> e.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker) {
        return this.data.stream().filter(e -> e.getName().equals(name) && e.getCaretaker()
                .equals(caretaker)).findFirst().orElse(null);
    }

    public Animal getOldestAnimal() {
        return this.data.stream().sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("The shelter has the following animals:"));
        this.data.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(String.format("%s %s", e.getName(), e.getCaretaker()));
        });
        return sb.toString();
    }
}
