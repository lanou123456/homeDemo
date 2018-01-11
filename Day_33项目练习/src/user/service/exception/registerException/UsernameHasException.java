package user.service.exception.registerException;

import user.service.exception.registerException.RegisterException;

public class UsernameHasException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户名已存在";
    }
}
