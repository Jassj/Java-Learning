package jvm;

/**
 * description
 * 动态链接测试
 * @author yuanjie 2020/03/31 23:06
 */
public class DynamicLinkingTest {
    public void showAnimal(Animal animal) {
        animal.eat(); // 晚期绑定：存在继承的子类, 需要具体实现类调用
    }

    public void showHunt(Hunting h) {
        h.hunt(); // 晚期绑定：接口不可以实例化, 需要具体实现类调用
    }
}

interface Hunting {
    void hunt();
}

class Animal {
    public void eat() {
        System.out.println("动物觅食");
    }
}

class Cat extends Animal implements Hunting{

    public Cat() { // 早期绑定: 指定调用父类构造方法
        super();
    }

    public Cat(String name) { // 早期绑定: 指定本类构造方法
        this();
    }

    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void hunt() {
        System.out.println("猫抓老鼠");
    }
}

class Fish extends Animal implements Hunting{
    public void eat() {
        System.out.println("鱼吃虾米");
    }

    @Override
    public void hunt() {
        System.out.println("大鱼吃小鱼");
    }
}
