package Ex04_Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] phoneNumbers = reader.readLine().trim().split("\\s+");
        String[] sites = reader.readLine().trim().split("\\s+");

        Smartphone phone = new Smartphone(phoneNumbers, sites);

        int phoneNumbersCount = phone.getPhoneNumbers().length;

        for (int i = 0; i < phoneNumbersCount; i++) {

            if(isValidNumber(phone.getPhoneNumbers()[i])) {
                System.out.printf("Calling... %s\n", phone.getPhoneNumbers()[i]);
            } else {
                System.out.println("Invalid number!");
            }
        }

        int sitesCount = phone.getSites().length;

        for (int i = 0; i < sitesCount; i++) {

            if(isValidUrl(phone.getSites()[i])) {
                System.out.printf("Browsing: %s!\n", phone.getSites()[i]);
            } else {
                System.out.println("Invalid URL!");
            }
        }
    }

    private static boolean isValidNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidUrl(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

/*
Input 1:
0882134215 0882134333 08992134215 0558123 3333 1
http://softuni.bg http://youtube.com http://www.g00gle.com

Expected output 1:
Calling... 0882134215
Calling... 0882134333
Calling... 08992134215
Calling... 0558123
Calling... 3333
Calling... 1
Browsing: http://softuni.bg!
Browsing: http://youtube.com!
Invalid URL!


 */
