package ca.gbc.comp3095.assignment1.service;

public class AppUserNotFoundException extends Throwable {
    public AppUserNotFoundException(String message) {
        super(message);
    }
}
