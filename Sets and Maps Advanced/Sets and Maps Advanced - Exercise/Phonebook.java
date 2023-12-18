import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, String> phoneBook = new HashMap<>();
        while (!"search".equals(line)) {

            String[] data = line.split("-");
            String name = data[0];
            String phoneNumber = data[1];
            phoneBook.put(name, phoneNumber);

            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!"stop".equals(line)) {

            if (phoneBook.containsKey(line)) {
                System.out.printf("%s -> %s\n", line, phoneBook.get(line));
            } else {
                System.out.printf("Contact %s does not exist.\n", line);
            }
            line = scanner.nextLine();
        }
    }
}
