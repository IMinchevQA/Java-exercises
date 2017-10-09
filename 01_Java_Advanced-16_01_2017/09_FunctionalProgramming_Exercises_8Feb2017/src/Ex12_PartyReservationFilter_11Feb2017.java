import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ex12_PartyReservationFilter_11Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));
        String input = "";
        Boolean[] visibleNames = new Boolean[names.size()];
        Arrays.fill(visibleNames,Boolean.TRUE);


        BiFunction<List<String>, Predicate<String>, List<String>> addFilterNames = (x, y) -> {
            for (int i = 0; i < x.size(); i++) {
                if (y.test(x.get(i))) {
                    visibleNames[i] = false;
                }
            }
            return x;
        };

        BiFunction<List<String>, Predicate<String>, List<String>> remFilterNames = (x, y) -> {
            for (int i = 0; i < x.size(); i++) {
                if(y.test(x.get(i))) {
                    visibleNames[i] = true;
                }
            }
            return x;
        };

        while (!"Print".equals(input = reader.readLine())) {
            String[] command = input.split(";");
            switch(command[0]) {
                case "Add filter" :
                    addFilterNames.apply(names, getPredicate(command));
                    break;
                case "Remove filter" :
                    remFilterNames.apply(names, getPredicate(command));
                    break;
            }
        }

        Consumer<List<String>> print = x -> {
            List<String> namesForPrint = new ArrayList<>();
            for (int iPrint = 0; iPrint < x.size(); iPrint++) {
                if(visibleNames[iPrint]) {
                    namesForPrint.add(names.get(iPrint));
                }
            }
            System.out.println(String.join(" ", namesForPrint).trim());
        };
        print.accept(names);
    }

    private static Predicate<String> getPredicate(String[] command) {
        switch(command[1]) {
            case "Starts with" :
                return x -> x.startsWith(command[2]);
            case "Ends with" :
                return x -> x.endsWith(command[2]);
            case "Length" :
                return x -> x.length() == Integer.parseInt(command[2]);
            case "Contains" :
                return x -> x.contains(command[2]);
            default: return null;
        }
    }
}

/*
Input 1:
Pesho Misho Slav
Add filter;Starts with;P
Add filter;Starts with;M
Print

Output 1:
Slav


Input 2:
Pesho Misho Jica
Add filter;Starts with;P
Add filter;Starts with;M
Remove filter;Starts with;M
Print

Output 2:
Misho Jica



Input 3:
Pesho Misho Jica
Add filter;Starts with;P
Add filter;Starts with;M
Remove filter;Starts with;M
Add filter;Contains;Mi
Remove filter;Contains;Pe
Print

Output 3:
Pesho Jica
 */

