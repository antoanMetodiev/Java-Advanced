package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    // ⦁	name: String
    //⦁	capacity: int
    //⦁	size: int - the volume of the pool

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

    // ⦁	Getter getName().
    //⦁	Getter getCapacity().
    //⦁	Getter getSize().
    //⦁	Getter getFishInPool() - returns the number of fish in the current pool.

    //⦁	Method add(Fish fish) - add the entity if there isn't a fish with the same
    // name and if there is enough space for it.
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

    //⦁	Method remove(String name) - removes a fish from the pool with the given name,
    // if such exists, and returns a boolean if the deletion is successful.

    public boolean remove(String name) {
        return this.fishInPool.removeIf(e -> e.getName().equals(name));
    }

    //⦁	Method findFish(String name) - returns a fish with the given name, it doesn't exist return null.

    public Fish findFish(String name) {
        return this.fishInPool.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    //⦁	Method report() - returns information about the aquarium and the fish inside it in the following format:
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d", this.name, this.size));
        this.fishInPool.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });
        return sb.toString();
    }

    //"Aquarium: {name} ^ Size: {size}
    //{Fish1}
    //{Fish2}
    //…"


}
