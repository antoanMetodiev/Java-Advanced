package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.fishInPool = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }
    
    public void add(Fish fish) {
        boolean isEquals = false;
        for (Fish fish1 : this.fishInPool) {
            if (fish1.getName().equals(fish.getName())) {
                isEquals = true;
                break;
            }
        }
        
        if (!isEquals && this.capacity > this.fishInPool.size()) {
            this.fishInPool.add(fish);
        }
    }
    
    public boolean remove(String name) {
        return this.fishInPool.removeIf(e -> e.getName().equals(name));
    }

    public Fish findFish(String name) {
        return this.fishInPool.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d", this.name, this.size));
        this.fishInPool.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });
        return sb.toString();
    }
}
