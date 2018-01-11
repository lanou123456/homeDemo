package user.service.exception.loginException;

import user.service.exception.loginException.LoginException;

public class NullLoginException extends LoginException {
    @Override
    public String getMessage() {
        return "密码和用户名不能为空！";
    }
}
