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

    // ⦁	Method addFish(Fish fish) – adds an entity to the data if an empty space for it

    public void addFish(Fish fish) {
        if (this.capacity > this.fishes.size()) {
            this.fishes.add(fish);
        }
    }

    //⦁	Method removeFish(String species) – removes a fish by given species, if such exists,
    // and returns boolean (true if it is removed, otherwise – false)

    public boolean removeFish(String species) {
        return this.fishes.removeIf(e -> e.getSpecies().equals(species));
    }

    //⦁	Method getOldestFish()– returns the oldest fish

    public Fish getOldestFish() {
        return this.fishes.stream().sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                .findFirst().orElse(null);
    }

    //⦁	Method getFish(String species) – returns the fish with the given species
    public Fish getFish(String species) {
        return this.fishes.stream().filter(e -> e.getSpecies().equals(species)).findFirst().orElse(null);
    }

    //⦁	Method getCount – returns the number of fishes

    public int getCount() {
        return this.fishes.size();
    }

    //⦁	Method getVacancies – returns the number of remaining vacancies in the pond

    public int getVacancies() {
        return this.capacity - this.fishes.size();
    }

    //⦁	Method report() – returns a string in the following format (print the fishes in order of addition):

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Fishes in the pond:"));
        this.fishes.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });
        return sb.toString();
    }

    //⦁	"Fishes in the pond:
    //This {species} is {age} years old and reproduces through {matingSeason}.
    //This {species} is {age} years old and reproduces through {matingSeason}.
    //(…)"


}

