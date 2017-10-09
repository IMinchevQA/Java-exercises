import java.util.*;

public class Ex01_UniqueUsernames_26Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            usernames.add(sc.nextLine());
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}

//Input
//6
//Ivan
//Ivan
//Ivan
//SemoMastikata
//Ivan
//Hubaviq1234

//Expected output
//Ivan
//SemoMastikata
//Hubaviq1234


