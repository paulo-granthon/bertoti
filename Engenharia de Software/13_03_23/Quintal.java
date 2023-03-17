import java.util.List;
import java.util.Random;
import java.util.ArrayList;


public class Quintal {

    static int PULGAS_INIT = 25;
    static int DOGS_INIT = 6;

    static int addPulgaCD = 60;
    int addPulgaTimer = 0;

    public List<Cachorro> cachorros = new ArrayList<Cachorro>();
    public List<Pulga> pulgas = new ArrayList<Pulga>();

    static  String[] NAMES = new String[] {
        "Miguel",
        "Gael",
        "Maria Alice",
        "Arthur",
        "Helena",
        "Heitor",
        "Alice",
        "Theo",
        "Laura",
        "Davi",
        "Samuel",
        "Bernardo",
        "Gabriel",
        "Ravi",
        "João Miguel",
        "Noah",
        "Maria Cecilia",
        "Cecilia",
        "Maite",
        "Heloisa",
    };
    public static String randomName (Random random) {
        return NAMES[random.nextInt(NAMES.length)];
    }

    public Quintal (Random random) {
        for (int i = 0; i < PULGAS_INIT; i++) {
            addPulga(new Pulga(randomName(random)));
        }
        
        for (int i = 0; i < DOGS_INIT; i++) {
            addCachorro(new Cachorro(randomName(random)));
        }
    }
    
    public static void main (String[] args) {

        Random random = new Random();
        Quintal quintal = new Quintal(random);
    
        if (quintal.addPulgaTimer >= addPulgaCD) {
            quintal.addPulga(new Pulga(randomName(random)));
            quintal.addPulgaTimer -= addPulgaCD;
        }
        
        else quintal.addPulgaTimer += 1;

        for (Pulga pulga : quintal.pulgas) {
            if (!pulga.update(quintal)) quintal.removePulga(pulga);
        }

        for (Cachorro cachorro : quintal.cachorros) {
            if (!cachorro.update(quintal)) quintal.removeCachorro(cachorro);
        }

    }

    public void addPulga (Pulga pulga) {
        pulgas.add(pulga);
    }

    public boolean removePulga (Pulga p) {
        for (Pulga pulga : pulgas) {
            if (pulga != p) continue;
            pulgas.remove(p);
            return true;
        }
        return false;
    }

    public void addCachorro (Cachorro cachorro) {
        cachorros.add(cachorro);
    }

    public boolean removeCachorro (Cachorro p) {
        for (Cachorro cachorro : cachorros) {
            if (cachorro != p) continue;
            cachorros.remove(p);
            return true;
        }
        return false;
    }

}
