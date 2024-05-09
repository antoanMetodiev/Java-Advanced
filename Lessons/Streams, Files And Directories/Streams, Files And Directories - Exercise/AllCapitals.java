import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllCapitals {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = Files.newBufferedReader(Path.of("D:\\Programming\\Java\\Courses\\Java Advanced\\04.Streams, Files And Directories\\Streams, Files And Directories - Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
             BufferedWriter writer = Files.newBufferedWriter(Path.of("D:\\Programming\\Java\\Courses\\Java Advanced\\04.Streams, Files And Directories\\Streams, Files And Directories - Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\output.txt"))) {

            String line = reader.readLine();
            while (line != null) {
                writer.write(line.toUpperCase());
                writer.write("\n");
                line = reader.readLine();
            }
        } catch (IOException e) {
            //
        }
    }
}
