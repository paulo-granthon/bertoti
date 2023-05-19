package pulgas.entities;

import java.util.List;

import pulgas.main.Yard;
import pulgas.utils.Happiness;
import pulgas.utils.Names;
import pulgas.utils.RandGen;

import java.util.LinkedList;

public class Dog {
    private String name;
    private Race race;
    private List<Flea> pulgas = new LinkedList<Flea>();
    private int happiness;

    public Dog(RandGen randGen) {
        this.name = Names.RandomName(randGen);
        this.race = Race.randomRace(randGen);
        this.happiness = randGen.randInt(30, 71);
    }

    public Dog(String nome, Race race) {
        this.name = nome;
        this.race = race;
        this.happiness = 50;
    }

    public boolean update (Yard yard, RandGen randGen) {
        if (happiness <= 20 && randGen.happens(50, 30 - happiness)) {
            flee(yard);
            return false;
        }
        for (int i = 0; i < pulgas.size(); i++) {
            Flea pulga = pulgas.get(i);
            if (pulga.update(yard, randGen)) continue;
            pulgas.remove(pulga);
            yard.addFlea(pulga);
            i--;
        }
        
        return true;
    }

    public void scratch (Yard yard, RandGen randGen) {
        System.out.println(
            "O cachorro " + name + " se coçou e se livrou de " + 
            tryRemoveFleas(happiness / 2, yard, randGen) + " pulgas!"
        );
    }
    
    public void bePetted () {
        happiness += 5;
        System.out.println(
            name + " ficou " + Happiness.factorAdjective(5) + 
            " No geral, " + name + " aparenta estar " + Happiness.overallHappiness(happiness)
        );
    }

    public boolean takeBath (double bathQuality, double bathSmell, Yard yard, RandGen randGen) {
        int randomBonus = randGen.randInt(0, 11);
        if (randomBonus == 0) System.out.println(name + "Não gostou tanto!");
        else if (randomBonus < 4) System.out.println(name + " achou ok.");
        else if (randomBonus < 8) System.out.println(name + " gostou.");
        else System.out.println(name + " adorou!");
        int pulgasRemoved = tryRemoveFleas(bathQuality + randomBonus + 10, yard, randGen);
        int happinessFactor = (int)(bathSmell * pulgasRemoved) + randomBonus;
        happiness += happinessFactor;
        System.out.println(
            name + " ficou " + Happiness.factorAdjective(happinessFactor) + 
            " No geral, " + name + " aparenta estar " + Happiness.overallHappiness(happiness)
        );
        return true;
    }

    private void flee (Yard yard) {
        for (Flea pulga : pulgas) {
            yard.addFlea(pulga);
        }
    }

    public int tryRemoveFleas (double chance, Yard yard, RandGen randGen) {
        int fleasRemoved = 0;
        for (int i = 0; i < pulgas.size(); i++) {
            if (!randGen.happens(101, chance)) continue;
            Flea flea = pulgas.get(i);
            pulgas.remove(flea);
            yard.addFlea(flea);
            fleasRemoved++;
            i--;
        }
        System.out.println("fleas removed: " + fleasRemoved);
        return fleasRemoved;
    }

    public void changeHumor (int factor) {
        happiness += factor;
    }

    public void addPulga (Flea pulga) {
        pulga.setHostDog(this);
        pulgas.add(pulga);
    }

    public boolean removePulga (Flea pulga) { 
        pulga.setHostDog(null);
        return pulgas.remove(pulga);
    }

    public boolean hasPulga (Flea pulga) { return pulgas.contains(pulga); }
    
    public String getName() { return name; }
    public Race getRace() { return race; }
    public List<Flea> getPulgas() { return pulgas; }
    public int getHappiness() { return happiness; }

    public void setHappiness(int happiness) { this.happiness = happiness; }

}