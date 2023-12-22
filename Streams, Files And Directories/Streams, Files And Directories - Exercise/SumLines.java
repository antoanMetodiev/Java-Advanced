import java.io.*;

public class SumLines {
    public static void main(String[] args) throws IOException {

        BufferedReader inputPath = new BufferedReader(new FileReader("D:\\Programming\\Java\\Courses\\Java Advanced\\04.Streams, Files And Directories\\Streams, Files And Directories - Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        String line = inputPath.readLine();
        while (line != null) {

            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
            System.out.println(sum);
            line = inputPath.readLine();
        }
        inputPath.close();
    }
}
