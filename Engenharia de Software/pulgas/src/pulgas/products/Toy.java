package pulgas.products;

public class Toy extends Product {

    private double fun;

    public Toy (String name, int price, int uses, double fun) {
        super(name, price, uses);
        this.fun = fun;
    }

    public double getFun() { return fun; }
}
