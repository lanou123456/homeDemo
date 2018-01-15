package user.service.loginException;

public class UserNoHasException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名不存在";
    }
}
