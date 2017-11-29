import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Ivan Minchev on 11/21/2017.
 */
public class Ex12_ParseJsonString {
    public static void main(String[] args) {
        //        String str1 = "string";
//        String str2 = "string";
//        String str3 = new String("string");
//
//
//        System.out.println(str1 == str2);
//        System.out.println(str1 == str3);
//        System.out.println(str1 == "string");
//        System.out.println(str1 == "str" + "ing");

        String jsonPersonStr =  "{\"firstName\": \"John\", \"lastName\": \"Snow\"}";
        String jsonCarStr = "{\"make\": \"Mercedes\", \"model\": \"E-class\"}";
        Person parsedPerson = jsonParse(Person.class, jsonPersonStr);
        Car parsedCar = jsonParse(Car.class, jsonCarStr);

        System.out.println(parsedPerson);
        System.out.println(parsedCar);
        System.out.println();
    }

    public static <T> T jsonParse(Class<T> tClass, String jsonString) {
        Gson gson = new Gson();
        T parsedObj = gson.fromJson(jsonString, tClass);
        return parsedObj;
    }
}

class Car {
    private String make;
    private String model;

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("Car make - %1s, Model - %2s", this.getMake(), this.getModel());
    }
}

class Person {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("First name - %1s, Last name - %2s", this.getFirstName(), this.getFirstName());
    }
}
