package user.service.registerException;

public class UserHasException extends  RegisterException {
    @Override
    public String getMessage() {
        return "用户已存在！";
    }
}
