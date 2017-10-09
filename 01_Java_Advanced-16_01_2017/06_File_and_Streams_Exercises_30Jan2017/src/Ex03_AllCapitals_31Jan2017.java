import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Ex03_AllCapitals_31Jan2017 {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_File_and_Streams_Exercises_30Jan2017\\src\\Ex01_Test_input_2.txt";

        Path pathIn = Paths.get(inputPath);

        try {
            List<String> lines = Files.readAllLines(pathIn);
            for (String line : lines) {
                System.out.println(line.toUpperCase());

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
