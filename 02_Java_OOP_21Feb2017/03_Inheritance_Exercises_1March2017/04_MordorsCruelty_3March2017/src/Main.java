import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> foods = Arrays.asList(reader.readLine().trim().split("\\s+"));

        Gandalf gandalf = new Gandalf();
        gandalf.addFoods(foods);
        gandalf.setHappiness();

        System.out.println(gandalf);


    }
}


/*
Input 1:
Cram banica Melon HonEyCake

Expected output1:
7
Happy

Input 2:
gosho pesho meze melon honeycake

Expected output 2:
3
Happy

Input 3:
HoneyCake honeyCake honeyCake HoneyCakE HoneYCake HonEyCake HoneyCake HoneyCake HoneyCake HoNeyCake

Expected output 3:
50
JavaScript

 */