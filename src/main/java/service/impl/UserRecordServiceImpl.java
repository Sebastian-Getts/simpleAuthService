package service.impl;

import service.UserRecordService;
import util.EncryptUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sebastiangetts
 */
public class UserRecordServiceImpl implements UserRecordService {

    /**
     * to record user and password-encrypted
     */
    private static Map<String, String> map;

    public UserRecordServiceImpl() {
        map = new HashMap<>();
    }

    @Override
    public boolean createUser(String userName, String password) {
        if (map.containsKey(userName)) {
            return false;
        }
        // encrypted password
        map.put(userName, EncryptUtil.getSHA256StrJava(password));

        return true;
    }

    @Override
    public boolean deleteUser(String userName) {
        if (!map.containsKey(userName)) {
            return false;
        }
        map.remove(userName);

        return true;
    }

    @Override
    public boolean checkUserNameIsValid(String name) {

        return map.containsKey(name);
    }

    @Override
    public boolean checkUserNamePasswordIsValid(String name, String password) {
        if (!checkUserNameIsValid(name)) {
            return false;
        }
        String originalPasswordEncrypted = map.get(name);

        return originalPasswordEncrypted.equals(EncryptUtil.getSHA256StrJava(password));
    }
}
