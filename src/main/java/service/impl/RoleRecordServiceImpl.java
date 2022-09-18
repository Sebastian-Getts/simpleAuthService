package service.impl;

import service.RoleRecordService;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sebastiangetts
 */
public class RoleRecordServiceImpl implements RoleRecordService {

    /**
     * to record role name
     */
    private static Set<String> roleSet;

    public RoleRecordServiceImpl() {
        roleSet = new HashSet<>();
    }
    @Override
    public boolean createRole(String roleName) {
        if(roleSet.contains(roleName)) {
            return false;
        }
        roleSet.add(roleName);

        return true;
    }

    @Override
    public boolean deleteRole(String roleName) {
        if(!roleSet.contains(roleName)) {
            return false;
        }
        roleSet.remove(roleName);

        return true;
    }

    @Override
    public boolean checkIfRoleIsValid(String roleName) {

        return roleSet.contains(roleName);
    }
}
