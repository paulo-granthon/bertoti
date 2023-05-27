package pulgas.data;

public class ContractResult {

    private int reputation;
    private int payment;
    
    public ContractResult(int basePayment, int initialHappiness, int finalHappiness) {
        double happinessFactor = (double)(initialHappiness - finalHappiness);
        this. reputation = ((Double)(happinessFactor * 100)).intValue();
        this. payment = ((Double)((basePayment / 2.0) + ((basePayment / 2.0) * (happinessFactor / 100.0)))).intValue();
    }

    public int getPayment () { return payment; }
    public int getReputation() { return reputation; }

}
