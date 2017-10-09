import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Ex05_Write_Every_Third_Line_31Jan2017 {
    public static void main(String[] args){
        String inputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\Ex01_Test_input.txt";

        String outputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\Ex05_WriteEveryThirdLine_31Jan2017.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        PrintWriter writer = new PrintWriter(outputPath)) {
            String line = reader.readLine();
            int counter = 1;
            while (line != null) {
                if (counter % 3 == 0) {
                   writer.println(line);
                }
                counter++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
