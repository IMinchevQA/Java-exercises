package rpg_lab;

import java.util.List;
import java.util.Random;

public class Dummy implements Target {

    public static final String TARGET_IS_NOT_DEAD_EXCEPTION_MESSAGE = "Target is not dead.";
    public static final String DUMMY_IS_DEAD_EXCEPTION_MESSAGE = "Dummy is dead.";
    public static final int HEALTH_MIN_VALUE = 1;
    private int health;
    private int experience;
    private List<Weapon> possibleLoot;

    public Dummy(int health, int experience, List<Weapon> possibleLoot) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = possibleLoot;
    }

    public int getHealth() {
        return this.health;
    }


    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException(DUMMY_IS_DEAD_EXCEPTION_MESSAGE);
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException(TARGET_IS_NOT_DEAD_EXCEPTION_MESSAGE);
        }

        return this.experience;
    }

    public Weapon giveWeapon(RandomProvider random) {
        if (!isDead()) {
            throw new IllegalStateException(TARGET_IS_NOT_DEAD_EXCEPTION_MESSAGE);
        }

        int index = random.nextInt(possibleLoot.size());
        return possibleLoot.get(index);
    }

    public boolean isDead() {
        return this.health < HEALTH_MIN_VALUE;
    }
}
