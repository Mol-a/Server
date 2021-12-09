package condorcet.Models.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {
    private int id;
    private int account_number;
    private double amount;
    private String open_date;
    private String close_date;
    private Client client;
    private transient Set<Deposit> deposit = new HashSet<>();
    private transient Set<Card> card = new HashSet<>();

    public Account(){}

    public Account(int id, int account_number, double amount, String open_date, String close_date, Client client, Set<Deposit> deposit, Set<Card> card) {
        this.id = id;
        this.account_number = account_number;
        this.amount = amount;
        this.open_date = open_date;
        this.close_date = close_date;
        this.client = client;
        this.deposit = deposit;
        this.card = card;
    }

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "account_number")
    public int getAccount_number() {
        return account_number;
    }
    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "open_date")
    public String getOpen_date() {
        return open_date;
    }
    public void setOpen_date(String open_date) {
        this.open_date = open_date;
    }

    @Column(name = "close_date")
    public String getClose_date() {
        return close_date;
    }
    public void setClose_date(String close_date) {
        this.close_date = close_date;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    public Set<Deposit> getDeposit() {
        return deposit;
    }
    public void setDeposit(Set<Deposit> deposit) {
        this.deposit = deposit;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    public Set<Card> getCard() {
        return card;
    }
    public void setCard(Set<Card> card) {
        this.card = card;
    }
}
