package pulgas.products;

public class ProductData {
    private Shampoo product;
    private int stock;    
    private int daysInStock;

    public ProductData(Shampoo product, int stock) {
        this.product = product;
        this.stock = stock;
    }

    public void update () {
        daysInStock += 1;
    }

    public int sell (int amount) {
        int sold = Math.min(stock, amount);
        stock -= sold;
        return sold;
    }

    public void reStock (int amount) {
        stock += amount;
        daysInStock = 0;
    }

    public String getName () { return product.getName(); }

    public Shampoo getProduct() { return product; }

    public int getStock() { return stock; }
    public int getDaysInStock() { return daysInStock; }
}

