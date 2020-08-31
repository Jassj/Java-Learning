package pattern.status.customize;

public interface State {

    void order(Order order);

    void pay(Order order);

    void cancel(Order order);

}
