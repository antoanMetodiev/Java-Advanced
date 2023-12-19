import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {

    public static void main(String[] args) throws IOException {

        String inputPath = "D:\\Programming\\Java\\Courses\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\Programming\\Java\\Courses\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        Set<Character> forbiddenChars = new HashSet<>();
        Collections.addAll(forbiddenChars, '.',',','!','?');

        try (InputStream in = new FileInputStream(inputPath);
             OutputStream output = new FileOutputStream(outputPath)) {

            int oneByte = in.read();
            while (oneByte >= 0) {

                if (!forbiddenChars.contains((char)oneByte)) {
                    output.write((char)oneByte);
                }
                oneByte = in.read();
            }

        } catch (FileNotFoundException error) {

        }


    }
}
