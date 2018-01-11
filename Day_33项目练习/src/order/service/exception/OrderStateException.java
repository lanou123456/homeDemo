package order.service.exception;

public class OrderStateException extends  Exception {
    @Override
    public String getMessage() {
        return "确认订单失败,你是个蛇皮怪吧！";
    }
}
