package pattern.status.customize;

import lombok.Data;

@Data
public class Order {

    private State state;

    private CommodityStatus status;


    public void order() {
        state.order(this);
    }

    public void pay() {
        state.pay(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.setState(new FreeState());
        order.pay();
    }

}
