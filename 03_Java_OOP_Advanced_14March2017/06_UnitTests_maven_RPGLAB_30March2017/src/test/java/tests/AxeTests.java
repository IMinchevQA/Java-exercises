package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Target;
import rpg_lab.Weapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AxeTests {

    private static final int AXE_DURABILITY = 10;
    public static final int AXE_ATTACK = 10;
    public static final int DUMMY_HEALTH = 10;
    public static final int DUMMY_XP = 10;
    public static final int EXPECTED_DURABILITY = 9;

//    List<Weapon> weapons;


    private Weapon axe;
    private Target target;

    @Before
    public void initializeTestObjects() {
        //arrange
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
//        this.setWeapons();
//        this.target = new Dummy(DUMMY_HEALTH, DUMMY_XP, this.weapons);
        this.target = new Dummy(DUMMY_HEALTH, DUMMY_XP, new ArrayList<Weapon>());

    }

//    private void setWeapons() {
//        this.weapons = new ArrayList<Weapon>();
//        Collections.addAll(weapons, new Axe(20, 20), new Axe(30, 30));
//    }

    @Test
    public void axeDurabilityTest() {
        //act
        this.axe.attack(this.target);

        //assert
        Assert.assertEquals("Wrong durability value.", EXPECTED_DURABILITY, this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testBrokenAxeAttack() {
        while (this.axe.getDurabilityPoints() > 0) {
            this.axe.attack(this.target);
        }
    }


}
