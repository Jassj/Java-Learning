package designPattern.decorationPattern.decorationDemo2;

public class ConcreteDecoratorB extends Decorator {

    @Override
    public void operation() {
        addedBehavior();
        super.operation();
        System.out.println("具体装饰器B的操作");
    }

    private void addedBehavior() {
        // 可扩展
        System.out.println("我是装饰器B");
    }

}
