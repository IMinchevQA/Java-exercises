import java.io.File;

public class Ex07_ListFiles_31Jan2017 {
    public static void main(String[] args){
        final String stringPath = "D:\\Videos\\Softuni\\JAVA - 2017\\01_Java_Advanced-Jan-Feb2017\\06. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams\\";
        File file = new File(stringPath);

        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (!f.isDirectory()) {
                    System.out.printf("%s: %s", f.getName(), f.length());
                    System.out.println();
                }
            }
        }
    }
}
