package game;

import com.sun.xml.internal.bind.AnyTypeAdapter;

public class Mage extends Champion {
    private final static int HEALTH = 100;
    private final static int POWER = 20;
    private final static int ENERGY = 50;
    private final static int ATTACK_COST = 10;



    private int health;
    private int power;
    private int energy;
    private int atackCost;
    private String name;


    public Mage(String name) {
        this(HEALTH, POWER, ENERGY, ATTACK_COST, name);
    }

    public Mage(int health, int power, int energy, int atackCost, String name) {
        super(health, power, energy, atackCost, name);
    }

    @Override
    public void attack() {

    }

    @Override
    public void respond() {

    }



}
