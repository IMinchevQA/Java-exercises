import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Ex03_Responsive_UI_16Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("n = ");
        int to = Integer.parseInt(reader.readLine());

        Runnable task = () -> printPrimes(to);
        Thread thread = new Thread(task);
        thread.start();

        while (true) {
            String command = reader.readLine();

            if (command.equals("stop")) {
                thread.interrupt();
                break;
            } else {
                System.out.println("unknown command");
            }
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static void printPrimes(int to) {
        List<Integer> primes = new ArrayList<>();

        for (int number = 0; number < to; number++) {

            if (isPrime(number)) {
                primes.add(number);
            }

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted...");
                break;
            }
        }

            System.out.println(primes.stream()
                    .limit(10)
                    .collect(Collectors.toList()) + "...");

            System.out.printf("%s primes calculated.", primes.size());



    }


    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}


/*
Input 1:
13

Expected output 1:
[2, 3, 5, 7, 11]...
5 primes calculated.


Input 2:
9999999
stop


Expected output 2:
[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]...
169922 primes calculated.



 */