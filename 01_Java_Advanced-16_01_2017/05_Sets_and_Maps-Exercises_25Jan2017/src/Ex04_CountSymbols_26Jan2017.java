import java.util.*;

public class Ex04_CountSymbols_26Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner sc = new Scanner(System.in);

        char[] input = (sc.nextLine()).toCharArray();

        TreeMap<Character, Integer> charOccurrenceCounter = new TreeMap<Character, Integer>();

        for (int i = 0; i < input.length; i++) {
            int count = 1;
            if (charOccurrenceCounter.containsKey(input[i])) {
                count += charOccurrenceCounter.get(input[i]);
                charOccurrenceCounter.put(input[i], count);
            } else {
                charOccurrenceCounter.put(input[i], count);
            }
        }

        for (Character character : charOccurrenceCounter.keySet()) {
            System.out.println(character + ":" + " " + charOccurrenceCounter.get(character) + " " + "time/s");
        }
    }
}

/*
input1 - SoftUni rocks
Expected output:
 : 1 time/s
S: 1 time/s
U: 1 time/s
c: 1 time/s
f: 1 time/s
i: 1 time/s
k: 1 time/s
n: 1 time/s
o: 2 time/s
r: 1 time/s
s: 1 time/s
t: 1 time/s

input2 - Did you know Math.Round rounds to the nearest even integer?
 : 9 time/s
.: 1 time/s
?: 1 time/s
D: 1 time/s
M: 1 time/s
R: 1 time/s
a: 2 time/s
d: 3 time/s
e: 7 time/s
g: 1 time/s
h: 2 time/s
i: 2 time/s
k: 1 time/s
n: 6 time/s
o: 5 time/s
r: 3 time/s
s: 2 time/s
t: 5 time/s
u: 3 time/s
v: 1 time/s
w: 1 time/s
y: 1 time/s
*/



