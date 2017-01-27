package se.atg.hackathon.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WalletApplication {

	WalletApplication() {
		// For no use
	}

	public static void main(String[] args) {
		SpringApplication.run(WalletApplication.class, args);
	}
}
