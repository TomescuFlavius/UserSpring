package ro.mycode.user.ecxeption;


import static ro.mycode.user.constants.ExceptionsConstants.USER_ALREADY_EXIST_EXCEPTION;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException() {
        super(USER_ALREADY_EXIST_EXCEPTION);
    }
}
