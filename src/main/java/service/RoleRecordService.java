package service;

/**
 * @author sebastiangetts
 */
public interface RoleRecordService {

    /**
     * create role
     * @param roleName role name
     * @return true-if create role name successfully, or false
     */
    boolean createRole(String roleName);

    /**
     * delete role from system
     * @param roleName role name
     * @return true-if delete role name successfully, or false
     */
    boolean deleteRole(String roleName);

    /**
     * check role name if in the system
     * @param roleName role name
     * @return true-if the role name is in the system, or false
     */
    boolean checkIfRoleIsValid(String roleName);
}
