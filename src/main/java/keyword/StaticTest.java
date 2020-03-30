package keyword;

/**
 * description
 * static
 * @author yuanjie 2020/03/28 18:11
 */
public class StaticTest {
    private static int num = 1; // 静态变量
    private static String str;
    private static float f;

    static { // 静态代码块
        str = "hello word";
        f = 3.14f;
    }

    static void print() { // 静态方法
        System.out.println(num);
        System.out.println(f);
        System.out.println(str);
    }

    static class InnerClassTest { // 静态内部类
        static void print() {
            System.out.println("i am inner class");
        }
    }

    public static void main(String[] args) {
        StaticTest.InnerClassTest.print();
        StaticTest.print();
    }
}
