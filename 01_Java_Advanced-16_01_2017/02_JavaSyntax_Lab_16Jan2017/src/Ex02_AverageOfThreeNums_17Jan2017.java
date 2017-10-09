import java.util.Scanner;

public class Ex02_AverageOfThreeNums_17Jan2017 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        for(int i = 0; i < 3; i++){
            double temp = scanner.nextDouble();
            sum += temp;
        }

        System.out.printf("%.2f",(sum / 3));
    }
}
