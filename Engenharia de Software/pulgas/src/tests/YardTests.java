package tests;
import org.junit.Test;

import pulgas.entities.Dog;
import pulgas.entities.Flea;
import pulgas.entities.Race;
import pulgas.main.Yard;

import static org.junit.Assert.*;

import java.util.Random;

public class YardTests {

    @Test
    public void testAddAndRemovePulga() {
        Yard quintal = new Yard(new Random());
        Flea pulga = new Flea("Test Pulga");
        quintal.addFlea(pulga);
        assertTrue(quintal.getFleas().contains(pulga));

        boolean result = quintal.removePulga(pulga);
        assertTrue(result);
        assertFalse(quintal.getFleas().contains(pulga));
    }

    @Test
    public void testAddAndRemoveCachorro() {
        Yard quintal = new Yard(new Random());
        Dog cachorro = new Dog("Test Dog", Race.randomRace(new Random()));
        quintal.addCachorro(cachorro);
        assertTrue(quintal.getDogs().contains(cachorro));

        boolean result = quintal.removeCachorro(cachorro);
        assertTrue(result);
        assertFalse(quintal.getDogs().contains(cachorro));
    }
}
