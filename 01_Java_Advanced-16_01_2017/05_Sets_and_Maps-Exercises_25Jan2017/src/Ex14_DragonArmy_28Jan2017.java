import java.util.*;

public class Ex14_DragonArmy_28Jan2017 {
    static final int DEFAULT_HEALTH = 250;
    static final int DEFAULT_DAMAGE = 45;
    static final int DEFAULT_ARMOR = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, TreeSet<Dragon>> dragonsByType = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandArgs = scanner.nextLine().split("\\s+");
            String type = commandArgs[0];
            String name = commandArgs[1];
            String damageAsString = commandArgs[2];
            String healthAsString = commandArgs[3];
            String armorAsString = commandArgs[4];

            int damage = 0;
            int health = 0;
            int armor = 0;

            damage = damageAsString.equals("null") ? DEFAULT_DAMAGE : Integer.parseInt(damageAsString);
            health = healthAsString.equals("null") ? DEFAULT_HEALTH : Integer.parseInt(healthAsString);
            armor = armorAsString.equals("null") ? DEFAULT_ARMOR : Integer.parseInt(armorAsString);

            Dragon dragon = new Dragon(name, damage, health, armor);
            if (!dragonsByType.containsKey(type)) {
                dragonsByType.put(type, new TreeSet<>());
            }

            TreeSet<Dragon> currentTreeSet = dragonsByType.get(type);
            if (currentTreeSet.contains(dragon)) {
                currentTreeSet.remove(dragon);
                currentTreeSet.add(dragon);
            } else {
                currentTreeSet.add(dragon);
            }

            dragonsByType.put(type, currentTreeSet);
        }

        for (Map.Entry<String, TreeSet<Dragon>> stringTreeSetEntry : dragonsByType.entrySet()) {
            String type = stringTreeSetEntry.getKey();
            TreeSet<Dragon> dragons = stringTreeSetEntry.getValue();

            double avgDmg = 0.0;
            double avgHealth = 0.0;
            double avgArmor = 0.0;

            for (Dragon currentDragon : dragons) {
                avgDmg += currentDragon.getDamage();
                avgHealth += currentDragon.getHealth();
                avgArmor += currentDragon.getArmor();
            }

            avgDmg /= dragons.size();
            avgHealth /= dragons.size();
            avgArmor /= dragons.size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", type, avgDmg, avgHealth, avgArmor);
            for (Dragon currentDragon : dragons) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", currentDragon.getName(), currentDragon.getDamage(), currentDragon.getHealth(), currentDragon.getArmor());
            }
        }
    }

    static class Dragon implements Comparable<Dragon> {
        private String name;
        private int damage;
        private int health;
        private int armor;

        public Dragon(String name, int damage, int health, int armor) {
            this.setName(name);
            this.setDamage(damage);
            this.setHealth(health);
            this.setArmor(armor);
        }

        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public int getDamage() {
            return damage;
        }

        private void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        private void setHealth(int health) {
            this.health = health;
        }

        public int getArmor() {
            return armor;
        }

        private void setArmor(int armor) {
            this.armor = armor;
        }

        @Override
        public int compareTo(Dragon dragon) {
            return this.getName().compareTo(dragon.getName());
        }
    }
}


/*
Input1:
5
Red Bazgargal 100 2500 25
Black Dargonax 200 3500 18
Red Obsidion 220 2200 35
Blue Kerizsa 60 2100 20
Blue Algordox 65 1800 50

Expected output:
Red::(160.00/2350.00/30.00)
-Bazgargal -> damage: 100, health: 2500, armor: 25
-Obsidion -> damage: 220, health: 2200, armor: 35
Black::(200.00/3500.00/18.00)
-Dargonax -> damage: 200, health: 3500, armor: 18
Blue::(62.50/1950.00/35.00)
-Algordox -> damage: 65, health: 1800, armor: 50
-Kerizsa -> damage: 60, health: 2100, armor: 20


Input2:
4
Gold Zzazx null 1000 10
Gold Traxx 500 null 0
Gold Xaarxx 250 1000 null
Gold Ardrax 100 1055 50


Expected output:
Gold::(223.75/826.25/17.50)
-Ardrax -> damage: 100, health: 1055, armor: 50
-Traxx -> damage: 500, health: 250, armor: 0
-Xaarxx -> damage: 250, health: 1000, armor: 10
-Zzazx -> damage: 45, health: 1000, armor: 10


 */