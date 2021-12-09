package condorcet.Models.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * mysql> CREATE TABLE `credit` (
 *     ->   `id` int NOT NULL,
 *     ->   `average_account` double NOT NULL,
 *     ->   `credit_loans` int DEFAULT NULL,
 *     ->   PRIMARY KEY (`id`)
 *     -> ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
 */
@Entity
@Table(name = "credit")
public class Credit {
    private int id;
    private double averageAccount;
    private int creditLoans;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "average_account")
    public double getAverageAccount() {
        return averageAccount;
    }

    public void setAverageAccount(double averageAccount) {
        this.averageAccount = averageAccount;
    }
    @Column(name = "credit_loans")
    public int getCreditLoans() {
        return creditLoans;
    }

    public void setCreditLoans(int creditLoans) {
        this.creditLoans = creditLoans;
    }
}
