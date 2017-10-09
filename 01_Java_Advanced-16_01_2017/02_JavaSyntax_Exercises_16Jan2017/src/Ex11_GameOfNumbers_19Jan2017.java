import java.util.Scanner;
import java.util.Locale;

public class Ex11_GameOfNumbers_19Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner input = new Scanner(System.in);
        int countPlayers = input.nextInt();
        String[] names = new String[countPlayers];
        int[] points = new int[countPlayers];

        //Filling up the arrays - names, initual points
        for (int i = 0; i < countPlayers; i++) {
            names[i] = input.next();
            points[i] = Integer.valueOf(input.next());
        }

        //Traversing through the players
        for (int iPlayer = 0; iPlayer < countPlayers; iPlayer++) {

            //Traversing through the chars of player name.
            for (int iRes = 0; iRes < names[iPlayer].length(); iRes++) {
                int valueCurrentChar = Integer.valueOf(names[iPlayer].charAt(iRes));
                if (valueCurrentChar % 2 == 0) {
                    points[iPlayer] += valueCurrentChar;
                } else {
                    points[iPlayer] -= valueCurrentChar;
                }
            }
        }

        //Finding maxPoints
        int maxPoints = points[0];
        int maxIndex = 0;
        for (int iMax = 0; iMax < points.length; iMax++) {
            if (points[iMax] > maxPoints) {
                maxPoints = points[iMax];
                maxIndex = iMax;
            }
        }
        System.out.printf("The winner is %s - %d points", names[maxIndex], points[maxIndex]);
    }
}