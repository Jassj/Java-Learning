package designPattern.decorationPattern.decorationDemo2;

public class ConcreteDecoratorA extends Decorator {

    private String addedState;

    @Override
    public void operation() {
        super.operation();
        addedBehavior();
        System.out.println("具体装饰器A的操作");
    }

    private void addedBehavior() {
        // 可扩展
        System.out.println("我是装饰器A");
    }

}
