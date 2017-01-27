package se.atg.hackathon.fixtures;

import se.atg.hackathon.fixtures.exception.StopTestException;
import se.atg.hackathon.fixtures.util.RestCall;

import java.util.Properties;

import static java.lang.String.format;


@SuppressWarnings("unused")
public class WalletScript {

    private static final String SERVICE_NAME = "Wallet";
    private static final String HOST_NAME_PROPERTY = "host";
    private static final String PORT_PROPERTY = "port";
    private String hostName;
    private String port;

    public WalletScript() {
        setUpProperties();
    }

    public boolean createWalletForOfAgeWithUserIs(String name, Integer age, String userName) {
        String path = format("http://%s:%s/createWallet?name=%s&age=%d&userName=%s", hostName, port, name, age, userName);
        new RestCall<>(Wallet.class).get(path);
        return true;
    }

    public Long walletOfHasBalance(String userName) {
        String path = format("http://%s:%s/balance?userName=%s", hostName, port, userName);
        Balance balance = new RestCall<>(Balance.class).get(path);
        return balance.value;
    }

    public boolean depositIntoWalletOf(Integer amount, String userName) {
        String path = format("http://%s:%s/deposit?userName=%s&amount=%d", hostName, port, userName, amount);
        new RestCall<>(String.class).post(path);
        return true;
    }

    private void setUpProperties() {
        setHostName(getEnvironmentProperties());
        setPort(getEnvironmentProperties());
    }

    private Properties getEnvironmentProperties() {
        Properties properties = Environment.getEnvironmentProperties(SERVICE_NAME);
        if (properties == null) {
            foundNoServiceProperties();
        }
        return properties;
    }

    private void foundNoServiceProperties() {
        throw new StopTestException("Wallet service has no set up, use '" + SERVICE_NAME + "'");
    }

    private void setHostName(Properties properties) {
        hostName = (String) properties.get(HOST_NAME_PROPERTY);
        if (hostName == null) {
            throw new StopTestException("Wallet service has no host set up");
        }
    }

    private void setPort(Properties properties) {
        port = (String) properties.get(PORT_PROPERTY);
        if (port == null) {
            throw new StopTestException("Wallet service has no port set up");
        }
    }
}
