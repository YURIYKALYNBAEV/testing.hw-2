package org.example;

import org.example.exception.CoincidenceLoginAndEmailException;
import org.example.exception.IllegalEmailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class UserTest {
    public static final String DEFAULT_LOGIN = "defaultLogin";
    public static final String DEFAULT_EMAIL = "default@default.default";
    public static final String VALID_LOGIN = "Ivanov";
    public static final String VALID_EMAIL = "Ivanov@mail.ru";
    public static final String ILLEGAL_EMAIL = "Ivanov.ru";
    public static final String LOGIN_EQUALS_EMAIL = "Ivanov@mail.ru";

    @Test
    @DisplayName("Пользователь успешно создан и поля проинициализированы")
    void shouldCreateNewUserWithAllArgs() throws IllegalEmailException, CoincidenceLoginAndEmailException {
        User user = new User(VALID_LOGIN, VALID_EMAIL);
        Assertions.assertEquals(VALID_LOGIN, user.getLogin());
        Assertions.assertEquals(VALID_EMAIL, user.getEmail());
    }

    @Test
    @DisplayName("Пользователь успешно создан без параметров и поля проинициализированы дефолтными значениями")
    void shouldCreateNewUserWithNoArgs() throws IllegalEmailException, CoincidenceLoginAndEmailException {
        User user = new User();
        Assertions.assertEquals(DEFAULT_LOGIN, user.getLogin());
        Assertions.assertEquals(DEFAULT_EMAIL, user.getEmail());
    }

    @Test
    @DisplayName("Выброс ошибки при создании пользователя с некорректной почтой")
    void shouldThrowIllegalEmailExceptionWhenCreatingUser() {
        Assertions.assertThrows(IllegalEmailException.class, () -> new User(VALID_LOGIN, ILLEGAL_EMAIL));
    }

    @Test
    @DisplayName("Выброс ошибки в случае, если логин и почта совпадают")
    void shouldThrowCoincidenceLoginAndEmailExceptionWhenSetupLoginSameToEmail()
            throws CoincidenceLoginAndEmailException, IllegalEmailException {
        Assertions.assertThrows(CoincidenceLoginAndEmailException.class,
                () -> new User(VALID_LOGIN, VALID_LOGIN));
        Assertions.assertThrows(CoincidenceLoginAndEmailException.class,
                () -> new User(VALID_EMAIL, VALID_EMAIL));
    }
}