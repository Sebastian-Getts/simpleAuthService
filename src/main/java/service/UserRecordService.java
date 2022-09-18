package service;

/**
 * @author sebastiangetts
 */
public interface UserRecordService {

    /**
     * create user
     * @param userName username
     * @param password password
     * @return true-if create a user with password successfully, or false
     */
    boolean createUser(String userName, String password);

    /**
     * delete user
     * @param userName username
     * @return true-if delete by username successfully, or false
     */
    boolean deleteUser(String userName);

    /**
     * check username
     * @param userName username
     * @return true-if username is valid(in other words, the username is in the system), or false
     */
    boolean checkUserNameIsValid(String userName);

    /**
     * check username and password
     * @param userName username
     * @param password password
     * @return true-if both username and password are valid, or false
     */
    boolean checkUserNamePasswordIsValid(String userName, String password);
}
