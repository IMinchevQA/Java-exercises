import java.io.File;
import java.util.ArrayDeque;
public class Ex08_NestedFolders_31Jan2017 {

    public static void main(String[] args){
        final String stringPath = "D:\\Videos\\Softuni\\JAVA - 2017\\01_Java_Advanced-Jan-Feb2017\\06. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams";

        File file = new File(stringPath);

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(file);

        int counter = 1;
        while (!queue.isEmpty()) {
            File currentDir = queue.poll();
            File[] nestedFiles = currentDir.listFiles();

            for (File nestedFile : nestedFiles) {
                if(nestedFile.isDirectory()) {
                    queue.offer(nestedFile);
                    counter++;
                }
            }
            System.out.println(currentDir.getName());
        }
        System.out.println(counter + " folders");
    }
}
