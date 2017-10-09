package game;


public abstract class Champion {
    private int health;
    private int power;
    private int energy;
    private int attackCost;
    private String name;



    protected Champion(int health, int power, int energy, int atackCost, String name) {
        this.health = health;
        this.power = power;
        this.energy = energy;
        this.attackCost = atackCost;
        this.name = name;

    }

    public abstract void attack(Hero);

    public abstract void respond();

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setAttackCost(int attackCost) {
        this.attackCost = attackCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {

        return this.power;
    }

    public int getEnergy() {
        return this.energy;
    }

    public int getAttackCost() {
        return this.attackCost;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {

        return this.health;
    }
}
