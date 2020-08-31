package pattern.status.customize;

public class CancelState implements State {

    @Override
    public void order(Order order) {
        System.out.println("你取消订单");
    }

    @Override
    public void pay(Order order) {
        System.out.println("你取消订单");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("你取消订单");
    }

}
