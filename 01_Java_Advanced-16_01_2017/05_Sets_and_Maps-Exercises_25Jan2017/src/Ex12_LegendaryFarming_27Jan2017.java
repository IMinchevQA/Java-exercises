import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.*;

public class Ex12_LegendaryFarming_27Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> resources = new HashMap<>();
        resources.put("shards", 0);
        resources.put("fragments", 0);
        resources.put("motes", 0);

        LinkedHashMap<String, Integer> junks = new LinkedHashMap<>();

        boolean sufficientMaterialQty = false;

        while (!sufficientMaterialQty) {
        String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            }
            String[] materialData = input.split("\\s+");
            for (int i = 0; i < materialData.length; i+= 2) {
                int quantity = Integer.parseInt(materialData[i]);
                String material = materialData[i+1].toLowerCase();

                if("shards".equals(material) || "fragments".equals(material) || "motes".equals(material)) {

                    resources.put(material, resources.get(material) + quantity);

                    if (resources.get(material) >= 250) {
                        resources.put(material, resources.get(material) - 250);
                        String result = "";
                        switch (material) {
                            case "shards":
                                result = "Shadowmourne";
                                break;
                            case "fragments":
                                result = "Valanyr";
                                break;
                            case "motes":
                                result = "Dragonwrath";
                                break;
                        }
                        System.out.printf("%1s obtained!", result);
                        System.out.println();
                        sufficientMaterialQty = true;
                        break;
                    }
                } else {
                    if(!junks.containsKey(material)) {
                        junks.put(material, 0);
                    }
                    junks.put(material, junks.get(material) + quantity);
                }
            }
        }
        LinkedHashMap<String, Integer> resourcesSortedByValue = new LinkedHashMap<>();
        resources.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.<String, Integer>comparingByKey()))
                .forEachOrdered(x -> resourcesSortedByValue.put(x.getKey(), x.getValue()));

        for (String resource : resourcesSortedByValue.keySet()) {
            System.out.printf("%1$s: %2$d", resource, resourcesSortedByValue.get(resource));
            System.out.println();
        }

        LinkedHashMap<String, Integer> junksSorted = new LinkedHashMap<>();
        junks.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey())
                .forEachOrdered(x -> junksSorted.put(x.getKey(), x.getValue()));

        for (String junk: junksSorted.keySet()){
            System.out.printf("%1$s: %2$d", junk, junksSorted.get(junk));
            System.out.println();
        }

    }
}

/*
Input1:
3 Motes 5 stones 5 Shards
6 leathers 255 fragments 7 Shards
Expected output:
Valanyr obtained!
fragments: 5
shards: 5
motes: 3
leathers: 6
stones: 5





Input2:
123 silver 6 shards 8 shards 5 motes
9 fangs 75 motes 103 MOTES 8 Shards
86 Motes 7 stones 19 silver
Expected output:
Dragonwrath obtained!
shards: 22
motes: 19
fragments: 0
fangs: 9
silver: 123


 */