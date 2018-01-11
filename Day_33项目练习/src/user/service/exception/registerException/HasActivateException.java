package user.service.exception.registerException;

public class HasActivateException extends RegisterException {
    @Override
    public String getMessage() {
        return "已经激活了";
    }
}
