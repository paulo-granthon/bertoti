package pulgas.submenus;

import java.util.LinkedList;

import pulgas.products.Shampoo;
import pulgas.products.Toy;
import pulgas.utils.RandGen;

public class Stock {

    private LinkedList<Shampoo> shampoos;
    private LinkedList<Toy> toys;
    private int money;

    public Stock(RandGen randGen) {
        shampoos = new LinkedList<>();
        generateRandomStock(randGen);
    }

    private void generateRandomStock (RandGen randGen) {
        while (randGen.happens(101, 25)) {
            shampoos.add(Shampoo.random(randGen));
        }
        for (int i = 0; i < 5; i++) if (randGen.happens(0, 101, 45 - (i * 8))) toys.add(Toy.random(randGen));
        if (shampoos.size() < 2) generateRandomStock(randGen);
    }

    public LinkedList<Shampoo> getShampoos() { return shampoos; }
    public LinkedList<Toy> getToys() { return toys; }
    public int getMoney() { return money; }

    public void addMoney (int amount) {
        money += money;
    }
}
