import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ex07_SumBigNumbers_2Feb2017 {
    public static void main(String[] args) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))){
            StringBuilder firstNumber = checkForLeadingZeros(input.readLine());
            StringBuilder secondNumber = checkForLeadingZeros(input.readLine());
            int maxLength = Math.max(firstNumber.length(), secondNumber.length());

            StringBuilder resultNumber = new StringBuilder();
            int lengthDiff = Math.abs(firstNumber.length() - secondNumber.length());

            if (firstNumber.length() > secondNumber.length()) {
                for (int i = 0; i < lengthDiff; i++) {
                    secondNumber.insert(0, 0);
                }
            } else if (secondNumber.length() > firstNumber.length()) {
                for (int i = 0; i < lengthDiff; i++) {
                    firstNumber.insert(0, 0);
                }
            }

            int addition = 0;

            for (int i = maxLength - 1; i >= 0; i--) {
                int num1 = Integer.parseInt(String.valueOf(firstNumber.charAt(i)));
                int num2 = Integer.parseInt(String.valueOf(secondNumber.charAt(i)));
                int sumNum1Num2 = num1 + num2;
                if (addition != 0) {
                    int numberToAppend = sumNum1Num2 + 1;
                    if(numberToAppend < 10) {
                        resultNumber.append(String.valueOf(numberToAppend));
                        addition = 0;
                        continue;
                    } else {
                        resultNumber.append(String.valueOf(numberToAppend).charAt(1));
                        continue;
                    }
                }
                if(sumNum1Num2 > 9) {
                    addition = 1;
                    resultNumber.append(String.valueOf(sumNum1Num2).charAt(1));
                } else {
                    resultNumber.append(String.valueOf(sumNum1Num2));
                }
            }
            if (addition == 1) {
                resultNumber.append(1);
            }
            System.out.println(resultNumber.reverse());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder checkForLeadingZeros(String number) {
        StringBuilder num = new StringBuilder(number);
        int cnt = 0;
        try {
            while ('0' == (num.charAt(cnt))) {
                num.delete(cnt, cnt + 1);
            }
        } catch(Exception e) {
            num = new StringBuilder("0");
        }

        return num;
    }
}

/*
CRITICAL INPUT:
000005
000005

Expected output:
10

Input 1:
23
23


Expected output 1:
46


Input2:
9999
1


Expexcted output 2:
10000



Input3:
923847238931983192462832102
934572893617836459843471846187346


Expected output 3
934573817465075391826664309019448

 */
