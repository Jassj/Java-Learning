package pattern.status.customize;

import lombok.Data;

@Data
public class StateTest {

    private static CommodityStatus status;

    // 下单
    public void order() {
        if(status == CommodityStatus.FREE) {
            System.out.println("下单成功");
            status = CommodityStatus.ORDER;
        } else if (status == CommodityStatus.ORDER) {
            System.out.println("你已下单, 请勿重复下单");
        } else if (status == CommodityStatus.PAID) {
            System.out.println("你已支付, 请勿重复下单");
        }
    }

    // 支付
    public void pay() {
        if(status == CommodityStatus.FREE) {
            System.out.println("请先下单, 后支付");
        } else if (status == CommodityStatus.ORDER) {
            System.out.println("支付成功");
            status = CommodityStatus.PAID;
        } else if (status == CommodityStatus.PAID) {
            System.out.println("你已支付, 请勿重复支付");
        }
    }

    // 取消
    public void cancel() {
        if(status == CommodityStatus.FREE) {
            System.out.println("您尚未购买商品");
        } else if (status == CommodityStatus.ORDER) {
            System.out.println("下单取消成功");
            status = CommodityStatus.FREE;
        } else if (status == CommodityStatus.PAID) {
            System.out.println("订单取消成功, 等待退款");
            status = CommodityStatus.FREE;
        }
    }

    public static void main(String[] args) {
        StateTest.status = CommodityStatus.FREE;
        StateTest test = new StateTest();
        test.order();
        test.pay();
        test.cancel();
    }

}
