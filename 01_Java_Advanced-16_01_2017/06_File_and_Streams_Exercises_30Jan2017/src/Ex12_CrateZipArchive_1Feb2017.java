import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
//Ex12_Zip\input

public class Ex12_CrateZipArchive_1Feb2017 {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/";
    private static final String TEXT_FILES_DIR = PROJECT_PATH + "Ex12_Zip/input";
    private static final String ZIP_FILE_PATH = PROJECT_PATH + "Ex12_Zip/output/Ex12_ZipFile.zip";



    public static void main(String[] args) {

        try(FileOutputStream fos = new FileOutputStream(ZIP_FILE_PATH);
            ZipOutputStream zos = new ZipOutputStream(fos)) {

            byte[] buffer = new byte[1024];

            File directory = new File(TEXT_FILES_DIR);
            File[] files = directory.listFiles();

            for (File file : files) {
                System.out.println("Adding file: " + file.getName());

                FileInputStream fis = new FileInputStream(file);
                zos.putNextEntry(new ZipEntry(file.getName()));

                int length = fis.read(buffer);

                while (length > 0) {
                    zos.write(buffer, 0, length);
                    length = fis.read();
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
