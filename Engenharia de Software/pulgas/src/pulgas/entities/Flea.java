package pulgas.entities;

import java.util.Random;

import pulgas.hotel.Yard;

public class Flea {
    private String name;
    private int hunger;
    private Dog dog;

    public Flea (String name) {
        this.name = name;
    }

    public boolean update (Yard yard, Random random) {
        if (hunger >= 100) return false;
        hunger += 1;
        if (!sugar()) return pular(yard, random);
        return true;
    }

    public boolean sugar () {
        if (dog == null) return false;
        if (hunger == 0) return true;
        dog.changeHumor(-3);
        hunger -= 1;
        return true;
    }

    public boolean pular (Yard yard, Random random) { return pular(yard, 0, random); }
    public boolean pular (Yard yard, int chance, Random random) {
        if (chance == 0) chance = hunger;
        if (random.nextInt(101) < chance) return true;
        boolean removed = dog == null;
        for (Dog d : yard.getDogs()) {
            if (random.nextInt(101) < chance) {
                d.addPulga(this);
            }
        }
        return removed;
    }


    public String getName() { return name; }
    public int getHunger() { return hunger; }
    public Dog getDog() { return dog; }

    public void setName(String name) { this.name = name; }
    public void setHunger(int hunger) { this.hunger = hunger; }
    public void setDog(Dog dog) { this.dog = dog; }
}