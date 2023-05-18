package pulgas;

import java.util.Random;

public class Shampoo {
    private String name;
    private int uses;
    private double quality;
    private double smell;
    
    public Shampoo(
        String name,
        int uses,
        double quality,
        double smell
    ) {
        this.name = name;
        this.uses = uses;
        this.quality = quality;
        this.smell = smell;
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

    public static Shampoo random (Random random) {
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
            names[random.nextInt(101) % names.length],
            random.nextInt(13 - 1) + 1,
            (random.nextDouble() % 4.5) + 0.1,
            (random.nextDouble() % 4.5) + 0.1
        );
    }
    
    public String getName() { return name; }
    public int getUses() { return uses; }
    public double getQuality() { return quality; }
    public double getSmell() { return smell; }
}
