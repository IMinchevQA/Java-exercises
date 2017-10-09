import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ex11_PredicatePArty_11Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
        String command = "";

        BiFunction<List<String>, Predicate<String>, List<String>> doubleNames = (x, y) -> {
            List<String> result = new ArrayList<>();
            for (String name : x) {
                if(y.test(name)) {
                    result.add(name);
                }
            }
            for (String s: result) {
                x.add(s);
            }
            return x;
        };

        while(!"Party!".equals(command = reader.readLine())) {
            String[] commands = command.split("\\s+");
            switch(commands[0]) {
                case "Double":
                    doubleNames.apply(names, getPredicate(commands));
                    break;
                case "Remove":
                    names.removeIf(getPredicate(commands));
                    break;
            }
        }
        Consumer<String> print = str -> System.out.println(str);
        if(names.isEmpty()) {
            print.accept("Nobody is going to the party!");
            return;
        }

        print.accept(String.join(", ", names) + " are going to the party!");

    }
    public static Predicate<String> getPredicate(String[] commands) {
        switch (commands[1]) {
            case "StartsWith":
                return x -> x.startsWith(commands[2]);
            case "EndsWith":
                return x -> x.endsWith(commands[2]);
            case "Length":
                return x -> x.length() == Integer.parseInt(commands[2]);
            default:
                return null;
        }
    }
}

/*
Input 1:
Pesho Misho Stefan
Remove StartsWith P
Double Length 5
Party!

Output 1:
Misho, Misho, Stefan are going to the party!



Input 2:
Pesho
Double StartsWith Pesh
Double EndsWith esho
Party!

Output 2:
Pesho, Pesho, Pesho, Pesho are going to the party!

 */
