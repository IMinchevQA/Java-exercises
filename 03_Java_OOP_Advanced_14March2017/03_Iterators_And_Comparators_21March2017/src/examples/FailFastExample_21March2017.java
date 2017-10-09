package examples;

import java.util.concurrent.ConcurrentHashMap;

public class FailFastExample_21March2017 {
    public static void main(String[] args) {
//        Map<String, String> premiumPhone = new HashMap<>();
        ConcurrentHashMap<String, String> premiumPhone = new ConcurrentHashMap<>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung", "S5");

        for (String key : premiumPhone.keySet()) {
            System.out.println(premiumPhone.get(key));
            //The following row throws ConcurrentModificationException because the collection cannot be changed during iteration.
//            premiumPhone.put("Sony", "Xperia Z");//!!! Forbidden operation
            //Such an operation could be performed when iterate onto ConcurrentHashMap

            premiumPhone.put("Sony", "Xperia Z");//!!! Forbidden operation
        }
    }
}
