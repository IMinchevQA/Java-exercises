import java.util.*;
import java.util.TreeMap;

public class Ex05_AcademyGraduation_26Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        TreeMap<String, Double> graduationList = new TreeMap<String, Double>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String[] scores = sc.nextLine().split("\\s+");
            double sumScore = 0;
            for (String score : scores) {
                sumScore += Double.parseDouble(score);
            }
            graduationList.put(name, (sumScore / scores.length));
        }

        for (String key : graduationList.keySet()) {
            System.out.println(key + " is graduated with " +  graduationList.get(key));
        }
    }
}

//Input1 -
//3
//Gosho
//3.75 5
//Mara
//4.25 6
//Pesho
//6 4.5

//Expected output:
// Gosho is graduated with 4.375
//Mara is graduated with 5.125
//Pesho is graduated with 5.25



//Input2 -
//5
//Gruio
//4.36 5.50 3.30 5.63 2.57 5.75 2.81 4.89
//Trendafilka
//3.10 5.35 3.30 3.35 5.64 4.99 2.75 4.68
//Mite
//3.45 3.23 3.03 5.42 5.46 4.15 2.26 5.95
//Roza
//2.08 3.48 3.36 2.73 2.96 4.54 3.70 3.85
//Ganio
//4.75 4.92 3.78 4.79 4.82 4.75 2.81 2.13

//Expected output:
//Ganio is graduated with 4.09375
//Gruio is graduated with 4.351249999999999
//Mite is graduated with 4.11875
//Roza is graduated with 3.3375
//Trendafilka is graduated with 4.145





