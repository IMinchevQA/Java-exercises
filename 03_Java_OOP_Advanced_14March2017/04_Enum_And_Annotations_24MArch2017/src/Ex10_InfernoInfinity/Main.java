package Ex10_InfernoInfinity;

import Ex10_InfernoInfinity.implementations.*;
import Ex10_InfernoInfinity.interfaces.Database;
import Ex10_InfernoInfinity.interfaces.Gem;
import Ex10_InfernoInfinity.interfaces.Weapon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Database database = new DatabaseImpl();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        executeReadInput(reader);

    }

    private static void executeReadInput(BufferedReader reader) throws IOException {
        String line = "";
        String[] weaponTokens;
        String command;
        String nameWeapon = null;
        String typeWeapon = null;
        int socketIndex = 0;
        Gem gem = null;
        Weapon weapon = null;

        while (!"END".equals(line = reader.readLine())) {
            weaponTokens = line.split(";");
            command = weaponTokens[0];
            switch (command.toLowerCase()) {
                case "create":
                    typeWeapon = weaponTokens[1];
                    nameWeapon = weaponTokens[2];
                    weapon = executeCreateWeapon(typeWeapon, nameWeapon);
                    database.addWeapon(weapon);
                    break;
                case "add":
                    nameWeapon = weaponTokens[1];
                    socketIndex = Integer.parseInt(weaponTokens[2]);
                    gem = executeCreateGem(weaponTokens[3]);
                    database.getWeapon(nameWeapon).addGem(gem, socketIndex);
                    break;
                case "remove":
                    nameWeapon = weaponTokens[1];
                    socketIndex = Integer.parseInt(weaponTokens[2]);
                    database.getWeapon(nameWeapon).removeGem(socketIndex);
                    break;
                case "compare":
                    Weapon weapon1 = database.getWeapon(weaponTokens[1]);
                    Weapon weapon2 = database.getWeapon(weaponTokens[2]);
                    System.out.println(
                    weapon1.compareTo(weapon2) > 0 ? weapon1 : weapon2);
                    break;
                case "print":
                    System.out.println(database.getWeapon(weaponTokens[1]));
                    break;
            }
        }
    }

    private static Gem executeCreateGem(String gemType) {
        switch (gemType) {
            case "RUBY":

                return new Ruby();

            case "EMERLAD": return new Emerlad();
        }
        return new Amethyst();
    }

    private static Weapon executeCreateWeapon(String typeWeapon, String nameWeapon) {
        switch (typeWeapon) {
            case "AXE": return new Axe(nameWeapon);

            case "SWORD": return new Sword(nameWeapon);
        }
        return new Knife(nameWeapon);
    }
}

/*
Input 1:
Create;AXE;Axe of Misfortune
Add;Axe of Misfortune;0;RUBY
Print;Axe of Misfortune
END

Input 2:
Create;AXE;Axe of Misfortune
Add;Axe of Misfortune;0;RUBY
Remove;Axe of Misfortune;0
Print;Axe of Misfortune
END

Expected output 2:
Axe of Misfortune: 5-10 Damage, +0 Strength, +0 Agility, +0 Vitality


Ex.12
Input 1:
Create;AXE;Axe of Misfortune
Add;Axe of Misfortune;0;RUBY
Create;KNIFE;Thieves Blade
Add;Thieves Blade;0;AMETHYST
Add;Thieves Blade;1;AMETHYST
Compare;Axe of Misfortune;Thieves Blade
END


Expected output 1:
Thieves Blade: 27-80 Damage, +4 Strength, +16 Agility, +8 Vitality (Item Level: 81.5)



 */
