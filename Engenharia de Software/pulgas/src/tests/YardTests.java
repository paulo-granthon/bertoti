package tests;
import org.junit.Test;

import pulgas.entities.Dog;
import pulgas.entities.Flea;
import pulgas.entities.Race;
import pulgas.submenus.Yard;
import pulgas.utils.RandGen;

import static org.junit.Assert.*;

public class YardTests {

    @Test
    public void testAddAndRemovePulga() {
        Yard quintal = new Yard(new RandGen());
        Flea pulga = new Flea("Test Pulga");
        quintal.addFlea(pulga);
        assertTrue(quintal.getFleas().contains(pulga));

        boolean result = quintal.removeFlea(pulga);
        assertTrue(result);
        assertFalse(quintal.getFleas().contains(pulga));
    }

    @Test
    public void testAddAndRemoveCachorro() {
        Yard quintal = new Yard(new RandGen());
        Dog cachorro = new Dog("Test Dog", Race.randomRace(new RandGen()));
        quintal.addDog(cachorro);
        assertTrue(quintal.getDogs().contains(cachorro));

        boolean result = quintal.removeDog(cachorro);
        assertTrue(result);
        assertFalse(quintal.getDogs().contains(cachorro));
    }
}
