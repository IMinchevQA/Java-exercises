package game;

public class Warrior extends Champion {
    private final static int HEALTH = 200;
    private final static int POWER = 40;
    private final static int ENERGY = 20;
    private final static int ATTACK_COST = 5;

    private int health;
    private int power;
    private int energy;
    private int atackCost;
    private String name;

    public Warrior(String name) {
        this(HEALTH, POWER, ENERGY, ATTACK_COST, name);
    }

    public Warrior(int health, int power, int energy, int atackCost, String name) {
        super(health, power, energy, atackCost, name);
    }

    @Override
    public void attack() {

    }

    @Override
    public void respond() {

    }

}
