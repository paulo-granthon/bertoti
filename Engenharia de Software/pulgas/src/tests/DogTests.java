package tests;

import org.junit.Before;
import org.junit.Test;
import pulgas.entities.Dog;
import pulgas.entities.Flea;
import pulgas.main.Yard;
import pulgas.utils.RandGen;
import tests.utils.MockRandGen;

import static org.junit.Assert.*;

public class DogTests {
    private RandGen randGen;
    private Yard yard;
    private Dog dog;

    @Before
    public void setUp() {
        randGen = new RandGen();
        yard = new Yard(randGen);
        dog = new Dog(randGen);
    }

    @Test
    public void update_WhenHappinessAbove20_ReturnsTrue() {
        dog.changeHumor(50);
        assertTrue(dog.update(yard, randGen));
    }

    @Test
    public void update_WhenHappinessBelowEquals20AndRandGenHappens_ReturnsFalseAndFlees() {
        dog.setHappiness(20);

        RandGen mockRandGen = new MockRandGen(true);
        assertFalse(dog.update(yard, mockRandGen));
        assertTrue(yard.getFleas().containsAll(dog.getPulgas()));
    }

    @Test
    public void update_WhenHappinessBelowEquals20AndRandGenDoesNotHappen_ReturnsTrue() {
        dog.setHappiness(20);

        RandGen mockRandGen = new MockRandGen(false);
        assertTrue(dog.update(yard, mockRandGen));
    }

    @Test
    public void scratch_RemovesNoFleasIfRandomFalse() {
        Flea flea1 = new Flea("Flea 1");
        Flea flea2 = new Flea("Flea 2");
        dog.addPulga(flea1);
        dog.addPulga(flea2);

        RandGen mockRandGen = new MockRandGen(true);
        dog.tryRemoveFleas(100, yard, mockRandGen);

        assertTrue(dog.hasPulga(flea1));
        assertTrue(dog.hasPulga(flea2));
        assertFalse(yard.getFleas().contains(flea1));
        assertFalse(yard.getFleas().contains(flea2));
    }

    @Test
    public void bePetted_IncreasesHappinessBy5() {
        int initialHappiness = dog.getHappiness();
        dog.bePetted();
        assertEquals(initialHappiness + 5, dog.getHappiness());
    }

    @Test
    public void takeBath_RemovesFleasBasedOnQualityAndSmell() {
        Flea flea1 = new Flea("Flea 1");
        Flea flea2 = new Flea("Flea 2");
        dog.addPulga(flea1);
        dog.addPulga(flea2);

        dog.setHappiness(50);

        double bathQuality = 100.0;
        double bathSmell = 0.5;

        RandGen mockRandGen = new MockRandGen(true);
        assertTrue(dog.takeBath(bathQuality, bathSmell, yard, mockRandGen));

        assertFalse(dog.hasPulga(flea1));
        assertFalse(dog.hasPulga(flea2));
        assertTrue(yard.getFleas().contains(flea1));
        assertTrue(yard.getFleas().contains(flea2));

        int expectedHappinessFactor = (int) (bathSmell * 2) + mockRandGen.randInt(0, 11);
        assertEquals(50 + expectedHappinessFactor, dog.getHappiness());
    }

    @Test
    public void addPulga_AddsFleaToDog() {
        Flea flea = new Flea("Flea");
        dog.addPulga(flea);

        assertTrue(dog.hasPulga(flea));
        assertEquals(dog, flea.getHostDog());
    }

    @Test
    public void removePulga_RemovesFleaFromDog() {
        Flea flea = new Flea("Flea");
        dog.addPulga(flea);

        assertTrue(dog.removePulga(flea));
        assertFalse(dog.hasPulga(flea));
        assertNull(flea.getHostDog());
    }

    @Test
    public void hasPulga_ReturnsTrueIfDogHasFlea() {
        Flea flea = new Flea("Flea");
        dog.addPulga(flea);

        assertTrue(dog.hasPulga(flea));
    }

    @Test
    public void hasPulga_ReturnsFalseIfDogDoesNotHaveFlea() {
        Flea flea = new Flea("Flea");

        assertFalse(dog.hasPulga(flea));
    }
}
