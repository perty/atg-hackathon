package se.atg.hackathon.fixtures;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SuppressWarnings("unused")
public class Environment {
    private static Map<String, Properties> environmentProperties = new HashMap<>();
    private String lastServiceName;

    public boolean setServiceName(String serviceName) {
        environmentProperties.put(serviceName, new Properties());
        lastServiceName = serviceName;
        return true;
    }

    public boolean setHost(String host) {
        Properties properties = environmentProperties.get(lastServiceName);
        properties.setProperty("host", host);
        return true;
    }

    public boolean setPort(String port) {
        Properties properties = environmentProperties.get(lastServiceName);
        properties.setProperty("port", port);
        return true;
    }

    public static Properties getEnvironmentProperties(String serviceName) {
        return environmentProperties.get(serviceName);
    }
}
