import java.util.*;

public class Ex07_FixEmails_27Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner sc = new Scanner(System.in);
        String[] domainsForbidden = {".uk", ".us", ".com"};
        LinkedHashMap<String, String> personsEmails = new LinkedHashMap<String, String>();

        String personName = sc.nextLine();

        while(true){
            if(personName.isEmpty() || "stop".equals(personName)){
                break;
            }
            String email = sc.nextLine();
            String domain = email.substring(email.indexOf("."), email.length());
            
            if(!Arrays.asList(domainsForbidden).contains(domain)){
                personsEmails.put(personName, email);
            }
            personName = sc.nextLine();
        }

        for (String s : personsEmails.keySet()) {
            System.out.printf("%1s -> %2s", s, personsEmails.get(s));
            System.out.println();
        }
    }
}

/*
Input
Ivan
ivanivan@abv.bg
Petar Ivanov
petartudjarov@abv.bg
Mike Tyson
myke@gmail.us
stop

Expected output:
Ivan -> ivanivan@abv.bg
Petar Ivanov -> petartudjarov@abv.bg


Input:
Ivan
ivanivan@gmail.com
Petar Ivanov
petartudjarov@yahoo.com
Mike Tyson
myke@abv.bg
stop

Expected output:
Mike Tyson -> myke@abv.bg

 */