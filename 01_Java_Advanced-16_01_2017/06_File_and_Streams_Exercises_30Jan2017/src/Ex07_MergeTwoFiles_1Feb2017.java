import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Created by Ivan Minchev on 2/1/2017.
 */
public class Ex07_MergeTwoFiles_1Feb2017 {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/";
    private static final String FILE1_PATH = PROJECT_PATH + "Ex07_inputFile1.txt";
    private static final String FILE2_PATH = PROJECT_PATH + "Ex07_inputFile2.txt";
    private static final String MERGED_FILE_PATH = PROJECT_PATH + "Ex07_mergedFile.txt";

    public static void main(String[] args) {
        File file1 = new File(FILE1_PATH);
        File file2 = new File(FILE2_PATH);
        File mergedFile = new File(MERGED_FILE_PATH);
        ArrayList<String> strings = new ArrayList<>();

        try(BufferedReader file1Reader = new BufferedReader(new FileReader(file1));
            BufferedReader file2Reader = new BufferedReader(new FileReader(file2));
            BufferedWriter writer = new BufferedWriter(new FileWriter(mergedFile))) {

            String line = "";
            line = file1Reader.readLine();
            while (line != null) {
                strings.add(line);
                line = file1Reader.readLine();
            }

            line = file2Reader.readLine();
            while (line != null) {
                strings.add(line);
                line = file2Reader.readLine();
            }

            for (String string : strings) {
                writer.write(String.format("%s", string));
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Printing the results!!!
        try (BufferedReader mergedFileReader = new BufferedReader(new FileReader(mergedFile))) {
            String line = mergedFileReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = mergedFileReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
