import java.util.*;

public class Ex13_SrabskoUnleashed_28Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> statistics = new LinkedHashMap<>();


        while (true) {
        String input = sc.nextLine();
            if ("End".equals(input)){
                break;
            }
            if(!input.contains("@")){
                input = sc.nextLine();
                continue;
            }

            String[] data = input.split("@");
            String artistName = data[0].trim();
            String[] concertData = data[1].split("\\s");
            if(concertData.length < 3 || !data[0].endsWith(" ")){
                continue;
            }

            String venue = "";
            for (int iGetVenue = 0; iGetVenue < concertData.length - 2; iGetVenue++) {
                venue += concertData[iGetVenue] + " ";
            }

            venue = venue.trim();

            int ticketsCount = 0;
            int ticketsPrice = 0;

            try {
                ticketsCount = Integer.parseInt(concertData[concertData.length - 1]);
                ticketsPrice = Integer.parseInt(concertData[concertData.length - 2]);
            } catch (Exception ex) {
                continue;
            }

            if(!statistics.containsKey(venue)){
                statistics.put(venue, new LinkedHashMap<String, Long>());
            }

            if(!statistics.get(venue).containsKey(artistName)) {
                statistics.get(venue).put(artistName, (long)0);
            }

            statistics.get(venue).put(artistName, statistics.get(venue).get(artistName) + (ticketsCount * ticketsPrice));

        }

        LinkedHashMap<String, Long> artistSorted = new LinkedHashMap<>();
        for (String venue : statistics.keySet()) {
            statistics.get(venue).entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .forEachOrdered(x -> artistSorted.put(x.getKey(), x.getValue()));

                statistics.get(venue).clear();
            for (String artist : artistSorted.keySet()) {
                statistics.get(venue).put(artist, artistSorted.get(artist));

            }
            artistSorted.clear();
        }

        for (String venue : statistics.keySet()) {
            System.out.println(venue);
            for (String artist : statistics.get(venue).keySet()) {
                System.out.printf("#  %1$s -> %2$d", artist, statistics.get(venue).get(artist));
                System.out.println();
            }
        }
    }
}


/*Input
Lepa Brena @Sunny Beach 25 3500
Dragana @Sunny Beach 23 3500
Ceca @Sunny Beach 28 3500
Mile Kitic @Sunny Beach 21 3500
Ceca @Sunny Beach 35 3500
Ceca @Sunny Beach 70 15000
Saban Saolic @Sunny Beach 120 35000
End

Expected output:
Sunny Beach
#  Saban Saolic -> 4200000
#  Ceca -> 1270500
#  Lepa Brena -> 87500
#  Dragana -> 80500
#  Mile Kitic -> 73500


Input2:
Lepa Brena @Sunny Beach 25 3500
Dragana@Belgrade23 3500
Ceca @Sunny Beach 28 3500
Mile Kitic @Sunny Beach 21 3500
Ceca @Belgrade 35 3500
Ceca @Sunny Beach 70 15000
Saban Saolic @Sunny Beach 120 35000
End

Expected output:
Sunny Beach
#  Saban Saolic -> 4200000
#  Ceca -> 1148000
#  Lepa Brena -> 87500
#  Mile Kitic -> 73500
Belgrade
#  Ceca -> 122500


*/

