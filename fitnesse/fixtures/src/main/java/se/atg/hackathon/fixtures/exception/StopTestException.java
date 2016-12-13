package se.atg.hackathon.fixtures;

import org.springframework.web.client.ResourceAccessException;

public class StopTestException extends RuntimeException {
    public StopTestException(String message) {
        super(makeFitNesseMessage(message));
    }

    public StopTestException(String message, Exception exception) {
        super(makeFitNesseMessage(message), exception);
    }

    private static String makeFitNesseMessage(String message) {
        return "message:<<" + message + ">>";
    }
}
