package pulgas.data;

import pulgas.entities.Dog;
import pulgas.utils.Names;
import pulgas.utils.RandGen;

public class Contract {

    private String owner;
    private Dog dog;
    private int days;
    private int basePayment;

    public Contract(String owner, Dog dog, int days, int basePayment) {
        this.owner = owner;
        this.dog = dog;
        this.days = days;
        this.basePayment = basePayment;
    }

    public static Contract random(RandGen randGen) {
        Dog dog = new Dog(randGen);
        return new Contract(
            Names.RandomName(randGen),
            dog,
            randGen.randInt(1, 10),
            randGen.randInt(50, 60 + 1000 * (dog.getHappiness() / 100))
        );
    }

    public static Contract[] randomArray (RandGen randGen) { return randomArray(randGen, 0); }
    public static Contract[] randomArray (RandGen randGen, int currentCount) {
        if (randGen.happens(0, 100, 30)) return randomArray(randGen, currentCount + 1);
        Contract[] contracts = new Contract[currentCount];
        for (int i = 0; i < currentCount; i++) {
            contracts[i] = Contract.random(randGen);
        }
        return contracts;
    }

    public String getOwner() { return owner; }
    public Dog getDog() { return dog; }
    public int getDays() { return days; }
    public int getBasePayment() { return basePayment; }
    
}
