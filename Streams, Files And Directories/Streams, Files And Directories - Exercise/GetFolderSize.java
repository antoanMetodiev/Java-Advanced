import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {

        String path = "D:\\Programming\\Java\\Courses\\Java Advanced\\04.Streams, Files And Directories\\Streams, Files And Directories - Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(path);

        // Дебъгни задачата 1-път
        int sum = 0;
        if (folder.exists()) {
            if (folder.isDirectory()) {

                File[] files = folder.listFiles();
                for (File file : files) {
                    if (!file.isDirectory()) {
                        sum += file.length();
                    }
                }
            }
        }
        System.out.printf("Folder size: %d\n", sum);
    }
}
