package pulgas.data;

public class AcceptedContract {
    private Contract contract;
    private int initialHappiness;
    private int dayCount;

    public AcceptedContract(Contract contract) {
        this.contract = contract;
        initialHappiness = contract.getDog().getHappiness();
        dayCount = 0;
    }

    public boolean count () {
        dayCount++;
        return dayCount >= contract.getDays();
    }

    public ContractResult getResult () {
        return new ContractResult(
            contract.getBasePayment(),
            initialHappiness,
            contract.getDog().getHappiness()
        );
    }

    public int getDayCount() { return dayCount; }
    public String getOwner() { return contract.getOwner(); }
}
