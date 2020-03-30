package keyword;

/**
 * description
 * 抽象类的具体实现类
 * @author yuanjie 2020/03/28 17:07
 */
public class AbstractAboutTest extends AbstractClass{

    @Override
    void print(String abstractName) {
        System.out.println(abstractName);
    }

    public static void main(String[] args) {
//        AbstractClass abstractClass = new AbstractAClass(); 抽象类不能被实例化
        AbstractClass abstractClass = new AbstractAboutTest();
        abstractClass.setAbstractName("hello world!");
        abstractClass.print(abstractClass.getAbstractName());
    }
}
