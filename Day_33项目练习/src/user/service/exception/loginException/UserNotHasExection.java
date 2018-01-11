package user.service.exception.loginException;

public class UserNotHasExection extends LoginException {
    @Override
    public String getMessage() {
        return  "用户不存在";
    }
}
