import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Collections;

public class Ex06_Queue_Math_Potato_23Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> childrenQueue = new ArrayDeque<String>();

        Collections.addAll(childrenQueue, children);

        int counter = 1;
        while (childrenQueue.size() > 1){
            for (int i = 1; i < n; i++) {
                String childTakenOut = childrenQueue.poll();
                childrenQueue.offer(childTakenOut);
            }

            if(isPrime(counter)) {
                System.out.println("Prime " + childrenQueue.peek());
            } else {
                System.out.println("Removed " + childrenQueue.poll());
            }
            counter++;
        }
        System.out.println("Last is " + childrenQueue.poll());
    }

    private static boolean isPrime(int number) {

        if(number <= 1){
            return false;
        }

        int sqrtNumber = (int)Math.sqrt(number);

        for (int i = 2; i <= sqrtNumber; i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}


//Input

//Mimi Pepi Toshko
//2

//Gosho Pesho Misho Stefan Krasi
//10