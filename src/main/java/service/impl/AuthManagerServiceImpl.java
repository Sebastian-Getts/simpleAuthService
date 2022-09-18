package service.impl;

import service.AuthManagerService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author sebastiangetts
 */
public class AuthManagerServiceImpl implements AuthManagerService {

    /**
     * time to leave
     */
    private final int ttl;

    /**
     * standard set of date period units
     */
    private final ChronoUnit chronoUnit;
    /**
     * to record token and validTime
     */
    private final Map<String, LocalDateTime> tokenTimeMap;

    /**
     * to record token and username
     */
    private final Map<String, String> tokenUserMap;

    public AuthManagerServiceImpl(int timeToLive, ChronoUnit chronoUnit) {
        this.ttl = timeToLive;
        this.chronoUnit = chronoUnit;
        this.tokenTimeMap = new HashMap<>();
        tokenUserMap = new HashMap<>();
    }

    @Override
    public String generateToken(String userName, LocalDateTime currentTime) {
        String tokenId = UUID.randomUUID().toString();
        tokenUserMap.put(tokenId, userName);
        tokenTimeMap.put(tokenId, currentTime.plus(ttl, chronoUnit));

        return tokenId;
    }

    @Override
    public String getUserNameByToken(String token, LocalDateTime currentTime) {
        if (tokenTimeMap.get(token) == null || tokenTimeMap.get(token).isBefore(currentTime)) {
            return "";
        }

        return tokenUserMap.get(token);
    }

    @Override
    public void invalidateToken(String token) {
        if (!tokenTimeMap.containsKey(token)) {
            return;
        }
        tokenTimeMap.remove(token);
    }
}
