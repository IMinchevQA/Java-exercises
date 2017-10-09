package rpg_lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hero {

    public static final int EXPERIENCE_INITIAL_VALUE = 0;
    private String name;
    private int experience;
    private Axe weapon;
    private List<Weapon> inventory;

    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.experience = EXPERIENCE_INITIAL_VALUE;
        this.weapon = new Axe(10, 10);
        this.inventory = new ArrayList<Weapon>();
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Axe getWeapon() {
        return this.weapon;
    }

    public void attack(Target target, RandomProvider random) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            this.inventory.add(target.giveWeapon(random));
        }
    }

    public Iterable<Weapon> getInventory() {
        return this.inventory;
    }

    public static void main(String[] args) {
        Weapon weapon = new Axe(10, 10);
        Hero hero = new Hero("Gosho", weapon);
        List<Weapon> weapons = new ArrayList<Weapon>();
        Collections.addAll(weapons, new Axe(20, 20), new Axe(30, 30));
        Target target = new Dummy(10, 10, weapons);
        hero.attack(target, new RandomProvider.Implementation());
        System.out.println();
    }
}
