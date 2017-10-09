package Ex08_PetClinics;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Pet> pets = new LinkedHashMap<>();
        Map<String, Clinic> clinics = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());
        String[] lineTokens;
        String name;
        int age;
        String kind;
        int roomsCount;

        for (int i = 0; i < n; i++) {
            lineTokens = reader.readLine().split("\\s+");

            switch (lineTokens[0].toLowerCase()) {
                case "create":
                    if (lineTokens[1].toLowerCase().equals("pet")) {
                        name = lineTokens[2];
                        age = Integer.parseInt(lineTokens[3]);
                        kind = lineTokens[4];
                        Pet pet = new Pet(name, age, kind);
                        pets.put(name, pet);
                    } else if (lineTokens[1].toLowerCase().equals("clinic")) {
                        name = lineTokens[2];
                        roomsCount = Integer.parseInt(lineTokens[3]);
                        try {
                            Clinic clinic = new Clinic(roomsCount);
                            clinics.put(name, clinic);
                        } catch (IllegalArgumentException iaex) {
                            System.out.println(iaex.getMessage());
                        }
                    }
                    break;
                case "add":
                    Pet pet = pets.get(lineTokens[1]);
                    Clinic clinic = clinics.get(lineTokens[2]);
                    System.out.println(clinic.add(pet));
                    break;
                case "release":
                    System.out.println(clinics.get(lineTokens[1]).release());
                    break;
                case "hasemptyrooms":
                    System.out.println(clinics.get(lineTokens[1]).hasEmptyRooms());
                    break;
                case "print":
                    if (lineTokens.length == 2) {
                        System.out.println(clinics.get(lineTokens[1]).print());
                    } else if (lineTokens.length == 3) {
                        System.out.println(clinics.get(lineTokens[1]).print(Integer.parseInt(lineTokens[2])));
                    }
                    break;
            }
        }
    }
}



/*
Input 1:
9
Create Pet Gosho 7 Cat
Create Clinic Rezovo 4
Create Clinic Rizovo 1
HasEmptyRooms Rizovo
Release Rizovo
Add Gosho Rizovo
HasEmptyRooms Rizovo
Create Pet Sharo 2 Dog
Add Sharo Rizovo

Expected output 1:
Invalid Operation!
true
false
true
false
false


Input 2:
8
Create Pet Gosho 7 Cat
Create Pet Sosho 1 Cata
Create Clinic Rezovo 5
Add Gosho Rezovo
Add Sosho Rezovo
Print Rezovo 3
Release Rezovo
Print Rezovo


Expected output 2:
true
true
Gosho 7 Cat
true
Room empty
Sosho 1 Cata
Room empty
Room empty
Room empty


 */
