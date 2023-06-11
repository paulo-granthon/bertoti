package pulgas.products;

import pulgas.utils.RandGen;

public class Product {

    protected String name;
    protected int price;
    protected int uses;

    public Product(String name, int price, int uses) {
        this.name = name;
        this.price = price;
        this.uses = uses;
    }

    public static Product randomProduct (RandGen randGen) {
        return randGen.happens(0, 101, 50) ? Shampoo.random(randGen) : Toy.random(randGen);
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getUses() { return uses; }

    // public void setName(String name) { this.name = name; }
    // public void setPrice(int price) { this.price = price; }
    // public void setUses(int uses) { this.uses = uses; }
}
