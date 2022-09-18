package service.impl;

import service.RoleRecordService;
import service.UserRecordService;
import service.UserRoleManagerService;

import java.util.*;

/**
 * @author sebastiangetts
 */
public class UserRoleManagerServiceImpl implements UserRoleManagerService {

    /**
     * user record
     */
    private final UserRecordService userRecord;

    /**
     * role record
     */
    private final RoleRecordService roleRecord;

    /**
     * to record user-to-role association
     */
    private static Map<String, Set<String>> userToRoleMap;

    /**
     * to record role-to-user association
     */
    private static Map<String, Set<String>> roleToUserMap;

    public UserRoleManagerServiceImpl(UserRecordService userRecord, RoleRecordService roleRecord) {
        this.userRecord = userRecord;
        this.roleRecord = roleRecord;
        userToRoleMap = new HashMap<>();
        roleToUserMap = new HashMap<>();
    }

    @Override
    public void addRoleToUser(String roleName, String userName) {
        // check roleName and userName is valid
        if (!checkNameIsValid(userName, roleName)) {
            return;
        }
        // user to role
        if (!userToRoleMap.containsKey(userName)) {
            Set<String> set = new HashSet<>();
            set.add(roleName);
            userToRoleMap.put(userName, set);
        } else {
            userToRoleMap.get(userName).add(roleName);
        }
        // role to user
        if (!roleToUserMap.containsKey(roleName)) {
            Set<String> set = new HashSet<>();
            set.add(userName);
            roleToUserMap.put(roleName, set);
        } else {
            roleToUserMap.get(roleName).add(userName);
        }
    }

    @Override
    public boolean checkUserBelongsToRole(String userName, String roleName) {
        // check roleName and userName is valid
        if (!checkNameIsValid(userName, roleName)) {
            return false;
        }

        return roleToUserMap.get(roleName) != null && roleToUserMap.get(roleName).contains(userName);
    }

    @Override
    public boolean checkNameIsValid(String userName, String roleName) {

        return userRecord.checkUserNameIsValid(userName) && roleRecord.checkIfRoleIsValid(roleName);
    }

    @Override
    public List<String> getRolesOfUser(String userName) {
        if (userRecord.checkUserNameIsValid(userName)) {

            return new ArrayList<>(userToRoleMap.get(userName));
        }

        return new ArrayList<>();
    }
}
