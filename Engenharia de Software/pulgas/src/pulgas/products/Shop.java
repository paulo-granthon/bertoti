package pulgas.products;

import java.util.LinkedList;
import java.util.List;

import pulgas.utils.RandGen;

public class Shop {
    
    public List<ProductData> products;
    
    public Shop (RandGen randGen) {
        products = new LinkedList<>();
        generateRandomStock(randGen);
    }

    private void generateRandomStock (RandGen randGen) {
        while (randGen.happens(101, 25)) {
            addRandomProduct(randGen);
        }
        if (products.size() < 2) generateRandomStock(randGen);
    }

    public void addProduct (ProductData product) {
        products.add(product);
    }

    public void addRandomProduct (RandGen randGen) {
        addProduct(new ProductData(
            Product.randomProduct(randGen),
            randGen.randInt(1, 5)
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
