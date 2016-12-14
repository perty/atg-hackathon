package se.atg.hackathon.fixtures;

public class Wallet {
    private String name;
    private Integer age;
    private String userName;
    private Balance balance;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getUserName() {
        return userName;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}
