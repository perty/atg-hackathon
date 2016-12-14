package se.atg.hackathon.fixtures.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import se.atg.hackathon.fixtures.exception.StopTestException;

import java.io.IOException;

public class RestCall<T> {

    private Class<T> tClass;

    public RestCall(Class<T> tClass) {
        this.tClass = tClass;
    }

    public T get(String path) {
        try {
            return new ObjectMapper().readValue(new RestTemplate().getForObject(path, String.class), tClass);
        } catch (ResourceAccessException | IOException exception) {
            throw new StopTestException(exception.getMessage(), exception);
        }
    }

    public void post(String path) {
        try {
            String forObject = new RestTemplate().getForObject(path, String.class);
        } catch (ResourceAccessException exception) {
            throw new StopTestException(exception.getMessage(), exception);
        }
    }

}
