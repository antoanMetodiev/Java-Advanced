import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {

        Map<String, Integer> words = new LinkedHashMap<>();

        try (
                Scanner firstReader = new Scanner(new FileReader("D:\\Programming\\Java\\Courses\\Java Advanced\\04.Streams, Files And Directories\\Streams, Files And Directories - Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\words.txt"));
                BufferedReader secondReader = new BufferedReader(new FileReader("D:\\Programming\\Java\\Courses\\Java Advanced\\04.Streams, Files And Directories\\Streams, Files And Directories - Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\text.txt"))
        ) {
            Arrays.stream(firstReader.nextLine().split("\\s+")).forEach(e -> words.put(e, 0));

            List<String> text = Files.readAllLines(Path.of("D:\\Programming\\Java\\Courses\\Java Advanced\\04.Streams, Files And Directories\\Streams, Files And Directories - Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\text.txt"));
            text.get(0).split(" ");

            String[] elsInText = text.get(0).split(" ");
            for (String word : elsInText) {

                if (words.containsKey(word)) {
                    int previousValue = words.get(word);
                    words.put(word, ++previousValue);
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Programming\\Java\\Courses\\Java Advanced\\04.Streams, Files And Directories\\Streams, Files And Directories - Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\result.txt"));

            for (Map.Entry<String, Integer> word : words.entrySet()) {
                writer.write(String.format("%s - %d\n", word.getKey(), word.getValue()));
            }
            writer.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
