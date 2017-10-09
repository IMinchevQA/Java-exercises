import java.io.FileInputStream;
import java.io.IOException;
public class Ex01_ReadFile_30Jan2017 {
    public static void main(String[] args) {
        String path = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\Ex01_Test_input.txt";

        try (FileInputStream fis = new FileInputStream(path)) {
            int oneByte = fis.read();

            while (oneByte >= 0) {
                 System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fis.read();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
