import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Ex11_SerializeCustomObject_1Feb2017 {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/";
    private static final String OUTPUT_FILE_PATH = PROJECT_PATH + "Ex11_SerializedObjCourse.ser";
    public static void main(String[] args) {

        Course courseObj = new Course();
        courseObj.name = "Petkan";
        courseObj.numberOfStudents = 13;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(OUTPUT_FILE_PATH))){
            oos.writeObject(courseObj);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(OUTPUT_FILE_PATH))) {
            Course courseActive = (Course) ois.readObject();
            System.out.println("Student name: " + courseActive.name);
            System.out.println("Number of students: " + courseActive.numberOfStudents);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
