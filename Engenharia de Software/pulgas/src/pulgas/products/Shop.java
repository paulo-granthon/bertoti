package pulgas.products;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Shop {
    
    public List<ProductData> products;
    
    public Shop (Random random) {
        products = new LinkedList<>();
        generateRandomStock(random);
    }

    private void generateRandomStock (Random random) {
        while (random.nextInt(101) < 25) {
            addRandomProduct(random);
        }
        if (products.size() < 2) generateRandomStock(random);
    }

    public void addProduct (ProductData product) {
        products.add(product);
    }

    public void addRandomProduct (Random random) {
        addProduct(new ProductData(
            Shampoo.random(random),
            (random.nextInt() % 4) + 1
        ));
    }

    public Bag buyProduct (int index, int count) {
        if (index < 0 || index >= products.size()) return Bag.empty();
        ProductData product = products.get(index);
        int amount = product.sell(count);
        return new Bag(product.getProduct(), amount);
    }

    public List<ProductData> getProducts() { return products; }

}
