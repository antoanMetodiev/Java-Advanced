import java.io.File;

public class ListFiles {
    public static void main(String[] args) {


        File file = new File("D:\\Programming\\Java\\Courses\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (file.exists()) {
            if (file.isDirectory()) {

                File[] allFiles = file.listFiles();
                for (File f : allFiles) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]\n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
