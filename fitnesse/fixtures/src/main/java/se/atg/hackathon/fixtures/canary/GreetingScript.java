package se.atg.hackathon.fixtures.canary;

import se.atg.hackathon.fixtures.Environment;
import se.atg.hackathon.fixtures.exception.StopTestException;
import se.atg.hackathon.fixtures.util.RestCall;

import java.util.Properties;

import static java.lang.String.format;

@SuppressWarnings("unused")
public class GreetingScript {

    private static final String BETTING_SERVICE_NAME = "Betting";
    private static final String HOST = "host";
    private static final String PORT = "port";

    private String greetingContent;
    private String hostName;
    private String port;

    public GreetingScript() {
        setUpProperties();
    }

    public boolean getGreeting() {
        greetingContent = "";
        Greeting greeting = getRestGreeting();
        greetingContent = greeting.getContent();
        return true;
    }

    public boolean getGreetingFor(String name) {
        greetingContent = "";
        Greeting greeting = getRestGreeting(name);
        greetingContent = greeting.getContent();
        return true;
    }

    public String greetingContentIs() {
        return greetingContent;
    }

    private Greeting getRestGreeting(String name) {
        return new RestCall<>(Greeting.class).get(format("http://%s:%s/greeting?name=%s", hostName, port, name));
    }

    private Greeting getRestGreeting() {
        return new RestCall<>(Greeting.class).get(format("http://%s:%s/greeting", hostName, port));
    }

    private void setUpProperties() {
        setHostName(getEnvironmentProperties());
        setPort(getEnvironmentProperties());
    }

    private Properties getEnvironmentProperties() {
        Properties properties = Environment.getEnvironmentProperties(BETTING_SERVICE_NAME);
        if (properties == null) {
            foundNoServiceProperties();
        }
        return properties;
    }

    private void foundNoServiceProperties() {
        throw new StopTestException("Betting service has no set up, use '" + BETTING_SERVICE_NAME + "'");
    }

    private void setHostName(Properties properties) {
        hostName = (String) properties.get(HOST);
        if (hostName == null) {
            throw new StopTestException("Betting service has no host set up");
        }
    }

    private void setPort(Properties properties) {
        port = (String) properties.get(PORT);
        if (port == null) {
            throw new StopTestException("Betting service has no port set up");
        }
    }

}
