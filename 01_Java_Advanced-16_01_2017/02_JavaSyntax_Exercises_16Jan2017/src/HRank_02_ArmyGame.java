import java.util.Scanner;

/**
 * Created by Ivan Minchev on 9/12/2017.
 */
public class HRank_02_ArmyGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println((n/2 + n%2) * (m/2 + m%2));
    }
}
