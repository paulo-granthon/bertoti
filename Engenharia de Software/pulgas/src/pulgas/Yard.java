package pulgas;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Yard {

    private static int PULGAS_INIT = 25;
    private static int DOGS_INIT = 6;
    private static int addPulgaCD = 60;
    private int addPulgaTimer = 0;
    private List<Dog> dogs = new LinkedList<Dog>();
    private List<Flea> fleas = new LinkedList<Flea>();

    public Yard (Random random) {
        for (int i = 0; i < PULGAS_INIT; i++) {
            addFlea(new Flea(Names.RandomName(random)));
        }
        
        for (int i = 0; i < DOGS_INIT; i++) {
            addCachorro(new Dog(random));
        }
    }

    public void update (Random random) {

        if (addPulgaTimer >= addPulgaCD) {
            System.out.println("Nova Pulga adicionada! |  Pulgas " + (fleas.size() - 1) + " -> " + fleas.size());
            addFlea(new Flea(Names.RandomName(random)));
            addPulgaTimer -= addPulgaCD;
        }
        
        else addPulgaTimer += 1;
        
        for (int i = 0; i < fleas.size(); i++) {
            Flea pulga = fleas.get(i);
            if (pulga.update(this, random)) continue;
            System.out.println(
                "A pulga " + pulga.getName() + 
                " morreu de fome | Pulgas " + fleas.size() + " -> " + (fleas.size() - 1)
            );
            removePulga(pulga);
            i--;
        }
        
        for (int i = 0; i < dogs.size(); i++) {
            Dog cachorro = dogs.get(i);
            if (cachorro.update(this, random)) continue;
            System.out.println(
                "O cachorro " + cachorro.getName() + 
                " estava " + Happiness.overallHappiness(cachorro.getHappiness(), false, false) + 
                " e fugiu! | Cachorros: " + dogs.size() + " -> " + (dogs.size() - 1)
            );
            removeCachorro(cachorro);
            i--;
        }

    }

    public void addFlea (Flea pulga) {
        fleas.add(pulga);
    }

    public boolean removePulga (Flea p) {
        for (Flea pulga : fleas) {
            if (pulga != p) continue;
            fleas.remove(p);
            return true;
        }
        return false;
    }

    public void addCachorro (Dog cachorro) {
        dogs.add(cachorro);
    }

    public boolean removeCachorro (Dog p) {
        for (Dog cachorro : dogs) {
            if (cachorro != p) continue;
            dogs.remove(p);
            return true;
        }
        return false;
    }

    public List<Dog> getDogs() { return dogs; }
    public List<Flea> getFleas() { return fleas; }

}