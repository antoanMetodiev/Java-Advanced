package PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private List<Pokemon> pokemonList;
    private int badgesCount;

    public Trainer(String name, int badgesCount) {
        this.name = name;
        this.badgesCount = badgesCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public int getBadgesCount() {
        return badgesCount;
    }

    public void setBadgesCount(int badgesCount) {
        this.badgesCount = badgesCount;
    }
}
