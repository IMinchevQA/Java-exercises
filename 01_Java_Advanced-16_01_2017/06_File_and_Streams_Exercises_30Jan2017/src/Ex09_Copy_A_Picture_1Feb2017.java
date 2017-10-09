import java.io.*;

public class Ex09_Copy_A_Picture_1Feb2017 {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/";
    private static final String COPY_PATH = PROJECT_PATH + "Ex09_PNG_CopyFolder/02_MoveEven__.png";
    private static final String PASTE_PATH = PROJECT_PATH + "Ex09_PNG_PasteFolder/02_MoveEven-Copy2__.png";

    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream(COPY_PATH);
             OutputStream fos = new FileOutputStream(PASTE_PATH)) {
            int readBytes;
            byte[] buffer = new byte[1024];

            //Length contains the end buffer copy index.
            //Why? If buffer has 1024 free indexes but only e.g 512 elements must be copied.
            int length = fis.read(buffer);

            while (length > 0) {
                fos.write(buffer, 0, length);
                length = fis.read(buffer);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

 