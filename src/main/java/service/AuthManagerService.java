package service;

import java.time.LocalDateTime;

/**
 * @author sebastiangetts
 */
public interface AuthManagerService {

    /**
     * generate token by username
     * @param userName username
     * @param currentTime current time, LocalDateTime type
     * @return token
     */
    String generateToken(String userName, LocalDateTime currentTime);

    /**
     * get username by token
     * @param token token
     * @param currentTime current time, LocalDateTime type
     * @return username or empty string if token is expired.
     */
    String getUserNameByToken(String token, LocalDateTime currentTime);

    /**
     * make current token expired
     * @param token token
     */
    void invalidateToken(String token);
}
