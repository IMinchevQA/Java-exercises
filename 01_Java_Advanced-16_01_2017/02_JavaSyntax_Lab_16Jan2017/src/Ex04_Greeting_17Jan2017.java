import java.util.Scanner;

public class Ex04_Greeting_17Jan2017 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String firstName = input.nextLine();
        String secondName = input.nextLine();


        if(firstName.isEmpty()){
            firstName = "*****";
        }

        if(secondName.isEmpty()){
            secondName = "*****";
        }

        System.out.printf("Hello, %s %s!", firstName, secondName);
    }
}