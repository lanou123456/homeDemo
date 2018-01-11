package user.service.exception.loginException;

public class StateException extends LoginException {
    @Override
    public String getMessage() {
        return  "没有激活";
    }
}
