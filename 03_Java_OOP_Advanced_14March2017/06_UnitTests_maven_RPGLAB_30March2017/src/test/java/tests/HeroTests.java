package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.*;

public class HeroTests {
    private static final int WEAPON_ATTACK = 10;
    private static final int WEAPON_DURABILITY = 10;
    private static final int TARGET_XP = 10;
    private static final String HERO = "Hero";
    private Hero hero;
    private Weapon weaponMock;
    private Target targetMock;
    private RandomProvider randomMock;

    @Before
    public void initializeTestObjects() {
        this.weaponMock = Mockito.mock(Weapon.class);
        this.hero = new Hero(HERO, weaponMock);
        this.targetMock =  Mockito.mock(Target.class);
        this.randomMock = Mockito.mock(RandomProvider.class);
    }

    @Test
    public void heroGainsExperienceFromDeadTarget() {

//        Target target = new Target() {
//
//            public int getHealth() {
//                return 0;
//            }
//
//            public void takeAttack(int attackPoints) {
//
//            }
//
//            public int giveExperience() {
//                return TARGET_XP;
//            }
//
//            public boolean isDead() {
//                return true;
//            }
//        };

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        hero.attack(targetMock, new RandomProvider.Implementation());
        Assert.assertEquals(TARGET_XP, hero.getExperience());
    }

    @Test
    public void heroGetsWeaponWhenTargetIsDead() {
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveWeapon(this.randomMock)).thenReturn(this.weaponMock);

        this.hero.attack(this.targetMock, this.randomMock);
        Assert.assertSame(this.weaponMock, this.hero.getInventory().iterator().next());
    }

}
