package pulgas;

import java.util.List;
import java.util.Random;
import java.util.LinkedList;

public class Cachorro {
    String name;
    String race;
    Pessoa owner;
    List<Pulga> pulgas = new LinkedList<Pulga>();
    int happiness;

    public static final String[] RACES = new String[] {
        "Labrador",
        "Pincher",
        "Pit Bull",
        "Husky",
        "Buddercole",
        "Bull Terrier",
        "Caramelo",
        "Poodle Imortal"
    };

    public static String randomRace (Random random) {
        return RACES[random.nextInt(RACES.length)];
    }

    public Cachorro(String nome) {
        this.name = nome;
        this.race = randomRace(new Random());
        this.owner = null;
    }

    public Cachorro(String nome, String race) {
        this.name = nome;
        this.race = race;
        this.owner = null;
    }

    public Cachorro(String nome, String race, Pessoa dono) {
        this.name = nome;
        this.race = race;
        this.owner = dono;
    }

    public boolean update (Quintal q, Random random) {
        if (happiness <= 20 && random.nextInt(50) < 30 - happiness) {
            for (Pulga pulga : pulgas) {
                q.addPulga(pulga);
            }
            return false;
        }
        for (Pulga pulga : pulgas) {
            if (!pulga.update(q)) {
                pulgas.remove(pulga);
                q.addPulga(pulga);
            }
        }
        
        return true;
    }

    public void seCoçar () {
        int pulga_index = -1;
        int min_hunger = Integer.MAX_VALUE;
        for (int i = 0; i < pulgas.size(); i++) {
            if (pulgas.get(i).hunger < min_hunger) pulga_index = i; 
        }
        if (pulga_index >= 0) pulgas.remove(pulga_index);
    }

    public void changeHumor (int offset) {
        happiness += offset;
    }

    public boolean serAdotado (Pessoa newOwner) {
        if (owner == null) return false;
        owner = newOwner;
        happiness += 1;
        return true;
    }

    public void addPulga (Pulga p) {
        pulgas.add(p);
    }

    public boolean removePulga (Pulga p) {
        for (Pulga pulga : pulgas) {
            if (pulga != p) continue;
            pulgas.remove(p);
            return true;
        }
        return false;
    }
    
    public boolean receberCarinho (Pessoa p) {
        happiness += 1;
        return true;
    }

    public boolean tomarBanho (Pessoa p) {
        if (!p.equals(owner)) return false;
        pulgas.clear();
        happiness += 5;
        return true;
    }

    public String getName() { return name; }
    public String getRace() { return race; }
    public Pessoa getOwner() { return owner; }
    public List<Pulga> getPulgas() { return pulgas; }
    public int getHappiness() { return happiness; }

    public void setOwner(Pessoa newOwner) { owner = newOwner; }

}