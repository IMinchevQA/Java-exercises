import java.io.*;

public class Extra_RubicCube_Serialization_31Jan2017 {
    public static void main(String[] args) {

        final String objectDestinationPath = "C:\\Users\\Ivan Minchev\\IdeaProjects\\01_Java_Advanced-16_01_2017\\06_Files_and_Streams_Lab_30Jan2017\\src\\Extra_RubicCube_Serialization.ser";

        Cube cube = new Cube();
        cube.color = "green";
        cube.depth = 13;
        cube.width = 14;
        cube.height = 5;

        //Exporting object into a file.
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectDestinationPath))){
            oos.writeObject(cube);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Loading object from a file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectDestinationPath))) {
            Cube loadedCube = (Cube) ois.readObject();
            System.out.println(loadedCube.color);
            System.out.println(loadedCube.depth);
            System.out.println(loadedCube.width);
            System.out.println(loadedCube.height);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

