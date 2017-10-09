import java.io.*;

public class Ex01_SumLines_31Jan2017 {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_File_and_Streams_Exercises_30Jan2017\\src\\Ex01_Test_input.txt";
        File file = new File(inputPath);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentLine = reader.readLine();

            while(null != currentLine) {
                long sum = 0;
                for (char ch : currentLine.toCharArray()) {
                    sum += Integer.valueOf(ch);
                }
                System.out.println(sum);

                currentLine = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
