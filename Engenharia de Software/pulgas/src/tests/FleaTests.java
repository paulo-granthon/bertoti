package tests;

import org.junit.Before;
import org.junit.Test;
import pulgas.entities.Dog;
import pulgas.entities.Flea;
import pulgas.submenus.Yard;
import pulgas.utils.RandGen;
import tests.utils.MockRandGen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FleaTests {
    private RandGen randGen;
    private Yard yard;
    private Flea flea;

    @Before
    public void setUp() {
        randGen = new RandGen();
        yard = new Yard(randGen);
        flea = new Flea("Test Flea");
    }

    @Test
    public void update_WhenHungerBelow100_ReturnsTrue() {
        flea.setHunger(50);
        flea.setHostDog(new Dog(randGen));

        assertTrue(flea.update(yard, randGen));
    }

    @Test
    public void update_WhenHungerIs100_ReturnsFalse() {
        flea.setHunger(100);

        assertFalse(flea.update(yard, randGen));
    }

    @Test
    public void sugar_WhenDogIsNull_ReturnsFalse() {
        flea.setHostDog(null);assertFalse(flea.sugar());
    }

    @Test
    public void sugar_WhenHungerIsZero_ReturnsTrue() {
        flea.setHunger(0);
        flea.setHostDog(new Dog(randGen));

        assertTrue(flea.sugar());
    }

    @Test
    public void sugar_WhenHungerGreaterThanZero_DecreasesHungerAndChangesDogHumor() {
        int initialHunger = 10;
        flea.setHunger(initialHunger);

        Dog testDog = new Dog(randGen);
        flea.setHostDog(testDog);
        
        int dogPreviousHappiness = testDog.getHappiness();

        assertTrue(flea.sugar());
        assertEquals(initialHunger - 1, flea.getHunger());
        assertEquals(dogPreviousHappiness - 3, testDog.getHappiness());
    }

    @Test
    public void pular_WhenChanceIsZero_UsesHungerAsChance() {
        int hunger = 20;
        flea.setHunger(hunger);

        Dog testDog = new Dog(randGen);
        flea.setHostDog(testDog);

        RandGen mockRandGen = new MockRandGen(false);
        flea.pular(yard, mockRandGen);

        assertFalse(testDog.hasPulga(flea));
    }

    @Test
    public void pular_WhenChanceIs50_AddsFleaToOneDog() {
        int hunger = 20;
        flea.setHunger(hunger);

        Dog testDog = new Dog(randGen);
        flea.setHostDog(testDog);

        RandGen mockRandGen = new MockRandGen(true);
        flea.pular(yard, 50, mockRandGen);

        int dogsHaveThisFlea = 0;

        for (Dog someDog : yard.getDogs()) {
            if (!someDog.hasPulga(flea)) continue;
            dogsHaveThisFlea++;
        }

        assertEquals(dogsHaveThisFlea, 1);
    }

    @Test
    public void pular_WhenChanceIs50_DoesNotAddFleaToSomeDogs() {
        int hunger = 20;
        flea.setHunger(hunger);

        Dog testDog = new Dog(randGen);
        flea.setHostDog(testDog);

        RandGen mockRandGen = new MockRandGen(false);
        flea.pular(yard, 50, mockRandGen);

        assertFalse(testDog.hasPulga(flea));
    }
}
