package Ex07_FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static HashMap<String, Buyer> entities = new HashMap<>();

    public static void main(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        executeReadInputData(reader, n);

        String line = "";

        while (!"End".equals(line = reader.readLine())) {
            String name = line;

            if (entities.containsKey(name)) {
                entities.get(name).buyFood();
            }
        }
        System.out.println(entities.values().stream().mapToInt(e -> e.getFood()).sum());

    }


    private static void executeReadInputData(BufferedReader reader, int n) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] entityTokens = reader.readLine().trim().split("\\s+");
            if (entityTokens.length == 4) {
                Buyer citizen = new Citizen(entityTokens[0], entityTokens[1], entityTokens[2], entityTokens[3]);
                entities.put(entityTokens[0], citizen);
            }

            if (entityTokens.length == 3) {
                Buyer rebel = new Rebel(entityTokens[0], entityTokens[1], entityTokens[2]);
                entities.put(entityTokens[0], rebel);
            }
        }
    }
}



/*
Input 1:
2
Pesho 25 8904041303 04/04/1989
Stancho 27 WildMonkeys
Pesho
Gosho
Pesho
End

Expected output 1:
20


Input 2:
4
Stamat 23 TheSwarm
Toncho 44 7308185527 18/08/1973
Joro 31 Terrorists
Penka 27 881222212 22/12/1988
Jiraf
Joro
Jiraf
Joro
Stamat
Penka
End

Expected output 2:
25

 */
