package tests;

import org.junit.Test;

import pulgas.entities.Dog;
import pulgas.entities.Flea;
import pulgas.entities.Race;

import static org.junit.Assert.*;

import java.util.Random;

public class DogTests {

    @Test
    public void testAddAndRemovePulga() {
        Dog cachorro = new Dog("Test Dog", Race.randomRace(new Random()));
        Flea pulga = new Flea("Test Pulga");
        cachorro.addPulga(pulga);
        assertTrue(cachorro.getPulgas().contains(pulga));

        boolean result = cachorro.removePulga(pulga);
        assertTrue(result);
        assertFalse(cachorro.getPulgas().contains(pulga));
    }

}
