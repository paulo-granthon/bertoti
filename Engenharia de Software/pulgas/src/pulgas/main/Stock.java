package pulgas.main;

import java.util.LinkedList;
import java.util.Random;

import pulgas.products.Shampoo;

public class Stock {

    private LinkedList<Shampoo> shampoos;
    private int money;

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
    public int getMoney() { return money; }

    public void addMoney (int amount) {
        money += money;
    }
}
