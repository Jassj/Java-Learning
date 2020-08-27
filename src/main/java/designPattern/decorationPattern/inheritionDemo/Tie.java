package designPattern.decorationPattern.inheritionDemo;

// 装饰模式以对客户透明的方式动态地给一个对象附加上更多的责任, 换言之, 客户端并不会觉得对象在装饰前和装饰后有什么不同.
public class Tie extends Tops {

    @Override
    public void show() {
        wear();
        System.out.println("my tie is cool!");
        super.show();
    }

    public void wear() {
        System.out.println("wear a tie!");
    }

}
