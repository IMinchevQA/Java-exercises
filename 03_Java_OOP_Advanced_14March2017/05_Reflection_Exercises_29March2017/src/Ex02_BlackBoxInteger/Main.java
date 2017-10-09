package Ex02_BlackBoxInteger;

import java.lang.reflect.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class<?> blackBoxIntClass = BlackBoxInt.class;
//        Class<?> blackBoxIntClassForName = Class.forName("Ex02_BlackBoxInteger.BlackBoxInt");

        BlackBoxInt blackBoxIntInstance = (BlackBoxInt) blackBoxIntClass.getConstructor().newInstance();



        String line = "";

        while (!"END".equals(line = reader.readLine())) {
            String[] lineTokens = line.trim().split("_");

            String methodName = lineTokens[0];
            int operationInt = Integer.parseInt(lineTokens[1]);

            Method method = blackBoxIntClass.getDeclaredMethod(methodName, int.class);
            Method methodAdd = blackBoxIntClass.getDeclaredMethod("add", int.class);
            method.setAccessible(true);
            method.invoke(blackBoxIntInstance, operationInt);

            Field innerValueField = blackBoxIntClass.getDeclaredField("innerValue");
            innerValueField.setAccessible(true);
            System.out.println(innerValueField.get(blackBoxIntInstance));

        }
    }
}

/*
Input 1:
add_999999
subtract_19
divide_4
multiply_2
rightShift_1
leftShift_3
END

Expected output 1:
999999
999980
249995
499990
249995
1999960

 */
