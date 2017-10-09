package Ex10_MooD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputTokens = reader.readLine().trim().split("[\\s\\|]+");
        String name = inputTokens[0];
        String type = inputTokens[1];
        String specialPoints = inputTokens[2];
        String level = inputTokens[3];

        switch (type.toLowerCase()) {
            case "demon":
                GameObject<Integer> demon = new Demon<>(name, Integer.parseInt(level), Double.parseDouble(specialPoints));
                demon.setHashedPassword(demon.getUsername().length() * 217);
                System.out.println(demon);
                break;
            case "archangel":
                GameObject<String> archangel = new Archangel<>(name, Integer.parseInt(level), Integer.parseInt(specialPoints));
                StringBuilder stringBuilder = new StringBuilder(archangel.getUsername());
                stringBuilder = stringBuilder.reverse();
                archangel.setHashedPassword(stringBuilder.toString() + (archangel.getUsername().length() * 21));
                System.out.println(archangel);
                break;
        }
    }
}


/*
Input 1:
"KoHaH" | Demon | 100.0 | 100

Expected output 1:
""KoHaH"" | "1519" -> Demon
10000.0



Input 2:
"Akasha" | Archangel | 5 | 100

Expected output 2:
""Akasha"" | ""ahsakA"168" -> Archangel
500


 */
