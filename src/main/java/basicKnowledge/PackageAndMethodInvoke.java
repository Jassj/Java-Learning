package basicKnowledge;
import java.util.Arrays;

/*
 * 1.每个类都属于一个包，只要保证同一包中的类不同名就行
 * 2.包的命名规则是全部用小写字母,不能以java开头，否则运行时将报安全异常：SecurityException
 * 3.package语句必须位于类有效代码的第一句
 */
public class PackageAndMethodInvoke {

    /*
     * 可变参数可以看作数组
     * 1.可变参数必须是最后一个参数
     * 2.一个方法只能出现一个可变参数
     * 3.实际调用时传入的参数个数可以为0，及不传参数也可以
     * */
    public static void m1(int...a) { //等价于public static void m1(int [] a)
        System.out.println(Arrays.toString(a));
        System.out.println("1");
    }

    public static void main(String...args) {
        m1(2,2,2);
    }

}