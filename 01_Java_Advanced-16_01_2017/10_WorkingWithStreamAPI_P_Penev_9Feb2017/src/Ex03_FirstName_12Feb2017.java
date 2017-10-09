import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Optional;

public class Ex03_FirstName_12Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.asList(reader.readLine().split("\\s+"));

        HashSet<Character> chars = new HashSet<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .map(s -> Character.toLowerCase(s.charAt(0)))
                .forEach(chars::add);

        Optional<String> firstName = names.stream().filter(n -> chars.contains(n.toLowerCase().charAt(0)))
                .sorted()
                .findFirst();

        if (firstName.isPresent()) {
            System.out.println(firstName.get());
        } else {
            System.out.println("No match");
        }
    }
}


/*
Input 1:
Rado Plamen Gosho
p r

Output 1:
Plamen

Input 2:
Plamen Gosho Rado
s c


Output 2:
No match

 */
