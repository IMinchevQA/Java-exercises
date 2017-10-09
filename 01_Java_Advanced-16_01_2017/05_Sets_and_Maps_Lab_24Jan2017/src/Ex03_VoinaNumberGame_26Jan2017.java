import java.util.*;

public class Ex03_VoinaNumberGame_26Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner sc = new Scanner(System.in);
        
        LinkedHashSet<Integer> firstPlayer = getPlayerNumberS(sc);
        LinkedHashSet<Integer> secondPlayer = getPlayerNumberS(sc);
        for (int i = 0; i < 50; i++) {
            if(firstPlayer.isEmpty() || secondPlayer.isEmpty()){
                break;
            }

            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);

            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            //Alternative way to take first second secondPlayers numbers.
            //Iterator<Integer> it = firstPlayer.iterator();
            //int firstNumber = it.next();

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if(firstPlayer.size() < secondPlayer.size()) {
            System.out.println("Second player win!");
        }
    }

    public static LinkedHashSet<Integer> getPlayerNumberS(Scanner sc) {
        LinkedHashSet<Integer> playerNumbers = new LinkedHashSet<>();
        String input = sc.nextLine();
        int[] inputNumbers = Arrays.stream(input.substring(0, input.length()).split("\\s+")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        for (int number : inputNumbers) {
            playerNumbers.add(number);
        }
        return playerNumbers;
    }
}
//Input
//26 58 16 92 44 65 65 77 57 23 71 57 7 52 85 44 32 70 38 23
//43 95 33 51 62 93 57 55 0 31 32 95 68 34 30 51 37 32 11 97
//Expected output - Second player win!

//Input
//74 78 82 42 19 39 29 69 20 42 31 77 57 36 76 26 4 9 83 42
//15 43 80 71 22 88 78 35 28 30 46 41 76 51 76 18 14 52 47 38
//Expected output - First player win!