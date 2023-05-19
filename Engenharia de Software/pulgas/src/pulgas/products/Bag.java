package pulgas.products;

import java.util.Optional;

public class Bag {
    private Optional<Shampoo> product;
    private int amount;

    private Bag(Optional<Shampoo> product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Bag(Shampoo product, int amount) {
        this (
            Optional.of(product),
            amount
        );
    }

    public static final Bag empty() {
        return new Bag(Optional.empty(), 0);
    }

    public Optional<Shampoo> getProduct() { return product; }
    public int getAmount() { return amount; }

    public void setProduct(Shampoo product) { this.product = Optional.of(product); }
    public void setAmount(int amount) { this.amount = amount; }
}
