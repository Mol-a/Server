package condorcet.Models.Entities;

import javax.persistence.*;

@Entity
@Table(name = "deposit")
public class Deposit {
    private int id;
    private int deposit_number;
    private String deposit_name;
    private int storageTime;
    private double interestRate;
    private String rateType;
    private String ammount_operation;
    private String responceName;
    private Account account;

    public Deposit(){}

    public Deposit(int id, int deposit_number, String deposit_name, int storageTime, double interestRate, String rateType, String ammount_operation, String responceName, Account account) {
        this.id = id;
        this.deposit_number = deposit_number;
        this.deposit_name = deposit_name;
        this.storageTime = storageTime;
        this.interestRate = interestRate;
        this.rateType = rateType;
        this.ammount_operation = ammount_operation;
        this.responceName = responceName;
        this.account = account;
    }

    @javax.persistence.Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "deposit_number")
    public int getDeposit_number() {
        return deposit_number;
    }
    public void setDeposit_number(int deposit_number) {
        this.deposit_number = deposit_number;
    }

    @Column(name = "deposit_name")
    public String getDeposit_name() {
        return deposit_name;
    }
    public void setDeposit_name(String deposit_name) {
        this.deposit_name = deposit_name;
    }

    @Column(name = "storageTime")
    public int getstorageTime() {
        return storageTime;
    }
    public void setstorageTime(int storageTime) {
        this.storageTime = storageTime;
    }

    @Column(name = "interestRate")
    public double getinterestRate() {
        return interestRate;
    }
    public void setinterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Column(name = "rateType")
    public String getrateType() {
        return rateType;
    }
    public void setrateType(String rateType) {
        this.rateType = rateType;
    }

    @Column(name = "amount_operation")
    public String getAmmount_operation() {
        return ammount_operation;
    }
    public void setAmmount_operation(String ammount_operation) {
        this.ammount_operation = ammount_operation;
    }

    @Column(name = "responceName")
    public String getresponceName() {
        return responceName;
    }
    public void setresponceName(String responceName) {
        this.responceName = responceName;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deposit_id")
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
}
