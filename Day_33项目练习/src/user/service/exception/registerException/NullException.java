package user.service.exception.registerException;

public class NullException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户名，密码，邮箱不能为空！";
    }
}
