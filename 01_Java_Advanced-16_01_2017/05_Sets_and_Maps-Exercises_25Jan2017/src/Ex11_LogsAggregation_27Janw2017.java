import java.util.*;


public class Ex11_LogsAggregation_27Janw2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        TreeMap<String, TreeMap<String, Integer>> loginfo = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split("\\s");
            String ip = data[0];
            String user = data[1];
            int duration = Integer.parseInt(data[2]);

            if (!loginfo.containsKey(user)) {
                loginfo.put(user, new TreeMap<>());
            }

            if (!loginfo.get(user).containsKey(ip)) {
                loginfo.get(user).put(ip, duration);
            } else {
                loginfo.get(user).put(ip, loginfo.get(user).get(ip) + duration);
            }
        }

        Map<String, Integer> users = new TreeMap<>();

        for (String user : loginfo.keySet()) {
            int totalDuration = 0;
            for (String ip : loginfo.get(user).keySet()){
                totalDuration += loginfo.get(user).get(ip);
            }
            users.put(user, totalDuration);
        }

        for (String user : users.keySet()) {
            TreeSet<String> ipData = new TreeSet<>();
            for (String ip: loginfo.get(user).keySet()){
                ipData.add(ip);
            }
            System.out.println(user + ": " + users.get(user) + " " + ipData);
        }

    }
}

/*
Input:
7
192.168.0.11 peter 33
10.10.17.33 alex 12
10.10.17.35 peter 30
10.10.17.34 peter 120
10.10.17.34 peter 120
212.50.118.81 alex 46
212.50.118.81 alex 4

Expected output:
alex: 62 [10.10.17.33, 212.50.118.81]
peter: 303 [10.10.17.34, 10.10.17.35, 192.168.0.11]


Input:
2
84.238.140.178 nakov 25
84.238.140.178 nakov 35

Expected output:
nakov: 60 [84.238.140.178]

 */
