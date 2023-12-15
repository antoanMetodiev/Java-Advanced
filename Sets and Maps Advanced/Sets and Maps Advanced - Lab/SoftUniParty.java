import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guest = new TreeSet<>();
        Set<String> vipGuests = new TreeSet<>();

        String line = scanner.nextLine();
        while (!"PARTY".equals(line)) {

            if (!(line.length() == 8)) {
                line = scanner.nextLine();
                continue;
            }

            char isNumber = line.charAt(0);
            if (isNumber >= 48 && isNumber <= 57) {
                vipGuests.add(line);
            } else {
                guest.add(line);
            }
            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!"END".equals(line)) {

            if (vipGuests.contains(line)) {
               vipGuests.remove(line);
            } else if (guest.contains(line)) {
                guest.remove(line);
            }
            line = scanner.nextLine();
        }

        System.out.println(vipGuests.size() + guest.size());
        vipGuests.forEach(System.out::println);
        guest.forEach(System.out::println);

    }
}
