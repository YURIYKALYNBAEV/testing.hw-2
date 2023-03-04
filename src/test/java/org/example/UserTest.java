package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
    private User user;
    private User user1;

    @BeforeEach
    public void setUp() {
        user = new User("Ivanov", "Ivanov@mail.ru");
        user1 = new User();
    }

    @Test
    void shouldAddNewUserWithParameters() {
        User actualUser = new User("Ivanov", "Ivanov@mail.ru");
        Assertions.assertEquals(user.getLogin(), actualUser.getLogin());
        Assertions.assertEquals(user.getEmail(), actualUser.getEmail());
    }

    @Test
    void shouldAddNewUserWithoutParameters() {
        User actualUser = new User();
        Assertions.assertEquals(user1.getLogin(), actualUser.getLogin());
        Assertions.assertEquals(user1.getEmail(), actualUser.getEmail());
    }

    @Test
    void shouldCheckEmail() {
        User actualUser = new User("Ivanov", "Ivanov@mail.ru");
        Assertions.assertEquals(user.getEmail(), actualUser.getEmail());
    }

    @Test
    void shouldCheckOnEqualityLoginEmail() {
        User actualUser = new User("Ivanov", "Ivanov@mail.ru");
        Assertions.assertEquals(user, actualUser);
    }
}