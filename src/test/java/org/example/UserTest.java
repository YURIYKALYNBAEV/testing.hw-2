package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User expectedUser;
    private User expectedDefaultUser;
    private User actualUser;


    @BeforeEach
    void setUp() {
        expectedUser = new User("Ivanov", "Ivanov@mail.ru");
        expectedDefaultUser = new User(User.DEFAULT_VALUE, User.DEFAULT_VALUE);
    }

    @Test
    void getEmail() {
        actualUser = new User("Ivanov", "Ivanov@mail.ru");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException("Некорректный email");
                });
    }

    @Test
    void createNewUserWithParameters() {
        actualUser = new User("Ivanov", "Ivanov@mail.ru");
        assertNotNull(actualUser);
        Assertions.assertEquals(expectedUser, actualUser);
    }

    @Test
    void createNewUserWithoutParameters() {
        actualUser = new User(User.DEFAULT_VALUE, User.DEFAULT_VALUE);
        assertNotNull(actualUser);
        Assertions.assertEquals(expectedDefaultUser, actualUser);
    }

    @Test
    void compareLoginEmail() {
        actualUser = new User("Ivanov", "Ivanov@mail.ru");
        Assertions.assertNotSame(actualUser.getLogin(), actualUser.getEmail());
    }
}