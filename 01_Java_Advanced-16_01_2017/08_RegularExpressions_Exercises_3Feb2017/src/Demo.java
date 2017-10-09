/**
 * Created by Ivan Minchev on 2/3/2017.
 */
public class Demo {
    public static void main(String[] args) {
        String[] oneDimArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        int[][] numMatrix = new int[3][3];

        for (int row = 0; row < numMatrix.length; row++) {
            for (int col = 0; col < numMatrix.length; col++) {
                numMatrix[row][col] = Integer.parseInt(oneDimArr[col + row * numMatrix.length]);
            }
        }
    }

}
