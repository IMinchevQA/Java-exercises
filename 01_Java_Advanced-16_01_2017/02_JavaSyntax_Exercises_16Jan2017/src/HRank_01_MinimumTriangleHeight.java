import java.util.Scanner;

/**
 * Created by Ivan Minchev on 9/12/2017.
 */
public class HRank_01_MinimumTriangleHeight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int base = in.nextInt();
        int area = in.nextInt();
        int height = lowestTriangle(base, area);
        System.out.println(height);
    }

    static int lowestTriangle(int base, int area){
        // Complete this function
        return (int)Math.ceil((2 * area) / (double)base);
    }
}
