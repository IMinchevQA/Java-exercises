import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Locale.setDefault(Locale.ROOT);
        TreeSet<String> set1 = new TreeSet<>(Arrays.asList("1", "2", "3"));
        TreeSet<String> set2 = new TreeSet<>(Arrays.asList("4", "5", "6"));
        HashMap<String, Integer> vehicles = new HashMap<>();
        vehicles.put("BMW", 5);
        vehicles.put("Mercedes", 3);
        vehicles.put("Audi", 4);
        vehicles.put("BMW", 10);

//        System.out.println(vehicles.get("BMW"));

        for (Integer integer : vehicles.values()) {
            System.out.println(integer);
        }


    }
}
