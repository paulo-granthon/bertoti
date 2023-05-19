package pulgas.tests;

import org.junit.Test;

import pulgas.entities.Dog;
import pulgas.entities.Flea;
import pulgas.entities.Race;
import pulgas.utils.RandGen;

import static org.junit.Assert.*;

public class DogTests {

    @Test
    public void testAddAndRemovePulga() {
        Dog cachorro = new Dog("Test Dog", Race.randomRace(new RandGen()));
        Flea pulga = new Flea("Test Pulga");
        cachorro.addPulga(pulga);
        assertTrue(cachorro.getPulgas().contains(pulga));

        boolean result = cachorro.removePulga(pulga);
        assertTrue(result);
        assertFalse(cachorro.getPulgas().contains(pulga));
    }

}
