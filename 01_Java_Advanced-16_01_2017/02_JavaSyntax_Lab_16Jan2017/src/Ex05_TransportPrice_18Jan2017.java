import java.util.Locale;
import java.util.Scanner;

public class Ex05_TransportPrice_18Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);

        Scanner input = new Scanner(System.in);

        //Distance in kilometers.
        double distance = input.nextDouble();
        String dayTime = input.next();
        input.close();
        double totalPrice = 0;

        if(distance < 20){
            //Travel with a Taxi.
            if(dayTime.equals("day")){
                totalPrice = 0.70 + (distance * 0.79);
            } else {
                totalPrice = 0.70 + (distance * 0.90);
            }
        } else if (distance >= 20 && distance < 100){
            //Travel with a Bus.
            totalPrice = distance * 0.09;

        } else {
            //Travel with a Train.
            totalPrice = distance * 0.06;
        }
        System.out.printf("%.2f", totalPrice);
    }
}