package pattern.status.customize;

public class PaidState implements State {

    @Override
    public void order(Order order) {
        System.out.println("你已支付, 无需下单");
    }

    @Override
    public void pay(Order order) {
        System.out.println("你已支付, 请勿重复支付");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("订单取消成功, 等待退款");
        order.setStatus(CommodityStatus.FREE);
    }

}
