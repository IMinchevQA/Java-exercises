import java.io.*;
import java.io.IOException;

public class Ex05_LineNumbers_31Jan2017 {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_File_and_Streams_Exercises_30Jan2017\\src\\Ex05_Test_input.txt";

        File file = new File(inputPath);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentLine = reader.readLine();

            int lineNumber = 1;
            while (null != currentLine) {
                System.out.printf("%s. %s\n", lineNumber, currentLine);
                lineNumber++;
                currentLine = reader.readLine();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
