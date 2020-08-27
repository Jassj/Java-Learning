package pattern.decoration.decorationDemo2;

public class ConcreteComponent extends Component {

    @Override
    public void operation() {
        behavior();
        System.out.println("具体的对象操作");
    }

    private void behavior() {
        // 可扩展
        System.out.println("我是被装饰的对象");
    }

}
