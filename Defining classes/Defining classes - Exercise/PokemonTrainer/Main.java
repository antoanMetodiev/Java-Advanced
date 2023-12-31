package PokemonTrainer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();
        while (!line.equals("Tournament")) {

            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, pokemonHealth);
            Trainer trainer = new Trainer(trainerName, 0);

            if (!trainerMap.containsKey(trainerName)) {

                trainer.setPokemonList(new ArrayList<>());
                trainer.getPokemonList().add(pokemon);
                trainerMap.put(trainerName, trainer);

            } else {
                trainerMap.get(trainerName).getPokemonList().add(pokemon);

            }

            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!line.equals("End")) {

            String wantedElement = line;

            checkTrainerMapForTheEl(wantedElement, trainerMap);


            line = scanner.nextLine();
        }

        // "%s %d %d\n", this.name, this.badgesCount, this.pokemonList.size()

        trainerMap.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getBadgesCount(), e1.getValue().getBadgesCount()))
                .forEach(e -> System.out.printf("%s %d %d\n"
                        , e.getKey(), e.getValue().getBadgesCount(), e.getValue().getPokemonList().size()));


    }

    private static void checkTrainerMapForTheEl(String wantedItem, Map<String, Trainer> trainerMap) {


        for (Trainer value : trainerMap.values()) {

            int pokemonListSize = value.getPokemonList().size();
            boolean wasInside = false;
            for (int i = 0; i < pokemonListSize; i++) {

                String currentElement = value.getPokemonList().get(i).getElement();

                if (wantedItem.equals(currentElement)) {

                    wasInside = true;
                    break;
                }
            }

            if (!wasInside) {
                decreasesAllPokemonsHealth(trainerMap, value);
            } else {

                int previousBadgesCount = value.getBadgesCount();
                String key = value.getName();

                value.setBadgesCount(++previousBadgesCount);
            }
        }
    }

    private static void decreasesAllPokemonsHealth(Map<String, Trainer> trainerMap, Trainer value) {

//        int listSize = ;

        for (int i = 0; i < value.getPokemonList().size(); i++) {

            if (!value.getPokemonList().isEmpty()) {

                int previousHealht = value.getPokemonList().get(i).getHealth();
                String key = value.getName();

                trainerMap.get(key).getPokemonList().get(i).setHealth(previousHealht - 10);

                if (trainerMap.get(key).getPokemonList().get(i).getHealth() <= 0) {
                    trainerMap.get(key).getPokemonList().remove(i);
                    i--;
                }
            }

        }
    }
}
