package pulgas.products;

public class ProductData {
    private Product product;
    private int stock;    
    private int daysInStock;

    public ProductData(Product product, int stock) {
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

    public Product getProduct() { return product; }

    public int getStock() { return stock; }
    public int getDaysInStock() { return daysInStock; }
}

