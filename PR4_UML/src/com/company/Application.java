package com.company;

public class Application {
    private String message;
    private Man from;

    public Application(String message, Man from) {
        this.message = message;
        this.from = from;
    }

    public String toString() {
        return (String.format("Application. From %s %s. Message:\n%s",
                from.name, from.surname, message));
    }
}
