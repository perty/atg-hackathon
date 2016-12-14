package se.atg.hackathon.spring.wallet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WalletController {

    private Map<String, Wallet> wallets = new HashMap<>();

    @RequestMapping("/createWallet")
    public Wallet greeting(@RequestParam(value = "name", defaultValue = "invalid") String name,
                           @RequestParam(value = "age", defaultValue = "0") Integer age,
                           @RequestParam(value = "userName", defaultValue = "invalid") String userName) {
        Wallet wallet = new Wallet(name, age, userName, new Balance());
        wallets.put(userName, wallet);
        return wallet;
    }


    @RequestMapping("/balance")
    public Balance getBalance(@RequestParam(value = "userName") String userName) {
        Wallet wallet = wallets.get(userName);
        if (wallet == null) {
            return new Balance();
        }
        return wallet.getBalance();
    }


    @RequestMapping("/deposit")
    public void deposit(@RequestParam(value = "userName") String userName,
                           @RequestParam(value = "amount") Integer amount) {
        Wallet wallet = wallets.get(userName);
        if (wallet != null) {
            wallet.getBalance().value += amount;
        }

    }
}