package org.example;

import java.util.Objects;

public class User {

    private final String login;
    private final String email;
    public static final String DEFAULT_VALUE_LOGIN = "defaultLogin";
    public static final String DEFAULT_VALUE_EMAIL = "default@default.default";


    public User(String login, String email) {

        if (login.equals(email)) {
            throw new IllegalArgumentException("Логин и email не должны быть равны");
        }

        if (!login.isBlank()) {
            this.login = login;
        } else {
            this.login = DEFAULT_VALUE_LOGIN;
        }

        if (email.isBlank()) {
            this.email = DEFAULT_VALUE_EMAIL;
        } else if (email.contains("@")
                && email.contains(".")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Некорректный email");
        }
    }

    public User() {
        this(DEFAULT_VALUE_LOGIN, DEFAULT_VALUE_EMAIL);
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
