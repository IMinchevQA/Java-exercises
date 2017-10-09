import java.util.*;

public class Ex07_Queue_PalindromeChecke_23Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        String palindromeCandidate = scanner.nextLine();
        Deque<Character> queue = new ArrayDeque<Character>();

        for (char ch : palindromeCandidate.toCharArray()) {
            queue.offer(ch);
        }

        boolean isPalindrome = true;
        while (queue.size() > 1) {
            char first = queue.poll();
            char last = queue.pollLast();

            if(first != last){
                isPalindrome  = false;
                break;
            }

        }
        System.out.println(isPalindrome);
    }
}

//Input
//radar
//Not a palindrome
