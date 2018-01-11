package user.service.exception.loginException;

public class UsernaemNotException extends  LoginException {
    @Override
    public String getMessage() {
        return "用户名错误！";
    }
}
