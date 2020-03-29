package keyword;

/**
 * description
 * 抽象类
 * @author yuanjie 2020/03/28 17:03
 */
// 抽象类相当于模板, 需要被子类继承后使用
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
