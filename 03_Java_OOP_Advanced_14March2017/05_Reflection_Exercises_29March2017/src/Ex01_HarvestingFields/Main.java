package Ex01_HarvestingFields;

//package pr01HarvestingFields; //This package is required by SoftUni JUDGE

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationError, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class richSoilLandClass = RichSoilLand.class;


        //Ex.1:
        String line = "";
        while (!"HARVEST".equals(line = reader.readLine())) {
            Field[] allFields = richSoilLandClass.getDeclaredFields();
            String modifierToPrint = line;

            Stream.of(allFields).filter(f -> Modifier.toString(f.getModifiers()).equals(modifierToPrint) || modifierToPrint.equals("all"))
                    .forEach(f -> System.out.printf("%s %s %s%n",
                            Modifier.toString(f.getModifiers()),
                            f.getType().getSimpleName(),
                            f.getName()));
        }

    }
}


/*
Ex1.:
Input 1:
protected
HARVEST

Expected output 1:
protected String testString
protected double aDouble
protected byte testByte
protected StringBuilder aBuffer
protected BigInteger testBigNumber
protected float testFloat
protected Object testPredicate
protected Object fatherMotherObject
protected String moarString
protected Exception inheritableException
protected Stream moarStreamz

Input 2:
private
public
private
HARVEST

Expected output 2:
private int testInt
private long testLong
private Calendar aCalendar
private char testChar
private BigInteger testBigInt
private Thread aThread
private Object aPredicate
private Object hiddenObject
private String anotherString
private Exception internalException
private Stream secretStream
public double testDouble
public String aString
public StringBuilder aBuilder
public short testShort
public byte aByte
public float aFloat
public Thread testThread
public Object anObject
public int anotherIntBitesTheDust
public Exception justException
public Stream aStream
private int testInt
private long testLong
private Calendar aCalendar
private char testChar
private BigInteger testBigInt
private Thread aThread
private Object aPredicate
private Object hiddenObject
private String anotherString
private Exception internalException
private Stream secretStream

input 3:
all
HARVEST

Expected output 3:
private int testInt
public double testDouble
....printing all fields doesn't matter of the access modifier.



 */