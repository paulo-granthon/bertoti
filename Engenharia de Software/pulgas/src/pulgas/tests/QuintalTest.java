package pulgas.tests;
import org.junit.Test;

import pulgas.Cachorro;
import pulgas.Pulga;
import pulgas.Quintal;

import static org.junit.Assert.*;

import java.util.Random;

public class QuintalTest {

    @Test
    public void testAddAndRemovePulga() {
        Quintal quintal = new Quintal(new Random());
        Pulga pulga = new Pulga("Test Pulga");
        quintal.addPulga(pulga);
        assertTrue(quintal.pulgas.contains(pulga));

        boolean result = quintal.removePulga(pulga);
        assertTrue(result);
        assertFalse(quintal.pulgas.contains(pulga));
    }

    @Test
    public void testAddAndRemoveCachorro() {
        Quintal quintal = new Quintal(new Random());
        Cachorro cachorro = new Cachorro("Test Cachorro");
        quintal.addCachorro(cachorro);
        assertTrue(quintal.cachorros.contains(cachorro));

        boolean result = quintal.removeCachorro(cachorro);
        assertTrue(result);
        assertFalse(quintal.cachorros.contains(cachorro));
    }
}
