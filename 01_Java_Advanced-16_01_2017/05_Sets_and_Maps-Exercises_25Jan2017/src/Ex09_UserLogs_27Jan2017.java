import java.util.*;

public class Ex09_UserLogs_27Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner sc = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> logInfo = new TreeMap<>();

        String input = sc.nextLine();

        while (true) {
            if (input.isEmpty() || "end".equals(input)){
                break;
            }

            String[] dataLog = input.split(" ");
            String ip = dataLog[0].split("=")[1];
            String user = dataLog[2].split("=")[1];

            if(!logInfo.containsKey(user)){
                logInfo.put(user, new LinkedHashMap<>());
            }

            if(!logInfo.get(user).containsKey(ip)){
                logInfo.get(user).put(ip, 1);
            } else {
                logInfo.get(user).put(ip, logInfo.get(user).get(ip) + 1);
            }
            input = sc.nextLine();
        }

        for(String log : logInfo.keySet()){
            System.out.println(log + ":");
            String forPrint = "";
            int count = logInfo.get(log).size();
            for (String s : logInfo.get(log).keySet()) {
                forPrint += s + " => " + logInfo.get(log).get(s) + ", ";
            }
            forPrint = forPrint.substring(0, forPrint.length()-2) + ".";
            System.out.println(forPrint);
        }
    }
}

/*
Input:
IP=192.23.30.40 message='Hello&derps.' user=destroyer
IP=192.23.30.41 message='Hello&yall.' user=destroyer
IP=192.23.30.40 message='Hello&hi.' user=destroyer
IP=192.23.30.42 message='Hello&Dudes.' user=destroyer
end

Expected output:
destroyer:
192.23.30.40 => 2, 192.23.30.41 => 1, 192.23.30.42 => 1.


Input2:
IP=FE80:0000:0000:0000:0202:B3FF:FE1E:8329 message='Hey&son' user=mother
IP=192.23.33.40 message='Hi&mom!' user=child0
IP=192.23.30.40 message='Hi&from&me&too' user=child1
IP=192.23.30.42 message='spam' user=destroyer
IP=192.23.30.42 message='spam' user=destroyer
IP=192.23.50.40 message='' user=yetAnotherUsername
IP=192.23.50.40 message='comment' user=yetAnotherUsername
IP=192.23.155.40 message='Hello.' user=unknown
end

Expected output:
child0:
192.23.33.40 => 1.
child1:
192.23.30.40 => 1.
destroyer:
192.23.30.42 => 2.
mother:
FE80:0000:0000:0000:0202:B3FF:FE1E:8329 => 1.
unknown:
192.23.155.40 => 1.
yetAnotherUsername:
192.23.50.40 => 2.


 */
