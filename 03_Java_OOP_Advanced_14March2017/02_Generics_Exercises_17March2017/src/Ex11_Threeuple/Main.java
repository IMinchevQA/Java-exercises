package Ex11_Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] namesAndAddress = reader.readLine().split("\\s+");
        String[] nameAndBeerAmount = reader.readLine().split("\\s+");
        String[] intDoubleNumbers = reader.readLine().split("\\s+");

        String key = "";
        Tuple<String, Tuple<String, String>> tuple1 = new Tuple<>();
        key = namesAndAddress[0] + " " + namesAndAddress[1];
        tuple1.put(key, new Tuple<>());
        tuple1.get(key).put(namesAndAddress[2], namesAndAddress[3]);

        Tuple<String, Tuple<Integer, Boolean>> tuple2 = new Tuple<>();
        key = nameAndBeerAmount[0];
        tuple2.put(key, new Tuple<>());
        tuple2.get(key).put(Integer.parseInt(nameAndBeerAmount[1]), nameAndBeerAmount[2].equals("drunk"));

        Tuple<String, Tuple<Double, String>> tuple3 = new Tuple<>();
        key  = intDoubleNumbers[0];
        tuple3.put(key, new Tuple<>());
        tuple3.get(key).put(Double.parseDouble(intDoubleNumbers[1]), intDoubleNumbers[2]);


        System.out.println(tuple1);
        System.out.println(tuple2);
        System.out.println(tuple3);
    }
}

/*
Input 1:
Sofka Tripova Stolipinovo Plovdiv
MitkoShtaigata 18 drunk
SashoKompota 0.10 NkqfaBanka


Output 1:
Sofka Tripova -> Stolipinovo -> Plovdiv
MitkoShtaigata -> 18 -> true
SashoKompota -> 0.1 -> NkqfaBanka



Input 2:
Ivan Ivanov Tepeto Plovdiv
Mitko 18 not
Sasho 0.10 NGB

Output 1:
Ivan Ivanov -> Tepeto -> Plovdiv
Mitko -> 18 -> false
Sasho -> 0.1 -> NGB



 */
