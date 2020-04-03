package advancedFeatures;

/**
 * description
 * @author yuanjie 2019/11/12 22:13
 * ①.具有参数校验的优势,编译器捕获到入参不是枚举类型时提示错误
 * ②.定义在类中的枚举类会被编译成内部类
 * ③.枚举类成员默认为public final static
 */
interface Constant {
    int ConstantA = 1;
    int ConstantB = 2;
}

public class EnumTest {
    enum Constant1 {
        Constant_A,
        Constant_B
    }

    enum Constant2 {
        Constant_A,
        Constant_B
    }

    private static void doIt1(int a) {
        switch (a) {
            case Constant.ConstantA :
                System.out.println("doIt1 ConstantA");
                break;
            case Constant.ConstantB :
                System.out.println("doIt1 ConstantB");
                break;
            default:
                System.out.println("doIt1 Default");
        }
    }

    private static void doIt2(Constant2 constant) {
        switch (constant) {
            case Constant_A:
                System.out.println("doIt2 Constant_A");
                break;
            case Constant_B:
                System.out.println("doIt2 Constant_B");
                break;
            default:
                System.out.println("doIt2 Default");
        }
    }

    private static void usageMethod() {
        for(Constant2 constant2 : Constant2.values()) {
            System.out.println(constant2);
        }
    }

    public static void testDo() {
        doIt1(1);
        doIt1(2);
        doIt1(3);
        doIt2(Constant2.Constant_A);
        doIt2(Constant2.Constant_B);
//        doIt2(3);                            Compiler will throw Error while Parameter Type is not Enum
//        doIt2(Constant1.Constant_A);
    }

    public static void main(String[] args) {
//        testDo();
        usageMethod();
    }
}
