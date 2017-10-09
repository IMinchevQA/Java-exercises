import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
        String command = "";
        BiFunction<List<String>, Predicate<String>, List<String>> doubleNames = (x, y) -> {
            List<String> result = new ArrayList<>();
            for (String name : x) {
                if (y.test(name)){
                    result.add(name);
                }
            }
            for (String s : result) {
                x.add(s);
            }
            return x;
        };

        while (!"Party!".equals(command = reader.readLine())){

            String[] commands = command.split("\\s+");
            switch (commands[0]){
                case "Double":
                    switch (commands[1]){
                        case "StartsWith":
                            doubleNames.apply(names, getPredicate(commands));
                            break;
                        case "EndsWith":
                            doubleNames.apply(names, getPredicate(commands));
                            break;
                        case "Length":
                            doubleNames.apply(names, getPredicate(commands));
                            break;
                    }
                    break;

                case "Remove":
                    switch (commands[1]){
                        case "StartsWith":
                            names.removeIf(getPredicate(commands));
                            break;
                        case "EndsWith":
                            names.removeIf(getPredicate(commands));
                            break;
                        case "Length":
                            names.removeIf(getPredicate(commands));
                            break;

                    }

                    break;
            }
        }

        //names.sort((a,b) -> a.compareTo(b));
        Consumer<String> print = str -> System.out.print(str);
        if (names.isEmpty()) {
            print.accept("Nobody is going to the party!");
            return;
        }
        print.accept(String.join(", ", names) + " are going to the party!");
    }

    private static Predicate<String> getPredicate(String[] commands) {
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
