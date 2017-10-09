import java.io.File;
import java.util.ArrayDeque;

public class Ex08_GetFolderSize_1Feb2017 {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/";
    private static final String TARGET_PATH = PROJECT_PATH + "Resources/";
    public static void main (String[] args) {
        System.out.println(TARGET_PATH);
        ArrayDeque<File> directories = new ArrayDeque<File>();

        File dir = new File(TARGET_PATH);
        directories.offer(dir);

        long size = 0;

        while (!directories.isEmpty()) {
            File currentFolder = directories.poll();

            for (File file : currentFolder.listFiles()) {
                if (file.isFile()) {
                    size += file.length();
                } else {
                    directories.add(file);
                }
            }
        }
        System.out.printf("Folder size: %s", size);
    }
}
