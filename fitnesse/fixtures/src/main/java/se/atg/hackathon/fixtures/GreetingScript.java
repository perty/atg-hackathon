package se.atg.hackathon.fixtures;

import java.util.Properties;

@SuppressWarnings("unused")
public class BettingScript {

    private static final String BETTING_SERVICE_NAME = "Betting";
    private static final String HOST = "host";
    private static final String PORT = "port";

    private String greetingContent;
    private final String hostName;
    private final String port;

    public BettingScript() {
        Properties properties = Environment.getEnvironmentProperties(BETTING_SERVICE_NAME);
        if(properties == null) {
            foundNoServiceProperties();
        }
        hostName = (String) properties.get(HOST);
        if (hostName == null) {
            foundNoHostName();
        }
        port = (String) properties.get(PORT);
        if (port == null) {
            foundNoPort();
        }
    }

    public void getGreeting() {
        greetingContent = "";
        
    }

    public void getGreetingFor(String name) {
        greetingContent = "";
    }

    public String greetingContentIs() {
        return greetingContent;
    }

    private void foundNoServiceProperties() {
        throw new StopTestException("Betting service has no set up, use '" + BETTING_SERVICE_NAME + "'");
    }

    private void foundNoHostName() {
        throw new StopTestException("Betting service has no host set up");
    }

    private void foundNoPort() {
        throw new StopTestException("Betting service has no port set up");
    }
}
