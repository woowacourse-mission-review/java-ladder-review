package laddergame.domain.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UserTest {

    @Test
    void valid_user() {
        assertDoesNotThrow(() -> User.of("conas", 0));
    }
}
