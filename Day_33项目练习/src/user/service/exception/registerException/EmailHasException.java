package user.service.exception.registerException;

public class EmailHasException extends RegisterException {
    @Override
    public String getMessage() {
        return "邮箱已存在";
    }
}
