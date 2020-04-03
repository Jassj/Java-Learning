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

abstract class AbstractClass {

    private String abstractName;

    abstract void print(String abstractName); // 抽象方式声明, 具体方法由继承类实现


    public void setAbstractName(String abstractName) {
        this.abstractName = abstractName;
    }

    String getAbstractName () { // 抽象类中可包含非抽象方法
        return abstractName;
    }
}

