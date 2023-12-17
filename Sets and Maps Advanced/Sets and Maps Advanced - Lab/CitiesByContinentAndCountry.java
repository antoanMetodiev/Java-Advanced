import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // continents
        Map<String, Map<String, List<String>>> continentsMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {

            String[] data = scanner.nextLine().split("\\s+");
            String continent = data[0]; // key
            String country = data[1];
            String town = data[2];

            if (!continentsMap.containsKey(continent)) {

                continentsMap.put(continent, new LinkedHashMap<>());
                continentsMap.get(continent).put(country, new ArrayList<>());
                continentsMap.get(continent).get(country).add(town);
            } else {
                checkTheMapContainsCountry(continentsMap, continent, country, town);
            }
        }

        continentsMap.forEach((key, value) -> {
            System.out.println(key + ":");
            for (Map.Entry<String, List<String>> country : value.entrySet()) {
                System.out.printf("%s -> ", country.getKey());
                System.out.println(String.join(", ", country.getValue()));
            }
        });
    }

    private static void checkTheMapContainsCountry(Map<String, Map<String, List<String>>> continentsMap, String continent, String country, String town) {
        if (!continentsMap.get(continent).containsKey(country)) {
            
            continentsMap.get(continent).put(country, new ArrayList<>());
            continentsMap.get(continent).get(country).add(town);
        } else {
            continentsMap.get(continent).get(country).add(town);
        }
    }
}
