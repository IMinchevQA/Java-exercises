import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class Ex07_PredicateForNames_11Feb2017 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int targetLength = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");

        Predicate<String> checkName = x -> x.trim().length() <= targetLength;
        Consumer<String> printNames = name -> System.out.println(name);

        for (String name : names) {
            if(checkName.test(name)) {
                printNames.accept(name);
            }
        }
    }
}


/*Input 1:
4
Kurnelia Qnaki Geo Muk Ivan


Output 1:
Geo
Muk
Ivan


Input 2:
4
Karaman Asen Kiril Yordan


Output 1:
Asen

 */
