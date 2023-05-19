package pulgas.entities;

import java.util.List;
import java.util.Optional;

import pulgas.main.Yard;
import pulgas.products.Shampoo;
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
        if (happiness <= 20 && randGen.randInt(50) < 30 - happiness) {
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

    public boolean takeBath (Optional<Shampoo> shampooOptional, int shampooUses, Yard yard, RandGen randGen) {
        int randomBonus = randGen.randInt(0, 11);
        int actualUses = 0;
        double shampooQuality = 0.5;
        double shampooSmell = 0.5;
        if (shampooOptional.isPresent()) {
            Shampoo shampoo = shampooOptional.get();
            actualUses = shampoo.use(shampooUses);
            if (shampoo.getUses() == 0) System.out.println("O Shampoo " + shampoo.getName() + " acabou!");
            if (actualUses != shampooUses) System.out.println(
                "Não tinha Shampoo suficiente para " + shampooUses + 
                " usos! Usando " + actualUses + " de Shampoo."
            );
            System.out.println("Usando " + actualUses + " de Shampoo.");
        }
        if (randomBonus == 0) System.out.println(name + "Não gostou tanto!");
        else if (randomBonus < 4) System.out.println(name + " achou ok.");
        else if (randomBonus < 8) System.out.println(name + " gostou.");
        else System.out.println(name + " adorou!");
        int pulgasRemoved = tryRemoveFleas((shampooQuality * actualUses) + randomBonus + 10, yard, randGen);
        int happinessFactor = (int)((shampooSmell * actualUses) * pulgasRemoved) + randomBonus;
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
            if (randGen.randInt(0, 101) >= chance) continue;
            Flea flea = pulgas.get(i);
            pulgas.remove(flea);
            yard.addFlea(flea);
            fleasRemoved++;
            i--;
        }
        return fleasRemoved;
    }

    public void changeHumor (int factor) {
        happiness += factor;
    }

    public void addPulga (Flea pulga) { pulgas.add(pulga); }
    public boolean removePulga (Flea p) { return pulgas.remove(p); }

    public String getName() { return name; }
    public Race getRace() { return race; }
    public List<Flea> getPulgas() { return pulgas; }
    public int getHappiness() { return happiness; }

}