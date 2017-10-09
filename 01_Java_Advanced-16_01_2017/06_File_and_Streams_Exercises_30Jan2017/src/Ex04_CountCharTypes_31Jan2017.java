import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

public class Ex04_CountCharTypes_31Jan2017 {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_File_and_Streams_Exercises_30Jan2017\\src\\Ex04_Test_input_1.txt";
        String outputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_File_and_Streams_Exercises_30Jan2017\\src\\Ex04_Output_30Jan2017.txt";

        Path pathIn = Paths.get(inputPath);
        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        List<Character> punctuation = new ArrayList<>(Arrays.asList('!', '.', ',', '?', 'u'));
        long vowelsCnt = 0;
        long consonantsCnt = 0;
        long punctuationCnt = 0;


        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            List<String> allLines = Files.readAllLines(pathIn);
            for (String line : allLines) {
                for (char ch : line.toCharArray()) {
                    if (Character.isLetter(ch)) {
                        if (vowels.contains(ch)) {
                            fos.write(ch);
                            vowelsCnt++;
                        } else {
                            fos.write(ch);
                            consonantsCnt++;
                        }
                    } else if (punctuation.contains(ch)) {
                        fos.write(ch);
                        punctuationCnt++;
                    }
                }
            }
            System.out.printf("Vowels: %s\nConsonants: %s\nPunctuation: %s\n", vowelsCnt, consonantsCnt, punctuationCnt);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
