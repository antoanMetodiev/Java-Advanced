import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Set<String>> players = new LinkedHashMap<>();
        while (!"JOKER".equals(line)) {

            List<String> data = Arrays.stream(line.split(": ")).collect(Collectors.toList());
            String name = data.get(0);
            String[] els = data.get(1).split(",\\s+");
            
            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
                Arrays.stream(els).forEach(e -> players.get(name).add(e));
            } else {
                Arrays.stream(els).forEach(e -> players.get(name).add(e));
            }
            line = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> player : players.entrySet()) {
            int totalPoints = 0;
            for (String value : player.getValue()) {

                String type = value.substring(value.length() - 1);
                int typeValue = calculateTypeValue(type);

                String substring = value.substring(0, value.length() - 1);
                int numberValue = calculateNumberValue(substring);
                totalPoints += typeValue * numberValue;
            }
            System.out.printf("%s: %d\n", player.getKey(), totalPoints);
        }
    }

    private static int calculateNumberValue(String substring) {
        
        int points = 0;
        char symbol = substring.charAt(0);
        
        if (symbol >= 50 && symbol <= 57) { 
            points = Integer.parseInt("" + symbol);
        } else if (substring.equals("10")) {
            points = 10;
        } else {
            switch (substring) {
                case "J":
                    points = 11;
                    break;
                case "Q":
                    points = 12;
                    break;
                case "K":
                    points = 13;
                    break;
                case "A":
                    points = 14;
                    break;
            }
        }
        return points;
    }

    private static int calculateTypeValue(String typeValue) {
        int points = 0;
        switch (typeValue) {
            case "S":
                points = 4;
                break;
            case "H":
                points = 3;
                break;
            case "D":
                points = 2;
                break;
            case "C":
                points = 1;
                break;
        }
        return points;
    }
}
