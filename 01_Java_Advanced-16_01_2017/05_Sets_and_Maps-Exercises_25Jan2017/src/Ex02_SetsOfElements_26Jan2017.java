import java.util.*;

public class Ex02_SetsOfElements_26Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner sc = new Scanner(System.in);
        String[] sizeNM = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(sizeNM[0]);
        int m = Integer.parseInt(sizeNM[1]);

        LinkedHashSet<Integer> setN = new LinkedHashSet<>();
        LinkedHashSet<Integer> setM = new LinkedHashSet<>();
        //Adding numbers in the set N
        for (int i = 0; i < n; i++) {
            int numberN = Integer.parseInt(sc.nextLine());
            setN.add(numberN);
        }

        //Adding numbers in the set M
        for (int i = 0; i < m; i++) {
            int numberM = Integer.parseInt(sc.nextLine());
            setM.add(numberM);
        }

        //check
        for (Integer number : setN) {
            if(setM.contains(number)) {
                System.out.print(number + " ");
            }
        }
    }
}

//Input - 1
//4 3
//1
//3
//5
//7
//3
//4
//5
//Expected output - 3 5

//Input - 2
//2 2
//1
//3
//1
//5
//Expected output - 1

