import java.util.*;

public class Ex01_ParkingLot_26Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.CANADA.ROOT);

        Scanner sc = new Scanner(System.in);
        HashSet<String> parkingLot = new HashSet<>();

        while(true){
            String input = sc.nextLine();
            if (input.equals("END")) {
                break;
            } else {
                String[] reminder = input.split(", ");
                if (reminder[0].equals("IN")) {
                    parkingLot.add(reminder[1]);
                } else {
                    parkingLot.remove(reminder[1]);
                }
            }
        }

        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parkingLot){
                System.out.println(car);
            }
        }

    }
}

//Input1
//IN, CA2844AA
//IN, CA1234TA
//OUT, CA2844AA
//IN, CA9999TT
//IN, CA2866HI
//OUT, CA1234TA
//IN, CA2844AA
//OUT, CA2866HI
//IN, CA9876HH
//IN, CA2822UU
//END


//Input2
//IN, CA2844AA
//IN, CA1234TA
//OUT, CA2844AA
//OUT, CA1234TA
//END
