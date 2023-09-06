package pulgas.utils;

import java.util.Random;

public class RandGen {
    protected Random random;
    protected int lastInt;
    protected double lastDouble;
    
    public RandGen () {
        this.random = new Random();
    }

    public boolean happens (int max, int threshold) { return happens(0, max, threshold); }
    public boolean happens (int min, int max, int threshold) {
        return randInt(min, max) <= threshold;
    }

    public boolean happens (double max, double threshold) { return happens(0, max, threshold); }
    public boolean happens (double min, double max, double threshold) {
        return randDouble(min, max) <= threshold;
    }

    public int randInt () { return randInt(0, Integer.MAX_VALUE); }
    public int randInt (int max) { return randInt(0, max); }
    public int randInt (int min, int max) {
        lastInt = random.nextInt(max - min) + min;
        return lastInt;
    }

    public double randDouble () { return randDouble(0.0, Double.MAX_VALUE); }
    public double randDouble (double max) { return randDouble(0.0, max); }
    public double randDouble (double min, double max) {
        lastDouble = (random.nextDouble() % (max - min)) + min;
        return lastDouble;
    }

    public int getLastInt() { return lastInt; }
    public double getLastDouble() { return lastDouble; }

}