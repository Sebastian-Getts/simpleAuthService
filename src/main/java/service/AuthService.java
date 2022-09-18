package service;

import java.util.List;

/**
 * This is core api, support other system or service to use
 * @author sebastiangetts
 */
public interface AuthService {

    /**
     * create user
     * @param userName username
     * @param password password
     * @return true-if create user successfully, or return false
     */
    boolean createUser(String userName, String password);

    /**
     * delete user
     * @param userName username
     * @return true-if delete user successfully, or return false
     */
    boolean deleteUser(String userName);

    /**
     * create role
     * @param roleName role name
     * @return true-if create role successfully, or return false
     */
    boolean createRole(String roleName);

    /**
     * delete role
     * @param roleName role name
     * @return true-if delete role successfully, or return false
     */
    boolean deleteRole(String roleName);

    /**
     * associate the role to the user
     * @param userName username
     * @param roleName role name
     */
    void addRoleToUser(String userName, String roleName);

    /**
     * get token by username and password
     * @param name username
     * @param password password
     * @return token string
     */
    String authenticate(String name, String password);

    /**
     * make the current token expired
     * @param token token string
     */
    void invalidate(String token);

    /**
     * check the role is valid, as well as the current token
     * @param token token string
     * @param roleName role name
     * @return true-if both token and role name are valid, or return false
     */
    boolean checkRole(String token, String roleName);

    /**
     * get the user which token represented all roles
     * @param token token string
     * @return role list
     */
    List<String> allRoles(String token);
}
