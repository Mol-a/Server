package condorcet.Models.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    private int id;
    private String surname;
    private String first_name;
    private String middle_name;
    private String date_of_birth;
    private String pass_series;
    private String pass_number;
    private String authority;
    private String date_of_issue;
    private String inden_number;
    private String place_of_birth;
    private String address;
    private String home_phone;
    private String mobile_phone;
    private String email;
    private String place_of_work;
    private String position;
    private String address_of_registration;
    private String marital_status;
    private String disability;
    private String retiree;
    private double month_income;
    private String liable;
    private PersonData personData;
    private transient Set<Account> accounts = new HashSet<>();

    public Client(){}

    public Client(int id, String surname, String first_name, String middle_name, String date_of_birth, String pass_series, String pass_number, String authority, String date_of_issue, String inden_number, String place_of_birth, String address, String home_phone, String mobile_phone, String email, String place_of_work, String position, String address_of_registration, String marital_status, String disability, String retiree, double month_income, String liable, PersonData personData, Set<Account> accounts) {
        this.id = id;
        this.surname = surname;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.date_of_birth = date_of_birth;
        this.pass_series = pass_series;
        this.pass_number = pass_number;
        this.authority = authority;
        this.date_of_issue = date_of_issue;
        this.inden_number = inden_number;
        this.place_of_birth = place_of_birth;
        this.address = address;
        this.home_phone = home_phone;
        this.mobile_phone = mobile_phone;
        this.email = email;
        this.place_of_work = place_of_work;
        this.position = position;
        this.address_of_registration = address_of_registration;
        this.marital_status = marital_status;
        this.disability = disability;
        this.retiree = retiree;
        this.month_income = month_income;
        this.liable = liable;
        this.personData = personData;
        this.accounts = accounts;
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

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "first_name")
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Column(name = "middle_name")
    public String getMiddle_name() {
        return middle_name;
    }
    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    @Column(name = "date_of_birth")
    public String getDate_of_birth() {
        return date_of_birth;
    }
    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Column(name = "pass_series")
    public String getPass_series() {
        return pass_series;
    }
    public void setPass_series(String pass_series) {
        this.pass_series = pass_series;
    }

    @Column(name = "pass_number")
    public String getPass_number() {
        return pass_number;
    }
    public void setPass_number(String pass_number) {
        this.pass_number = pass_number;
    }

    @Column(name = "authority")
    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Column(name = "date_of_issue")
    public String getDate_of_issue() {
        return date_of_issue;
    }
    public void setDate_of_issue(String date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    @Column(name = "inden_number")
    public String getInden_number() {
        return inden_number;
    }
    public void setInden_number(String inden_number) {
        this.inden_number = inden_number;
    }

    @Column(name = "place_of_birth")
    public String getPlace_of_birth() {
        return place_of_birth;
    }
    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "home_phone")
    public String getHome_phone() {
        return home_phone;
    }
    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    @Column(name = "mobile_phone")
    public String getMobile_phone() {
        return mobile_phone;
    }
    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "place_of_work")
    public String getPlace_of_work() {
        return place_of_work;
    }
    public void setPlace_of_work(String place_of_work) {
        this.place_of_work = place_of_work;
    }

    @Column(name = "position")

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "address_of_registration")
    public String getAddress_of_registration() {
        return address_of_registration;
    }
    public void setAddress_of_registration(String address_of_registration) {
        this.address_of_registration = address_of_registration;
    }

    @Column(name = "marital_status")
    public String getMarital_status() {
        return marital_status;
    }
    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    @Column(name = "disability")
    public String isDisability() {
        return disability;
    }
    public void setDisability(String disability) {
        this.disability = disability;
    }

    @Column(name = "retiree")
    public String isRetiree() {
        return retiree;
    }
    public void setRetiree(String retiree) {
        this.retiree = retiree;
    }

    @Column(name = "month_income")
    public double getMonth_income() {
        return month_income;
    }
    public void setMonth_income(double month_income) {
        this.month_income = month_income;
    }

    @Column(name = "liable")
    public String isLiable() {
        return liable;
    }
    public void setLiable(String liable) {
        this.liable = liable;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="person_data_id")
    public condorcet.Models.Entities.PersonData getPersonData() {
        return personData;
    }
    public void setPersonData(condorcet.Models.Entities.PersonData personData) {
        this.personData = personData;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    public Set<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
