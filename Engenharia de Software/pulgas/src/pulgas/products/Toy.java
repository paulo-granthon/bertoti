package pulgas.products;

import pulgas.utils.RandGen;

public class Toy extends Product {

    private double fun;

    public Toy (String name, int price, int uses, double fun) {
        super(name, price, uses);
        this.fun = fun;
    }

    public int use (int amount) {
        int count = 0;
        for (int i = 0; i < amount; i++) {
            if (!use()) break;
            count++;
        }
        return count;
    }

    public boolean use () {
        if (uses == 0) return false;
        uses--;
        return true; 
    }

    public static Toy random (RandGen randGen) {
        final String[] names = new String[] {
            "Osso Turbo",
            "Bolinha Saltitante",
            "Frisbee Voador",
            "Corda Maluca",
            "Pelúcia Maluquinha",
            "Pato de Borracha",
            "Caminhão Mordedor",
            "Pula-Pula Canino",
            "Galinha de Pelúcia",
            "Bola Sonora"
        };
        final int uses = randGen.randInt(10, 100);
        return new Toy(
            names[randGen.randInt(101) % names.length],
            randGen.randInt(5, 10) * uses,
            uses,
            randGen.randDouble(0.1, 4.5)
        );
    }

    public double getFun() { return fun; }
}
