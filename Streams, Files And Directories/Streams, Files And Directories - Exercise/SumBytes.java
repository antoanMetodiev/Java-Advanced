import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class SumBytes {
    public static void main(String[] args) {

        try (Scanner inputPath = new Scanner(new FileReader("D:\\Programming\\Java\\Courses\\Java Advanced\\04.Streams, Files And Directories\\Streams, Files And Directories - Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));) {

            long allSum = 0;
            while (inputPath.hasNextLine()) {
                allSum += Arrays.stream(inputPath.nextLine().split("")).mapToInt(e -> e.charAt(0)).sum();
            }
            System.out.println(allSum);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
