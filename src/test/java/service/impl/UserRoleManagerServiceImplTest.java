package service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.RoleRecordService;
import service.UserRecordService;
import service.UserRoleManagerService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sebastiangetts
 */
class UserRoleManagerServiceImplTest {

    UserRecordService userRecordService;

    RoleRecordService roleRecordService;

    UserRoleManagerService userRoleManagerService;

    @BeforeEach
    void setUp() {
        userRecordService = new UserRecordServiceImpl();
        roleRecordService = new RoleRecordServiceImpl();
        userRecordService.createUser("Alice", "123");
        roleRecordService.createRole("Doctor");
        roleRecordService.createRole("Teacher");
        roleRecordService.createRole("Engineer");
        userRoleManagerService = new UserRoleManagerServiceImpl(userRecordService, roleRecordService);
    }

    @Test
    void addRoleToUser() {
        // when
        userRoleManagerService.addRoleToUser("Teacher", "Alice");
        userRoleManagerService.addRoleToUser("Doctor", "Alice");
        userRoleManagerService.addRoleToUser("Farmer", "Alice");
        // then
        assertEquals(2, userRoleManagerService.getRolesOfUser("Alice").size());
    }

    @Test
    void checkUserBelongsToRole() {
        // given
        userRoleManagerService.addRoleToUser("Teacher", "Alice");
        userRoleManagerService.addRoleToUser("Doctor", "Alice");
        // then
        assertTrue(userRoleManagerService.checkUserBelongsToRole("Alice", "Teacher"));
        assertTrue(userRoleManagerService.checkUserBelongsToRole("Alice", "Doctor"));
        assertFalse(userRoleManagerService.checkUserBelongsToRole("Alice", "Engineer"));
    }

    @Test
    void checkNameIsValid() {
        assertTrue(userRoleManagerService.checkNameIsValid("Alice", "Teacher"));
        assertFalse(userRoleManagerService.checkNameIsValid("Bob", "Doctor"));
    }

    @Test
    void getRolesOfUser() {
        // see method addRoelToUser.
    }
}