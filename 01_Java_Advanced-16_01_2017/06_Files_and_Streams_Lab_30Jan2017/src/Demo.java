import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) {
        //Deserialization
        String path = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\input.txt";

        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<String> names = (List<String>) ois.readObject(); //Explicit casting of object
            // (List<String>) is necessary because once saved as a file the compiler cannot turns the object into a List implicitly.


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


//        //Srialization
//                String path = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\input.txt";
//        List<String> names = new ArrayList<>();
//        Collections.addAll(names, "Mimi", "Gosho");
//
//        try {
//            FileOutputStream fos = new FileOutputStream(path);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(names);
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        } catch (IOException e) {
//              System.out.println(e.getMessage());
//        }


//        String path = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\input.txt";
//        try (FileInputStream fileStream = new FileInputStream(path)) {
//            //Wrong place for - FileInputStream fileStream = new  FileInputStream(path);
//
//            int oneByte = fileStream.read();
//
//            while (oneByte >= 0) {
//                System.out.println(oneByte);
//                oneByte = fileStream.read();
//            }
//            //Wrong place for - fileStream.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }


    }
}
