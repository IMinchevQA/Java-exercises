import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Ex12_VehiclePark_19Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);

        String[] inputInfo = input.nextLine().split("\\s");
        ArrayList<String> vehiclesOnStock = new ArrayList<String>();

        for (String car : inputInfo){
            vehiclesOnStock.add(car);
        }

        String currentInputStr = input.nextLine();

        int vehiclesSold = 0;

        while (!currentInputStr.equals("End of customers!")){
            String[] order = currentInputStr.split(" ");
            String vehicleType = order[0].toLowerCase().substring(0,1);
            String numberofSeats = order[2];
            String vehicleOrdered = vehicleType + numberofSeats;

            //If no such a car available then index = -1;
            int index = -1;

            for (int i = 0; i < vehiclesOnStock.size(); i++){
                if (vehicleOrdered.equals(vehiclesOnStock.get(i))){
                    index = i;
                    break;
                }
            }

            if (index == - 1){
                System.out.println("No");
            } else {
                int price = vehicleOrdered.charAt(0) * Integer.parseInt(vehicleOrdered.substring(1));
                vehiclesOnStock.remove(index);
                System.out.printf("Yes, sold for %d$\n", price);
                vehiclesSold++;
            }
            currentInputStr = input.nextLine();
        }

        System.out.printf("Vehicles left: %s\n", String.join(", ", vehiclesOnStock));
        System.out.printf("Vehicles sold: %d", vehiclesSold);
    }
}

//input - c2 c4 v10 v20 b50
//Car with 4 seats
//        Bus with 20 seats
//        Bus with 33 seats
//        Van with 20 seats
//        Bus with 50 seats
//        End of customers!

