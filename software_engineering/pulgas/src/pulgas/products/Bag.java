package pulgas.products;

import java.util.Optional;

public class Bag {
    private Optional<Product> product;
    private int amount;

    private Bag(Optional<Product> product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Bag(Product product, int amount) {
        this (
            Optional.of(product),
            amount
        );
    }

    public static final Bag empty() {
        return new Bag(Optional.empty(), 0);
    }

    public Optional<Product> getProduct() { return product; }
    public int getAmount() { return amount; }

    public void setProduct(Product product) { this.product = Optional.of(product); }
    public void setAmount(int amount) { this.amount = amount; }
}
