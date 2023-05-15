package pulgas.tests;

import org.junit.Test;

import pulgas.Cachorro;
import pulgas.Pessoa;
import pulgas.Pulga;

import static org.junit.Assert.*;

public class CachorroTest {

    @Test
    public void testAddAndRemovePulga() {
        Cachorro cachorro = new Cachorro("Test Cachorro");
        Pulga pulga = new Pulga("Test Pulga");
        cachorro.addPulga(pulga);
        assertTrue(cachorro.getPulgas().contains(pulga));

        boolean result = cachorro.removePulga(pulga);
        assertTrue(result);
        assertFalse(cachorro.getPulgas().contains(pulga));
    }

    @Test
    public void testSerAdotado() {
        Cachorro cachorro = new Cachorro("Test Cachorro");
        Pessoa newOwner = new Pessoa("Test Owner");

        cachorro.setOwner(new Pessoa("Old Owner"));

        boolean result = cachorro.serAdotado(newOwner);
        assertTrue(result);
        assertEquals(newOwner, cachorro.getOwner());
        assertEquals(1, cachorro.getHappiness());
    }
}
