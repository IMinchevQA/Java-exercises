import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.UnaryOperator;

public class Ex04_Add_VAT_10Feb2017 {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ROOT);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(", ");
        List<Double> numbers = new ArrayList<>();

        for (String s : input) {
            numbers.add(Double.parseDouble(s));
        }

        UnaryOperator<Double> addVat = x -> x * 1.2;
        System.out.println("Prices with VAT:");
        for (Double number : numbers) {
            System.out.println(String.format("%1$.2f", addVat.apply(number)).replace('.', ','));
        }
    }
}


/*
Input 1:
1.38, 2.56, 4.4

Expected output 1:
Prices with VAT:
1,66
3,07
5,28




Input 2:
1, 3, 5, 7

Expected output 2:
Prices with VAT:
1,20
3,60
6,00
8,40


*/