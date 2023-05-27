package pulgas.products;

import pulgas.utils.RandGen;

public class Shampoo {
    private String name;
    private int uses;
    private double quality;
    private double smell;
    private int price;
    
    public Shampoo(
        String name,
        int uses,
        double quality,
        double smell,
        int price
    ) {
        this.name = name;
        this.uses = uses;
        this.quality = quality;
        this.smell = smell;
        this.price = price;
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

    public static Shampoo random (RandGen randGen) {
        final String[] names = new String[] {
            "Espuma Fofurante",
            "Cheirinho Canino",
            "Banho Divertido",
            "Pelagem Engraçada",
            "Shampoo Risonho",
            "Cachorrinho Cheiroso",
            "Lavagem Cômica",
            "Furacão de Fragrância",
            "Líquido da Alegria",
            "Espuma de Risadas"
        };
        return new Shampoo(
            names[randGen.randInt(101) % names.length],
            randGen.randInt(1, 13),
            randGen.randDouble(0.1, 4.5),
            randGen.randDouble(0.1, 4.5),
            randGen.randInt(25, 200)
        );
    }
    
    public String getName() { return name; }
    public int getUses() { return uses; }
    public double getQuality() { return quality; }
    public double getSmell() { return smell; }
    public int getPrice() { return price; }

}
