package fishingPond;

import java.util.ArrayList;
import java.util.List;

public class Pond {
    private List<Fish> fishes;
    private int capacity;

    public Pond(int capacity) {
        this.fishes = new ArrayList<>();
        this.capacity = capacity;
    }

    public void addFish(Fish fish) {
        if (this.capacity > this.fishes.size()) {
            this.fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        return this.fishes.removeIf(e -> e.getSpecies().equals(species));
    }

    public Fish getOldestFish() {
        return this.fishes.stream().sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                .findFirst().orElse(null);
    }

    public Fish getFish(String species) {
        return this.fishes.stream().filter(e -> e.getSpecies().equals(species)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.fishes.size();
    }

    public int getVacancies() {
        return this.capacity - this.fishes.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Fishes in the pond:"));
        this.fishes.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });
        return sb.toString();
    }
}

