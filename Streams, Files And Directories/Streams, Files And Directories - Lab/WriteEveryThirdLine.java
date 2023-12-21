import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String pathInput = "D:\\Programming\\Java\\Courses\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOutput = "D:\\Programming\\Java\\Courses\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        // ЧЕТЕЦ
        Scanner in = new Scanner(new FileReader(pathInput)); // ЧЕТЕ НИ ВХОДА ОТ ДАДЕНА Folder/File.txt.

        // ПРИНТЕР
        PrintWriter out = new PrintWriter(new FileWriter(pathOutput));

        int counter = 1;
        String line = in.nextLine();

        while (in.hasNextLine()) {

            if (counter % 3 == 0) {
                out.println(line);
            }
            counter++;
            line = in.nextLine();
        }
        out.flush();  // Да източи и остатъка който е останал в (Print-Writer)-а


    }
}
