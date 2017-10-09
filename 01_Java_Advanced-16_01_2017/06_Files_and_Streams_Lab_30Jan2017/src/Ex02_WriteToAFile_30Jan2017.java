import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

public class Ex02_WriteToAFile_30Jan2017 {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\Ex01_Test_input.txt";

        String outputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\Ex02_WriteToAFile_Output_30Jan2017.txt";

        HashSet<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, ',', '.', '!', '?');

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = fis.read();
            while (oneByte >= 0) {
                if (!punctuation.contains((char)oneByte)) {
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
