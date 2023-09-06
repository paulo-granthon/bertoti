package pulgas.submenus;

import java.util.LinkedList;
import java.util.List;

import pulgas.entities.Dog;
import pulgas.entities.Flea;
import pulgas.utils.Happiness;
import pulgas.utils.Names;
import pulgas.utils.RandGen;

public class Yard {

    private static final int PULGAS_INIT = 25;
    private static final int ADD_FLEA_CD = 60;
    private int addPulgaTimer = 0;
    private List<Dog> dogs = new LinkedList<Dog>();
    private List<Flea> fleas = new LinkedList<Flea>();

    public Yard (RandGen randGen) {        
        for (int i = 0; i < PULGAS_INIT; i++) {
            addFlea(new Flea(Names.RandomDogName(randGen)));
        }
    }

    public void update (RandGen randGen) {

        if (addPulgaTimer >= ADD_FLEA_CD) {
            System.out.println("Nova Pulga adicionada! |  Pulgas " + (fleas.size() - 1) + " -> " + fleas.size());
            addFlea(new Flea(Names.RandomDogName(randGen)));
            addPulgaTimer -= ADD_FLEA_CD;
        }
        
        else addPulgaTimer += 1;
        
        for (int i = 0; i < fleas.size(); i++) {
            Flea flea = fleas.get(i);
            if (flea.update(this, randGen)) continue;
            System.out.println(
                "A flea " + flea.getName() + 
                " morreu de fome | Pulgas " + fleas.size() + " -> " + (fleas.size() - 1)
            );
            removeFlea(flea);
            i--;
        }
        
        for (int i = 0; i < dogs.size(); i++) {
            Dog cachorro = dogs.get(i);
            if (cachorro.update(this, randGen)) continue;
            System.out.println(
                "O cachorro " + cachorro.getName() + 
                " estava " + Happiness.overallHappiness(cachorro.getHappiness(), false, false) + 
                " e fugiu! | Cachorros: " + dogs.size() + " -> " + (dogs.size() - 1)
            );
            removeDog(cachorro);
            i--;
        }

    }

    public void addFlea (Flea flea) {
        fleas.add(flea);
    }

    public boolean removeFlea (Flea p) {
        for (Flea flea : fleas) {
            if (flea != p) continue;
            fleas.remove(p);
            return true;
        }
        return false;
    }

    public void addDog (Dog dog) {
        dogs.add(dog);
    }

    public boolean removeDog (Dog p) {
        for (Dog dog : dogs) {
            if (dog != p) continue;
            dogs.remove(p);
            return true;
        }
        return false;
    }

    public List<Dog> getDogs() { return dogs; }
    public List<Flea> getFleas() { return fleas; }

}
