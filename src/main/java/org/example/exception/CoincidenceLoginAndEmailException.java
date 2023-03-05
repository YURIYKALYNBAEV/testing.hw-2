package org.example.exception;

public class CoincidenceLoginAndEmailException extends Exception {
    private final String argument;

    public CoincidenceLoginAndEmailException (String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }

    @Override
    public String getMessage() {
        return "Почта '" + argument + "' задана некорректно";
    }
}
