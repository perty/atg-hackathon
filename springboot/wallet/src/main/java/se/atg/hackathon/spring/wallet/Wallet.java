package se.atg.hackathon.spring.wallet;

@SuppressWarnings("WeakerAccess")
public class Wallet {
    private final String name;
    private final Integer age;
    private final String userName;
    private Balance balance;

    public Wallet(String name, Integer age, String userName, Balance balance) {
        this.name = name;
        this.age = age;
        this.userName = userName;
        this.balance = balance;
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
}
