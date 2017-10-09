package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;
import rpg_lab.Weapon;

import java.util.ArrayList;

public class DummyTests {

    public static final int HEALTH = 10;
    public static final int EXPERIENCE = 10;
    public static final int ATTACK_POINTS = 10;
    public static final String WRONG_HEALTH_ERROR_MESSAGE = "Wrong health";
    public static final int EXPECTED_EXPERIENCE_POINTS = 10;
    private static final String WRONG_EXPERIENCE_ERROR_MESSAGE = "Wrong experience";

    private Dummy dummy;

    @Before
    public void initializeTestDummy() {
        this.dummy = new Dummy(HEALTH, EXPERIENCE, new ArrayList<Weapon>());
    }

    @Test
    public void testDummyHealthWhenAttacked() {
        this.dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(WRONG_HEALTH_ERROR_MESSAGE, HEALTH - ATTACK_POINTS, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyWhenAttacked() {
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyGivesExpWhenKilled() {
        this.dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(WRONG_EXPERIENCE_ERROR_MESSAGE, EXPECTED_EXPERIENCE_POINTS, this.dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyNotGivesExp() {
        dummy.giveExperience();
    }
}
