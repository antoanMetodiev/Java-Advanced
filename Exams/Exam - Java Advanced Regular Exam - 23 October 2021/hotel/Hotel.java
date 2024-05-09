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

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        return this.roster.removeIf(e -> e.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        return this.roster.stream().filter(e -> e.getName().equals(name) && e.getHometown().equals(hometown))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("The people in the hotel %s are:", this.name));
        this.roster.forEach(e-> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });
        return sb.toString();
    }
}
