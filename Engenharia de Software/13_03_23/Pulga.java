import java.util.Random;

public class Pulga {
    String nome;
    int fome;

    Cachorro cachorro;

    public Pulga (String nome) {
        this.nome = nome;
    }


    public boolean update (Quintal q) {
        if (fome > 100) return false;
        fome += 1;
        if (!sugar()) return pular(q);
        return true;
    }

    public boolean sugar () {
        if (cachorro == null) return false;
        if (fome < 1) return true;
        cachorro.changeHumor(-1);
        fome -= 1;
        return true;
    }

    public boolean pular (Quintal q) { return pular(q, 0); }
    public boolean pular (Quintal q, int c) {
        if (c == 0) c = fome;
        // System.out.println(nome + "pulou");
        Random random = new Random();
        if (random.nextInt(101) < c) return true;
        boolean removed = cachorro == null;
        for (Cachorro cachorro : q.cachorros) {
            if (random.nextInt(101) < c) {
                cachorro.addPulga(this);
            }
        }
        return removed;
    }
}