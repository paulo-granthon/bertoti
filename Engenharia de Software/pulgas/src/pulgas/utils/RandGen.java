package pulgas.utils;

import java.util.Random;

public class RandGen {
    public Random random;
    
    public RandGen () {
        this.random = new Random();
    }

    public int randInt () { return randInt(0, Integer.MAX_VALUE); }
    public int randInt (int max) { return randInt(0, max); }
    public int randInt (int min, int max) {
        return random.nextInt(max - min) % max;
    }

    public double randDouble () { return randDouble(0.0, Double.MAX_VALUE); }
    public double randDouble (double max) { return randDouble(0.0, max); }
    public double randDouble (double min, double max) {
        return random.nextDouble(max - min) % max;
    }
}
