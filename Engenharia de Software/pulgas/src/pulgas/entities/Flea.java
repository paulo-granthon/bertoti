package pulgas.entities;

import pulgas.main.Yard;
import pulgas.utils.RandGen;

public class Flea {
    private String name;
    private int hunger;
    private Dog hostDog;

    public Flea (String name) {
        this.name = name;
    }

    public boolean update (Yard yard, RandGen randGen) {
        if (hunger >= 100) return false;
        hunger += 1;
        if (!sugar()) return pular(yard, randGen);
        return true;
    }

    public boolean sugar () {
        if (hostDog == null) return false;
        hostDog.changeHumor(-3);
        hunger -= 1;
        return true;
    }

    public boolean pular (Yard yard, RandGen randGen) { return pular(yard, 0, randGen); }
    public boolean pular (Yard yard, int chance, RandGen randGen) {
        if (chance == 0) chance = hunger;
        boolean removed = false;
        System.out.println("flea has " + yard.getDogs().size() + " possible dogs to jump to");
        for (Dog d : yard.getDogs()) {
            if (!randGen.happens(100, chance)) continue;
            if (hostDog != null && hostDog.removePulga(this)) removed = true;
            d.addPulga(this);
            break;
        }
        return removed;
    }

    public String getName() { return name; }
    public int getHunger() { return hunger; }
    public Dog getHostDog() { return hostDog; }

    public void setName(String name) { this.name = name; }
    public void setHunger(int hunger) { this.hunger = hunger; }
    public void setHostDog(Dog dog) { this.hostDog = dog; }
}