import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Programming\\Java\\Courses\\Java Advanced\\04.Streams, Files And Directories\\Streams, Files And Directories - Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\result.txt"))) {

            List<String> firstInEls = Files.readAllLines(Path.of("D:\\Programming\\Java\\Courses\\Java Advanced\\04.Streams, Files And Directories\\Streams, Files And Directories - Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputOne.txt"));
            List<String> secondInEls = Files.readAllLines(Path.of("D:\\\\Programming\\\\Java\\\\Courses\\\\Java Advanced\\\\04.Streams, Files And Directories\\\\Streams, Files And Directories - Exercise\\\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\\\Exercises Resources\\\\inputTwo.txt"));

            for (String el : firstInEls) {
                writer.write(el);
                writer.newLine();
            }
            for (String el : secondInEls) {
                writer.write(el);
                writer.newLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
