package service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.RoleRecordService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sebastiangetts
 */
class RoleRecordServiceImplTest {

    RoleRecordService roleRecordService;

    @BeforeEach
    void initRoleInfo() {
        roleRecordService = new RoleRecordServiceImpl();
        roleRecordService.createRole("Doctor");
    }

    @Test
    void createRole() {
    }

    @Test
    void deleteRole() {
        assertTrue(roleRecordService.deleteRole("Doctor"));
        assertFalse(roleRecordService.deleteRole("Teacher"));
    }

    @Test
    void checkIfRoleIsValid() {
        assertTrue(roleRecordService.checkIfRoleIsValid("Doctor"));
        assertFalse(roleRecordService.checkIfRoleIsValid("Teacher"));
    }
}