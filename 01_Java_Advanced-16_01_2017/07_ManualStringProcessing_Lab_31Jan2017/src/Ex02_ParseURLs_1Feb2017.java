import java.util.Scanner;

public class Ex02_ParseURLs_1Feb2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] remainder = input.split("://");

        if (remainder.length != 2) {
            System.out.println("Invalid URL");
            return;
        }

        System.out.println(String.format("Protocol = %1$s", remainder[0]));
        int index = remainder[1].indexOf("/");
        String server = remainder[1].substring(0, index);
        String resources = remainder[1].substring(index +1);
        System.out.printf("Server = %1$s\n", server);
        System.out.printf("Resources = %1$s\n", resources);
    }
}

/*
Input1:
https://softuni.bg/courses/java-advanced

Expected output:
Protocol = https
Server = softuni.bg
Resources = courses/java-advance

Input2:
https://www.google.bg/search?q=google&oq=goo&aqs=chrome.0.0j69i60l2://j0j69i57j69i65.2112j0j7&sourceid=chrome&ie=UTF-8

Expected output:
Invalid URL

 */
