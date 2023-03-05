package org.example.exception;

public class IllegalEmailException extends Exception {
    private final String argument;

    public IllegalEmailException (String argument) {
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
