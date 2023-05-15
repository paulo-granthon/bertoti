package pulgas;

import java.util.Random;

public class Pulga {
    String name;
    int hunger;

    Cachorro dog;

    public Pulga (String name) {
        this.name = name;
    }


    public boolean update (Quintal q) {
        if (hunger >= 100) return false;
        hunger += 1;
        if (!sugar()) return pular(q);
        return true;
    }

    public boolean sugar () {
        if (dog == null) return false;
        if (hunger < 1) return true;
        dog.changeHumor(-1);
        hunger -= 1;
        return true;
    }

    public boolean pular (Quintal q) { return pular(q, 0); }
    public boolean pular (Quintal q, int c) {
        if (c == 0) c = hunger;
        // System.out.println(nome + "pulou");
        Random random = new Random();
        if (random.nextInt(101) < c) return true;
        boolean removed = dog == null;
        for (Cachorro cachorro : q.cachorros) {
            if (random.nextInt(101) < c) {
                cachorro.addPulga(this);
            }
        }
        return removed;
    }
}