package service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.AuthManagerService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sebastiangetts
 */
class AuthManagerServiceImplTest {

    AuthManagerService authManagerService;

    @BeforeEach
    void setUp() {
        authManagerService = new AuthManagerServiceImpl();
    }

    @Test
    void generateToken() {
        // when
        String token = authManagerService.generateToken("Alice", LocalDateTime.now());
        // then
        assertNotEquals("", token);
    }

    @Test
    void getUserNameByToken() {
        // given
        String token = authManagerService.generateToken("Bob", LocalDateTime.now());
        // when
        String username1 = authManagerService.getUserNameByToken(token, LocalDateTime.now());
        String username2 = authManagerService.getUserNameByToken(token, LocalDateTime.now().plus(3, ChronoUnit.HOURS));
        // then
        assertEquals("Bob", username1);
        assertEquals("", username2);
    }

    @Test
    void invalidateToken() {
        // given
        String token = authManagerService.generateToken("Alice", LocalDateTime.now());
        // when
        authManagerService.invalidateToken(token);
        // then
        assertEquals("", authManagerService.getUserNameByToken(token, LocalDateTime.now()));
    }
}