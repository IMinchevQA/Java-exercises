import java.util.*;

public class Ex02_SoftUniParty_26Jan2017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

//        ArrayList<String> numbers = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        Scanner sc = new Scanner(System.in);
        HashSet<String> regular = new HashSet<>();
        TreeSet<String> vip = new TreeSet<>();

        while (true) {
            String input = sc.nextLine();
            if ("PARTY".equals(input)) {
                break;
            }

            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }
        }

        while (true) {
            String guestsCome = sc.nextLine();
            if("END".equals(guestsCome)) {
                break;
            }
            if (Character.isDigit(guestsCome.charAt(0))) {
                vip.remove(guestsCome);
            } else {
                regular.remove(guestsCome);
            }
        }

        vip.addAll(regular);
        System.out.println(vip.size());
        for (String guest : vip) {
            System.out.println(guest);
        }
    }
}

//input
//7IK9Yo0h
//9NoBUajQ
//Ce8vwPmE
//SVQXQCbc
//tSzE5t0p
//PARTY
//9NoBUajQ
//Ce8vwPmE
//SVQXQCbc
//END


//input
//m8rfQBvl
//fc1oZCE0
//UgffRkOn
//7ugX7bm0
//9CQBGUeJ
//2FQZT3uC
//dziNz78I
//mdSGyQCJ
//LjcVpmDL
//fPXNHpm1
//HTTbwRmM
//B5yTkMQi
//8N0FThqG
//xys2FYzn
//MDzcM9ZK
//PARTY
//2FQZT3uC
//dziNz78I
//mdSGyQCJ
//LjcVpmDL
//fPXNHpm1
//HTTbwRmM
//B5yTkMQi
//8N0FThqG
//m8rfQBvl
//fc1oZCE0
//UgffRkOn
//7ugX7bm0
//9CQBGUeJ
//END
