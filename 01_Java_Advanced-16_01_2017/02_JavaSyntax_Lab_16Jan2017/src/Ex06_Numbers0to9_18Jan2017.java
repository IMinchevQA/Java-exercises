import java.util.Locale;

public class Ex06_Numbers0to9_18Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        int number = 0;

        while(number <= 9){
            System.out.println("Number: " + number);
            number++;
        }
    }
}