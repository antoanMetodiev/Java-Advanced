package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    // ⦁ Method add(Person person) - adds an entity to the roster if there is room for it
    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    //⦁	Method remove(String name) - removes a person by given name, if such exists, and returns boolean
    public boolean remove(String name) {
        return this.roster.removeIf(e -> e.getName().equals(name));
    }

    //⦁	Method getPerson(String name, String hometown) – returns the people with the given name and hometown or
    // null if there is no such person.
    public Person getPerson(String name, String hometown) {
        return this.roster.stream().filter(e -> e.getName().equals(name) && e.getHometown().equals(hometown))
                .findFirst().orElse(null);
    }

    //⦁	Getter getCount() – returns the number of people.
    public int getCount() {
        return this.roster.size();
    }

    //⦁	getStatistics() – returns a String in the following format:
    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("The people in the hotel %s are:", this.name));
        this.roster.forEach(e-> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });
        return sb.toString();
    }
}
