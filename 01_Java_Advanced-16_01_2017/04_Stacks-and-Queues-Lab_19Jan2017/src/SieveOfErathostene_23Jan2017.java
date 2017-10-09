import java.util.Locale;
import java.util.Scanner;


public class SieveOfErathostene_23Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(isPrime(n));

//Sieve of Erathostenes
//        boolean[] primes = new boolean[n + 1];
//        primes[0] = primes[1] = false;
//
//        for (int i = 2; i <= n; i++) {
//            primes[i] = true;
//        }
//
//        int sqrtN = (int) Math.sqrt(n);
//
//        for (int num = 2; num <= n; num++) {
//
//            if (primes[num]){
//                System.out.print(num + " ");
//                int p = 2 * num;
//
//                while (p <= n){
//                    primes[p] = false;
//                    p = p+ num;
//                }
//            }
//        }

    }
    private static boolean isPrime(int n) {
        int sqrtN = (int)Math.sqrt(n);
        if (n <= 1){
            return false;
        } else {
            for (int cnt = 2; cnt <= sqrtN ; cnt++) {
                if (n % cnt == 0){
                    return false;
                }
            }
        }
        return true;
    }

}
