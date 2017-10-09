package Training;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static CustomArray<?> test;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {

            //Some if-else logic could be implemented here!!!

            CustomArray<String> a = new CustomArrayImpl<>();
            test = a;
        }

        System.out.println(test.getFirstElement());
    }
}

//        Second Example
//        String input = reader.readLine();
//        try {
//            CustomArray<Integer> arr = new CustomArrayImpl<>();
//            Integer a = Integer.parseInt(input);
//            arr.addElement(a);
//            test = arr;
//        } catch (Exception e) {
//            CustomArray<String> arr = new CustomArrayImpl<>();
//            arr.addElement(input);
//            test = arr;
//        }

//        System.out.println(test.getFirstElement());



//      First Example
//        CustomArray<String> array = new CustomArrayImpl<>();
//
//        array.addElement("Pesho");
//        array.addElement("Tosho");
////        array.addElement("Stamat");
//        System.out.println(array.getFirstElement());
//        System.out.println(array.getSecondElement());
