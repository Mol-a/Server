package condorcet.Models;

public class TransferModel {
    private int from_number;
    private int to_number;
    private int amount;

    public TransferModel(){}

    public TransferModel(int from_number, int to_number, int amount) {
        this.from_number = from_number;
        this.to_number = to_number;
        this.amount = amount;
    }

    public int getFrom_number() {
        return from_number;
    }

    public void setFrom_number(int from_number) {
        this.from_number = from_number;
    }

    public int getTo_number() {
        return to_number;
    }

    public void setTo_number(int to_number) {
        this.to_number = to_number;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
