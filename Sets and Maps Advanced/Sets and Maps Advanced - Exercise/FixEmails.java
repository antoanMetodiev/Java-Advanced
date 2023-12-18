import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, String> emails = new LinkedHashMap<>();
        while (!"stop".equals(line)) {

            String name = line;
            String email = scanner.nextLine();

            String firstSubstring = email.substring(email.length() - 2);
            String secondSubstring = email.substring(email.length() - 3);
            if (!checkSubstrings(firstSubstring, secondSubstring, email)) {
                emails.put(name, email);
            }
            line = scanner.nextLine();
        }
        emails.forEach((key, value) -> System.out.printf("%s -> %s\n", key , value));
    }

    private static boolean checkSubstrings(String firstSubstring, String secondSubstring, String email) {
        return firstSubstring.equals("us") || firstSubstring.equals("uk") || secondSubstring.equals("com");
    }
}
