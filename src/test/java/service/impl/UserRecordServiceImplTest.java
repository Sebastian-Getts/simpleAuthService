package service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.UserRecordService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sebastiangetts
 */
class UserRecordServiceImplTest {

    UserRecordService userRecordService;

    @BeforeEach
    void initUserInfo() {
        userRecordService = new UserRecordServiceImpl();
        userRecordService.createUser("Alice", "123");
    }

    @Test
    void createUser() {
    }

    @Test
    void deleteUser() {
        // given
        // then
        assertTrue(userRecordService.deleteUser("Alice"));
        assertFalse(userRecordService.deleteUser("Bob"));
    }

    @Test
    void checkUserNameIsValid() {
        // given
        // then
        assertTrue(userRecordService.checkUserNameIsValid("Alice"));
        assertFalse(userRecordService.checkUserNameIsValid("Bob"));
    }

    @DisplayName("when password is the same as before, token should be the same")
    @Test
    void checkUserNamePasswordIsValid() {
        // given
        // then
        assertTrue(userRecordService.checkUserNamePasswordIsValid("Alice", "123"));
        assertFalse(userRecordService.checkUserNamePasswordIsValid("Alice", "1234"));
    }
}