package pattern.status.customize;

public class OrderState implements State {


    @Override
    public void order(Order order) {
        System.out.println("你已下单, 请勿重复下单");
    }

    @Override
    public void pay(Order order) {
        System.out.println("支付成功");
        order.setStatus(CommodityStatus.PAID);
    }

    @Override
    public void cancel(Order order) {
        System.out.println("下单取消成功");
        order.setStatus(CommodityStatus.FREE);
    }

}
