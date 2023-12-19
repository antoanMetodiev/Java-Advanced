import java.io.*;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String inputPath = "D:\\Programming\\Java\\Courses\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\Programming\\Java\\Courses\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        try (InputStream input = new FileInputStream(inputPath);
             OutputStream output = new FileOutputStream(outputPath)){

            int oneByte = input.read();
            while (oneByte >= 0) {
                if (oneByte != 32 && oneByte != 10) {
                    String result = "" + oneByte;
                    for (int i = 0; i < result.length(); i++) {
                        output.write(result.charAt(i));
                    }
                } else {
                    output.write((char)oneByte);
                }
                oneByte = input.read();
            }
        }
    }
}
