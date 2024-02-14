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

    //⦁	Field data – List that holds added animals
    //⦁	Method add(Animal animal) – adds an entity to the data if there is an empty cell for the animal.

    public void add(Animal animal) {
        if (this.capacity > this.data.size()) {
            this.data.add(animal);
        }
    }

    //⦁	Method remove(String name) – removes the animal by given name, if such exists, and returns boolean.

    public boolean remove(String name) {
        return this.data.removeIf(e -> e.getName().equals(name));
    }

    //⦁	Method getAnimal(String name, String caretaker) – returns the animal with
    // the given name and caretaker or null if no such animal exists.

    public Animal getAnimal(String name, String caretaker) {
        return this.data.stream().filter(e -> e.getName().equals(name) && e.getCaretaker()
                .equals(caretaker)).findFirst().orElse(null);
    }

    //⦁	Method getOldestAnimal() – returns the oldest Animal.

    public Animal getOldestAnimal() {
        return this.data.stream().sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                .findFirst().orElse(null);
    }

    //⦁	Getter getCount – returns the number of animals.

    public int getCount() {
        return this.data.size();
    }

    //⦁	getStatistics() – returns a String in the following format:

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("The shelter has the following animals:"));
        this.data.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(String.format("%s %s", e.getName(), e.getCaretaker()));
        });
        return sb.toString();
    }

    //⦁	"The shelter has the following animals:
    //{name} {caretaker}
    //{name} {caretaker}
    //   (…)"


}
