import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Ex05_Queue_Hot_Potato_23Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        int cnt = 0;

        ArrayDeque<String> childrenQueue = new ArrayDeque<String>();

        Collections.addAll(childrenQueue, children);

        while (childrenQueue.size() > 1){
            for (int i = 1; i < n; i++) {
                String childTakenOut = childrenQueue.poll();
                childrenQueue.offer(childTakenOut);
            }

            System.out.println("Removed " + childrenQueue.poll());
        }
        System.out.println("Last is " + childrenQueue.poll());
    }
}



//Input

//Mimi Pepi Toshko
//2

//Gosho Pesho Misho Stefan Krasi
//10

//Gosho Pesho Misho Stefan Krasi
//1



