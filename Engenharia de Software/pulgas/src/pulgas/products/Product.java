package pulgas.products;

public class Product {

    private String name;
    private int price;
    private int uses;

    public Product(String name, int price, int uses) {
        this.name = name;
        this.price = price;
        this.uses = uses;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getUses() { return uses; }

    // public void setName(String name) { this.name = name; }
    // public void setPrice(int price) { this.price = price; }
    // public void setUses(int uses) { this.uses = uses; }
}
