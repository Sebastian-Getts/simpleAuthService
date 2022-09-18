package service;

import java.util.List;

/**
 * @author sebastiangetts
 */
public interface UserRoleManagerService {

    /**
     * associate the role to the user
     * @param roleName role name
     * @param userName username
     */
    void addRoleToUser(String roleName, String userName);

    /**
     * check if the username belongs to the role
     * @param userName username
     * @param roleName role name
     * @return true-if the user belongs to the role, or return false
     */
    boolean checkUserBelongsToRole(String userName, String roleName);

    /**
     * check username and role name if valid
     * @param userName username
     * @param roleName role name
     * @return true-if both username and role name are valid, or return false
     */
    boolean checkNameIsValid(String userName, String roleName);

    /**
     * get all roles of the user
     * @param userName username
     * @return the role list
     */
    List<String> getRolesOfUser(String userName);
}
