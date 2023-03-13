import java.util.List;
import java.util.ArrayList;

public class Cachorro {
    String name;
    String race;
    Pessoa owner;
    List<Pulga> pulgas = new ArrayList<Pulga>();

    public Cachorro(String nome, String race, Pessoa dono) {
        this.name = nome;
        this.race = race;
        this.owner = dono;
    }

    public boolean serAdotado (Pessoa newOwner) {
        if (owner == null) return false;
        owner = newOwner;
        return true;
    }

    public void addPulga (Pulga p) {
        pulgas.add(p);
    }
    
    public boolean receberCarinho (Pessoa p) {
        return true;
    }

    public boolean tomarBanho (Pessoa p) {
        if (!p.equals(owner)) return false;
        pulgas.clear();
        return true;
    }
}
