package Ex10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] namesAndAddress = reader.readLine().split("\\s+");
        String[] nameAndBeerAmount = reader.readLine().split("\\s+");
        String[] intDoubleNumbers = reader.readLine().split("\\s+");

        Tuple<String, String> tuple1 = new Tuple<String, String>();
        tuple1.put(namesAndAddress[0] + " " + namesAndAddress[1], namesAndAddress[2]);

        Tuple<String, Integer> tuple2 = new Tuple<String, Integer>();
        tuple2.put(nameAndBeerAmount[0], Integer.parseInt(nameAndBeerAmount[1]));

        Tuple<Integer, Double> tuple3 = new Tuple<Integer, Double>();
        tuple3.put(Integer.valueOf(intDoubleNumbers[0]), Double.valueOf(intDoubleNumbers[1]));


        System.out.println(tuple1);
        System.out.println(tuple2);
        System.out.println(tuple3);
    }
}

/*
Input 1:
Sofka Tripova Stolipinovo
Az 2
23 21.23212321

Output 1:
Sofka Tripova -> Stolipinovo
Az -> 2
23 -> 21.23212321

 */
