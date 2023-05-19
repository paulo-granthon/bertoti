package pulgas.main;

import java.util.LinkedList;

import pulgas.products.Shampoo;
import pulgas.utils.RandGen;

public class Stock {

    private LinkedList<Shampoo> shampoos;
    private int money;

    public Stock(RandGen randGen) {
        shampoos = new LinkedList<>();
        generateRandomStock(randGen);
    }

    private void generateRandomStock (RandGen randGen) {
        while (randGen.happens(101, 25)) {
            shampoos.add(Shampoo.random(randGen));
        }
        if (shampoos.size() < 2) generateRandomStock(randGen);
    }

    public LinkedList<Shampoo> getShampoos() { return shampoos; }
    public int getMoney() { return money; }

    public void addMoney (int amount) {
        money += money;
    }
}
