import java.util.*;

public class Ex10_PopulationCounter_27Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, HashMap<String, Long>> populationInfo = new LinkedHashMap<>();

        String input = sc.nextLine();

        while (true) {
            if(input.isEmpty() || "report".equals(input)){
                break;
            }

            String[] lineData = input.split("\\|");
            String city = lineData[0];
            String country = lineData[1];
            long population = Long.parseLong(lineData[2]);

            if(!populationInfo.containsKey(country)){
                populationInfo.put(country, new HashMap<>());
            }

            if(!populationInfo.get(country).containsKey(city)){
                populationInfo.get(country).put(city, population);
            }

            input = sc.nextLine();
        }

        LinkedHashMap<String, Long> countriesPopulationUnsorted = new LinkedHashMap<>();
        for (String country : populationInfo.keySet()){
            long totalPopulation = 0;
            for(String city : populationInfo.get(country).keySet()){
                totalPopulation += populationInfo.get(country).get(city);
            }
            countriesPopulationUnsorted.put(country, totalPopulation);
        }

        LinkedHashMap<String, Long> countriesPopulationSorted = new LinkedHashMap<>();

        countriesPopulationUnsorted.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(x -> countriesPopulationSorted.put(x.getKey(), x.getValue()));

        for (String country : countriesPopulationSorted.keySet()){
            System.out.println(country + " (total population: " + countriesPopulationSorted.get(country) + ")");
            LinkedHashMap<String, Long>cities = new LinkedHashMap<>();

            populationInfo.get(country).entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .forEachOrdered(x -> cities.put(x.getKey(), x.getValue()));

            for (String city : cities.keySet()) {
                System.out.println("=>" + city + ": " + cities.get(city));
            }
        }
    }
}

/*
Input
Sofia|Bulgaria|1
Veliko Tarnovo|Bulgaria|2
London|UK|4
Rome|Italy|3
report

Expected output
UK (total population: 4)
=>London: 4
Bulgaria (total population: 3)
=>Veliko Tarnovo: 2
=>Sofia: 1
Italy (total population: 3)
=>Rome: 3

 */
