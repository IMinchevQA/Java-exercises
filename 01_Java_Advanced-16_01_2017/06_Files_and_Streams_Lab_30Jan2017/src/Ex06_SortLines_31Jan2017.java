import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Ex06_SortLines_31Jan2017 {
    public static void main(String[] args) {
        final String inputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\Ex01_Test_input.txt";

        final String outputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\Ex06_SortLines_31Jan2017.txt";

        Path pathIn = Paths.get(inputPath);
        Path pathOut = Paths.get(outputPath);


        try {
            List<String> lines = Files.readAllLines(pathIn);
            Collections.sort(lines);
            Files.write(pathOut, lines);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



    }


}


