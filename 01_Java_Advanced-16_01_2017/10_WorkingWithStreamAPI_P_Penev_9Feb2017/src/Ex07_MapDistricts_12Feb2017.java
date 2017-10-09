import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ex07_MapDistricts_12Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, List<Integer>> cities = new HashMap<>();

        String[] tokens = reader.readLine().split("\\s+");
        int limit = Integer.parseInt(reader.readLine());

        for (String token : tokens) {
            String[] cityArgs = token.split(":");
            String cityName = cityArgs[0];
            int districtPopulation = Integer.parseInt(cityArgs[1]);
            cities.putIfAbsent(cityName, new ArrayList<>());
            cities.get(cityName).add(districtPopulation);
        }

        cities.entrySet().stream()
                .filter(c -> c.getValue()
                        .stream()
                        .mapToInt(p -> Integer.valueOf(p))
                        .sum() > limit)
                .sorted((e1, e2) -> Integer.compare(
                        e2.getValue().stream()
                        .mapToInt(s1 -> Integer.valueOf(s1)).sum(),
                        e1.getValue().stream()
                        .mapToInt(s2 -> Integer.valueOf(s2)).sum()))
                .forEach(e -> {
                    System.out.printf("%s: ", e.getKey());
                    e.getValue().stream()
                            .sorted((n1, n2) -> Integer.compare(n2, n1))
                            .limit(5)
                            .forEach(d -> System.out.print(d + " "));
                    System.out.println();
                });
    }
}

/*
Input 1:
Pld:9 Pld:13 Has:7 Sof:20 Sof:10 Sof:15
10


Output 1:
Sof: 20 15 10
Pld: 13 9


Input 2:
Sof:10 Sof:12 Sof:15
10

Output 2:
Sof: 15 12 10



Input 3:
Sof:5
15

Output 3:
(no output)

 */