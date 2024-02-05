package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                // see this if you have wrong result:
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                return;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
                return;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        // see this if you have wrong result:

        List<Player> removedEl = new ArrayList<>();
        for (Player player : this.roster) {
            if (player.getClazz().equals(clazz)) {
                removedEl.add(player);
            }
        }
        for (int i = 0; i < removedEl.size(); i++) {

            String elForRemove = removedEl.get(i).getClazz();
            this.roster = this.roster.stream()
                    .filter(e -> !e.getClazz().equals(elForRemove)).collect(Collectors.toList());
        }
        Player[] result = new Player[removedEl.size()];
        for (int i = 0; i < removedEl.size(); i++) {
            result[i] = removedEl.get(i);
        }
        return result;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder(String.format("Players in the guild: %s:", this.name));
        for (Player player : this.roster) {
            result.append(System.lineSeparator());
            result.append(player.toString());
        }
        return result.toString();
    }


}
