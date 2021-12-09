package condorcet.DepositList;

public class DepositList {
    private int deposit_number;
    private String deposit_name;
    private int storageTime;
    private double interestRate;
    private String rateType;
    private String amount_operation;
    private String responceName;
    public DepositList(){}

    public DepositList(int deposit_number, String deposit_name, int storageTime, double interestRate, String rateType, String amount_operation, String responceName) {
        this.deposit_number = deposit_number;
        this.deposit_name = deposit_name;
        this.storageTime = storageTime;
        this.interestRate = interestRate;
        this.rateType = rateType;
        this.amount_operation = amount_operation;
        this.responceName = responceName;
    }

    public int getDeposit_number() {
        return deposit_number;
    }

    public void setDeposit_number(int deposit_number) {
        this.deposit_number = deposit_number;
    }

    public String getDeposit_name() {
        return deposit_name;
    }

    public void setDeposit_name(String deposit_name) {
        this.deposit_name = deposit_name;
    }

    public int getstorageTime() {
        return storageTime;
    }

    public void setstorageTime(int storageTime) {
        this.storageTime = storageTime;
    }

    public double getinterestRate() {
        return interestRate;
    }

    public void setinterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getrateType() {
        return rateType;
    }

    public void setrateType(String rateType) {
        this.rateType = rateType;
    }

    public String getAmount_operation() {
        return amount_operation;
    }

    public void setAmount_operation(String amount_operation) {
        this.amount_operation = amount_operation;
    }

    public String getresponceName() {
        return responceName;
    }

    public void setresponceName(String responceName) {
        this.responceName = responceName;
    }
}
