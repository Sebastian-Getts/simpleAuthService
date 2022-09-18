package service.impl;

import service.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sebastiangetts
 */
public class AuthServiceImpl implements AuthService {

    /**
     * role record
     */
    private final RoleRecordService roleRecord;

    /**
     * user record
     */
    private final UserRecordService userRecord;

    /**
     *  user-role-manager to record the association between user and role
     */
    private final UserRoleManagerService userRoleManager;

    /**
     * auth service
     */
    private final AuthManagerService authManger;

    public AuthServiceImpl() {
        userRecord = new UserRecordServiceImpl();
        roleRecord = new RoleRecordServiceImpl();
        userRoleManager = new UserRoleManagerServiceImpl(userRecord, roleRecord);
        // according to the request, the token is pre-configured 2h
        authManger = new AuthManagerServiceImpl(2, ChronoUnit.HOURS);
    }

    @Override
    public boolean createUser(String userName, String password) {
        return userRecord.createUser(userName, password);
    }

    @Override
    public boolean deleteUser(String userName) {

        return userRecord.deleteUser(userName);
    }

    @Override
    public boolean createRole(String roleName) {
        return roleRecord.createRole(roleName);
    }

    @Override
    public boolean deleteRole(String roleName) {

        return roleRecord.deleteRole(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        userRoleManager.addRoleToUser(roleName, userName);
    }

    @Override
    public String authenticate(String name, String password) {
        if (!userRecord.checkUserNamePasswordIsValid(name, password)) {
            return "Your username and password are invalid.";
        }

        return authManger.generateToken(name, LocalDateTime.now());
    }

    @Override
    public void invalidate(String token) {
        authManger.invalidateToken(token);
    }

    @Override
    public boolean checkRole(String token, String roleName) {
        String userName = authManger.getUserNameByToken(token, LocalDateTime.now());
        if("".equals(userName)) {
            return false;
        }

        return userRoleManager.checkUserBelongsToRole(userName, roleName);
    }

    @Override
    public List<String> allRoles(String token) {
        String userName = authManger.getUserNameByToken(token, LocalDateTime.now());
        if("".equals(userName)) {
            return new ArrayList<>();
        }

        return userRoleManager.getRolesOfUser(userName);
    }
}
