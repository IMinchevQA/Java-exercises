import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03_CopyBytes_30Jan2017 {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\Ex01_Test_input.txt";

        String outputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\Ex03_CopyBytes_Output_30Jan2017.txt";

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = fis.read();
            while (oneByte >= 0) {                
                if (oneByte == ' ' || oneByte == '\n') {
                    fos.write(oneByte);
                } else {
                    String decimal = String.valueOf(oneByte);
                    for (char ch : decimal.toCharArray()) {
                        fos.write(ch);
                    }
                }
                
                oneByte = fis.read();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
