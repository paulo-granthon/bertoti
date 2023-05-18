package pulgas;

import java.util.LinkedList;
import java.util.Random;

public class Stock {

    private LinkedList<Shampoo> shampoos;

    public Stock(Random random) {
        shampoos = new LinkedList<>();
        generateRandomStock(random);
    }

    private void generateRandomStock (Random random) {
        while (random.nextInt(101) < 25) {
            shampoos.add(Shampoo.random(random));
        }
        if (shampoos.size() < 2) generateRandomStock(random);
    }

    public LinkedList<Shampoo> getShampoos() { return shampoos; }
}
