package pulgas;

public class Flea {
    private String name;
    private int hunger;
    private Dog dog;

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
        if (dog == null) return false;
        if (hunger == 0) return true;
        dog.changeHumor(-3);
        hunger -= 1;
        return true;
    }

    public boolean pular (Yard yard, RandGen randGen) { return pular(yard, 0, randGen); }
    public boolean pular (Yard yard, int chance, RandGen randGen) {
        if (chance == 0) chance = hunger;
        if (randGen.randInt(101) < chance) return true;
        boolean removed = dog == null;
        for (Dog d : yard.getDogs()) {
            if (randGen.randInt(101) < chance) {
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