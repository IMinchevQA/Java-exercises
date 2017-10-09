import java.io.*;
import java.io.IOException;
import java.util.*;

public class Ex06_WordCount_31Jan2017 {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/";
    private static final String TARGET_WORDS_FILE_PATH = PROJECT_PATH + "Ex06_targetWords.txt";
    private static final String TEXT_SCANNED_FILE_PATH = PROJECT_PATH + "Ex06_textScanned.txt";
    private static final String OUTPUT_FILE_PATH = PROJECT_PATH + "Ex06_Output.txt";
    public static void main(String[] args) {
        File targetWordsFile = new File(TARGET_WORDS_FILE_PATH);
        File textScannedFile = new File(TEXT_SCANNED_FILE_PATH);

        //Contains <words.toLowerCase(), count>
        HashMap<String, Integer> targetWordsCount = new HashMap<>();

        //Contains <words.toLowerCase(), words(non-case modified))
        HashMap<String, String> targetWordsOriginal = new HashMap<>();

        try (BufferedReader targetWordsReader = new BufferedReader(new FileReader(targetWordsFile));
             BufferedReader textReader = new BufferedReader(new FileReader(textScannedFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            //Filling up targetWordsCount
            String line = "";
            while ((line = targetWordsReader.readLine()) != null) {
                String[] targetWords = line.split("\\s+");
                for (String word : targetWords) {
                    String targetWordKey = word.toLowerCase();
                    if (!targetWordsCount.containsKey(targetWordKey)) {
                        targetWordsCount.put(targetWordKey, 0);
                        targetWordsOriginal.put(targetWordKey, word);
                    }
                }
            }

            while ((line = textReader.readLine()) != null) {
                String[] wordsTextScanned = line.split("\\s+");
                for (String word : wordsTextScanned) {
                    String scanWordKey = word.toLowerCase();
                    if(targetWordsCount.containsKey(scanWordKey)) {
                        int count = targetWordsCount.get(scanWordKey) + 1;
                        targetWordsCount.put(scanWordKey, count);
                    }
                }
            }

            targetWordsCount.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(pair -> {
                        try {
                            writer.write(String.format("%s - %d", targetWordsOriginal.get(pair.getKey()), pair.getValue()));
                            writer.newLine();
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    });
//            targetWordsCount.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                    .forEachOrdered(x -> System.out.printf("%s - %s\n", targetWordsOriginal.get(x.getKey()), x.getValue()));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
