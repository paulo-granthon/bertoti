import java.util.*;

public class Pessoa {
    String nome;
    List<Cachorro> cachorros = new ArrayList<Cachorro>();

    public void adotar (Cachorro c) {
        if (c.serAdotado(this)) cachorros.add(c);
    }

    public void fazerCarinho (Cachorro c) {
        c.receberCarinho(this);
    }

    public void darBanho (Cachorro c) {
        c.tomarBanho(this);
    }
    
}