import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintWriter;

public class Ex04_ExtractInteger_30Jan2017 {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\Ex01_Test_input.txt";

        String outputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\Ex04_ExtractInteger_31Jan2017.txt";


        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
        PrintWriter writer = new PrintWriter(outputPath)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
