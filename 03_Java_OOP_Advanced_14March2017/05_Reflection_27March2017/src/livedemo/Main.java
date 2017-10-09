import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        //Reflection
        Class person = livedemo.Person.class;
        Class parrent = person.getSuperclass();
//        Class person1 = Class.forName("livedemo.Person");

        Field[] allPublicFields = person.getFields();
        Field[] allFieldsFromPersonClass = person.getDeclaredFields();
        Field[] allFieldsFromParrentClass = parrent.getDeclaredFields();

        System.out.println(parrent.getName());

        String debug = "";

    }
}
