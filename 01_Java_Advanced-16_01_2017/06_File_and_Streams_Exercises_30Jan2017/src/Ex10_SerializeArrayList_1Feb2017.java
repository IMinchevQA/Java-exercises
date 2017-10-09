import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

/**
 * Created by Ivan Minchev on 2/1/2017.
 */
public class Ex10_SerializeArrayList_1Feb2017 {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/";
    private static final String OUTPUT_FILE_PATH = PROJECT_PATH + "Ex10_SerializedList.ser";

    public static void main(String[] args) {

        ArrayList<Double> doubles = new ArrayList<>(Arrays.asList(2.7, 3.2, 1.6, 4.2));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(OUTPUT_FILE_PATH))){
            oos.writeObject(doubles);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(OUTPUT_FILE_PATH))) {
            ArrayList<Double> loadDoubles = (ArrayList<Double>)ois.readObject();

            for (Double numDouble : loadDoubles) {
                System.out.println(numDouble);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
