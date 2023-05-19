package pulgas.tests;
import org.junit.Test;

import pulgas.Dog;
import pulgas.Flea;
import pulgas.Race;
import pulgas.RandGen;
import pulgas.Yard;

import static org.junit.Assert.*;

public class YardTests {

    @Test
    public void testAddAndRemovePulga() {
        Yard quintal = new Yard(new RandGen());
        Flea pulga = new Flea("Test Pulga");
        quintal.addFlea(pulga);
        assertTrue(quintal.getFleas().contains(pulga));

        boolean result = quintal.removePulga(pulga);
        assertTrue(result);
        assertFalse(quintal.getFleas().contains(pulga));
    }

    @Test
    public void testAddAndRemoveCachorro() {
        Yard quintal = new Yard(new RandGen());
        Dog cachorro = new Dog("Test Dog", Race.randomRace(new RandGen()));
        quintal.addCachorro(cachorro);
        assertTrue(quintal.getDogs().contains(cachorro));

        boolean result = quintal.removeCachorro(cachorro);
        assertTrue(result);
        assertFalse(quintal.getDogs().contains(cachorro));
    }
}
