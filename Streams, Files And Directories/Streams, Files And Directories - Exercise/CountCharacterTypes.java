import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        int vowelsCount = 0;
        int otherSymbolsCount = 0;
        int punctuationCount = 0;

        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        List<Character> otherSybmols = List.of('.', ',', '!', '?');
        PrintWriter writer = new PrintWriter(new FileWriter("D:\\Programming\\Java\\Courses\\Java Advanced\\04.Streams, Files And Directories\\Streams, Files And Directories - Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\output.txt"));

        try  {
            List<String> line = Files.readAllLines(Path.of("D:\\Programming\\Java\\Courses\\Java Advanced\\04.Streams, Files And Directories\\Streams, Files And Directories - Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

            for (int i = 0; i < line.size(); i++) {

                String currentSymbol = line.get(i);
                for (int j = 0; j < currentSymbol.length(); j++) {
                    if (vowels.contains(currentSymbol.charAt(j))) {
                        vowelsCount++;
                    } else if (otherSybmols.contains(currentSymbol.charAt(j))) {
                        punctuationCount++;
                    } else if (!(currentSymbol.charAt(j) == ' ')) {
                        otherSymbolsCount++;
                    }
                }
            }
        } catch (NullPointerException e) {
            //
        }
        writer.println("Vowels: " + vowelsCount);
        writer.println("Other symbols: " + otherSymbolsCount);
        writer.println("Punctuation: " + punctuationCount);
        writer.close();
    }
}
