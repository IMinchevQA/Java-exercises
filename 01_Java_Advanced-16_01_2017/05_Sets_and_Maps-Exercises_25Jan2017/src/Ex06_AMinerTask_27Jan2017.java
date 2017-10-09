import java.util.*;

public class Ex06_AMinerTask_27Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);

        String resource = sc.nextLine();
        LinkedHashMap<String, Integer> allResources = new LinkedHashMap<String, Integer>();

        while (true) {
            if(resource.isEmpty() || "stop".equals(resource)){
                break;
            }
            int quantityResource = Integer.parseInt(sc.nextLine());
            if (!allResources.containsKey(resource)){
                allResources.put(resource, quantityResource);
            } else {
                int availableQuantityResource = allResources.get(resource);
                allResources.put(resource, availableQuantityResource + quantityResource);
            }

            resource = sc.nextLine();
        }

        for (String s : allResources.keySet()) {
            System.out.printf("%1$s -> %2$s", s, allResources.get(s));
            System.out.println();
        }
    }
}

/*
Input
Gold
155
Silver
10
Copper
17
stop

Expected output
Gold -> 155
Silver -> 10
Copper -> 17

Input:
Gold
15555555
Silver
10000000
Copper
17000000
Copper
1700
stop

Expected output
Gold -> 15555555
Silver -> 10000000
Copper -> 17001700

 */
