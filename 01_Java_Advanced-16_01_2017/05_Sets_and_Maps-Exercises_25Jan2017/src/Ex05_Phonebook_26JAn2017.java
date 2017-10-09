import java.util.*;

public class Ex05_Phonebook_26JAn2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> phonebook = new HashMap<>();

        while(true){
            String input = sc.nextLine();
            if("search".equals(input.toLowerCase()) || "stop".equals(input.toLowerCase())) {
                break;
            }

            String[] contactInfo = input.split("-");
            phonebook.put(contactInfo[0], contactInfo[1]);
        }

        while (true) {
            String input = sc.nextLine();
            if("stop".equals(input)) {
                break;
            }
            if(phonebook.containsKey(input)) {
                System.out.println(input + " -> " + phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
        }
    }
}

/*
Input1:
Nakov-0888080808
search
Mariika
Nakov
stop

Expected output:
Contact Mariika does not exist.
Nakov -> 0888080808


Input2:
Nakov-+359888001122
RoYaL(Ivan)-666
Gero-5559393
Simo-02/987665544
search
Simo
simo
RoYaL
RoYaL(Ivan)
stop

Expected output
Simo -> 02/987665544
Contact simo does not exist.
Contact RoYaL does not exist.
RoYaL(Ivan) -> 666


*/