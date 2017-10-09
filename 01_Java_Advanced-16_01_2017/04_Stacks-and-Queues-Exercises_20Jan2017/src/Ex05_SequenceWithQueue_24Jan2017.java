import java.util.*;

public class Ex05_SequenceWithQueue_24Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner sc = new Scanner(System.in);

        long number = Long.parseLong(sc.nextLine());

        Deque<Long> sequence = new ArrayDeque<Long>();

        sequence.add(number);

        for (int i = 0; i < 50; i++) {
            Long element = sequence.poll();
            System.out.printf("%d ", element);

            long s2 = element + 1;
            long s3 = 2 * element + 1;
            long s4 = element + 2;

            sequence.add(s2);
            sequence.add(s3);
            sequence.add(s4);
        }
    }
}

//Input
//2 or 1000 or -1



