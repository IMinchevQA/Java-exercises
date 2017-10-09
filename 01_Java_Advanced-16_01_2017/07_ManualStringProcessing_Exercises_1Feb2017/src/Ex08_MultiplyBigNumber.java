import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex08_MultiplyBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger firstNum = new BigInteger(reader.readLine());
        BigInteger secondNum = new BigInteger(reader.readLine());
        System.out.println(firstNum.multiply(secondNum));
    }
}
/*

Input 1:
23
2


Expected output 1:
46


Input2:
9999
9



Expexcted output 2:
89991



Input3:
923847238931983192462832102
4



Expected output 3
934573817465075391826664309019448

*/