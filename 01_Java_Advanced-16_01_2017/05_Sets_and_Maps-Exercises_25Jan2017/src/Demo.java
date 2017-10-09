import java.util.*;

public class Demo {
    public static void main(String[] args) {
//        String[] domains = {".uk", ".us", ".com"};
//
//        LinkedHashMap<String, Integer> countriesUnsorted = new LinkedHashMap<>();
//        countriesUnsorted.put("Sofia", 3);
//        countriesUnsorted.put("UK", 2);
//        countriesUnsorted.put("Italy", 4);
//
//        LinkedHashMap<String, Integer> countriesSortedByKeyAsc = new LinkedHashMap<>();
//        countriesUnsorted.entrySet().stream()
//                .sorted(Map.Entry.<String, Integer>comparingByKey())
//                .forEachOrdered(x -> countriesSortedByKeyAsc.put(x.getKey(), x.getValue()));
//
//        LinkedHashMap<String, Integer> countriesSortedByKeyDesc = new LinkedHashMap<>();
//        countriesUnsorted.entrySet().stream()
//                .sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
//                .forEachOrdered(x -> countriesSortedByKeyDesc.put(x.getKey(), x.getValue()));
//
//
//        LinkedHashMap<String, Integer> countriesSortedByValueAsc = new LinkedHashMap<>();
//        countriesUnsorted.entrySet().stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue())
//                .forEachOrdered(x -> countriesSortedByValueAsc.put(x.getKey(), x.getValue()));
//
//        LinkedHashMap<String, Integer> countriesSortedByValueByKeys = new LinkedHashMap<>();
//        countriesUnsorted.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey()
//                .thenComparing(Map.Entry.<String, Integer>comparingByValue()))
//                .forEachOrdered(x -> countriesSortedByValueByKeys.put(x.getKey(), x.getValue()));
//
//
//        for (String country : countriesSortedByValueByKeys.keySet()) {
//            System.out.println(country + " -> " + countriesSortedByKeyDesc.get(country));
//        }
        String str = "a d, m, i.n";
        String delimiters = "\\s+|,\\s*|\\.\\s*";

        // analyzing the string
        String[] tokensVal = str.split(delimiters);
        for (String s : tokensVal) {
            System.out.println(s);
        }


    }
}
