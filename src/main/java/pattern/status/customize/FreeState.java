package pattern.status.customize;

public class FreeState implements State {

    @Override
    public void order(Order order) {
        System.out.println("下单成功");
        order.setStatus(CommodityStatus.ORDER);
    }

    @Override
    public void pay(Order order) {
        System.out.println("请先下单, 后支付");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("您尚未购买商品");
    }

}
