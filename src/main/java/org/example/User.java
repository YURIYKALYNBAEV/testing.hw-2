package org.example;

import java.util.Objects;

import static java.util.Objects.isNull;

public class User {


    private String login;
    private String email;
    public static final String DEFAULT_VALUE = "default";

    public User(String login, String email) {

        if (login != null || !login.isBlank()) {
            this.login = login;
        } else {
            this.login = DEFAULT_VALUE;
        }
        if (email != null || !email.isBlank()
                && (email.contains("@)")
                || email.contains("."))) {
            this.email = email;
        } else if (!email.contains("@)")
                || !email.contains(".")) {
            throw new IllegalArgumentException("некорректный email");

        } else if (email == null || email.isBlank()) {
            this.email = DEFAULT_VALUE;
        }
    }


    public User() {
        this.login = DEFAULT_VALUE;
        this.email = DEFAULT_VALUE;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
