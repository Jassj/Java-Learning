package designPattern.decorationPattern.decorationDemo1;

public abstract class Finery implements Person {

    protected Person person;

    // 初始化被装饰的对象
    public void decorate(Person person) {
        this.person = person;
    }

    @Override
    public void show() {
        if(person != null) {
            // 调用被装饰对象的动作
            person.show();
        }
    }

}
