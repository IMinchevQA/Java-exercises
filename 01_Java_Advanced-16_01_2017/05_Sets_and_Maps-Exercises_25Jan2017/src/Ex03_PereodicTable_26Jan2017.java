import java.util.*;

public class Ex03_PereodicTable_26Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        TreeSet<String> uniqueCompounds = new TreeSet<String>();

        for (int i = 0; i < n; i++) {
            String[] compounds = sc.nextLine().split("\\s+");
            for (String compound : compounds) {
                uniqueCompounds.add(compound);
            }
        }

        for (String uniqueCompound : uniqueCompounds) {
            System.out.print(uniqueCompound + " ");
        }
    }
}

//Input1
//4
//Ce O
//Mo O Ce
//Ee
//Mo
//Expected output - Ce Ee Mo O

//Input2
//3
//Ge Ch O Ne
//Nb Mo Tc
//O Ne
//Expected output - Ch Ge Mo Nb Ne O Tc
