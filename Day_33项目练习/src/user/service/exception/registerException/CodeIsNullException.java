package user.service.exception.registerException;

public class CodeIsNullException extends RegisterException {
    @Override
    public String getMessage() {
        return "没有激活！";
    }
}
