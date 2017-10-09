import java.util.Locale;
import java.util.Scanner;
import java.math.BigDecimal;

public class Ex03_EuroTrip_17Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);

        Scanner input = new Scanner(System.in);

        double quantity = input.nextDouble();

        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal priceInLeva = new BigDecimal(1.20 * quantity);
        BigDecimal totalPrice = priceInLeva.multiply(exchangeRate);

        System.out.printf("%.2f marks", totalPrice);
    }
}