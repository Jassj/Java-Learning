package features;

/**
 * description
 * jdk1.8 new feature: lambda
 * @author yuanjie 2020/03/30 11:00
 */
public class LambdaTest {
    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    public static void LambdaFunction1() {
        MathOperation addition = Integer::sum;
        MathOperation subtraction = (int a, int b) -> a - b;
        MathOperation multiplication = (int a, int b) -> a * b;
        MathOperation division = (int a, int b) -> a / b;

        LambdaTest test = new LambdaTest();
        System.out.println(test.operate(6, 3, addition));
        System.out.println(test.operate(6, 3, subtraction));
        System.out.println(test.operate(6, 3, multiplication));
        System.out.println(test.operate(6, 3, division));

        GreetingService greetingService = message -> System.out.println("Hello " + message);
        greetingService.sayMessage("World");
    }

    // 无参无返回值
    @FunctionalInterface
    interface NoReturnNoParam {
        void method();
    }

    // 一个参数无返回值
    @FunctionalInterface
    interface NoReturnOneParam {
        void method(int a);
    }

    // 多参数无返回值
    @FunctionalInterface
    interface NoReturnMultiParam {
        void method(int a, int b);
    }

    // 无参有返回值
    @FunctionalInterface
    interface ReturnNoParam {
        int method();
    }

    // 一个参数有返回值
    @FunctionalInterface
    interface ReturnOneParam {
        int method(int a);
    }

    // 多个参数有返回值
    @FunctionalInterface
    interface ReturnMultiParam {
        int method(int a, int b);
    }

    public static void LambdaFunction2() {
        NoReturnNoParam noReturnNoParam = () ->  System.out.println("i'm no return no param interface");
        noReturnNoParam.method();
        NoReturnOneParam noReturnOneParam = a -> System.out.println("i have no return value, but my parameter is " + a);
        noReturnOneParam.method(1);
        NoReturnMultiParam noReturnMultiParam = (a, b) -> System.out.println("i have no return value, but my parameter are " + a + ", " + b);
        noReturnMultiParam.method(3, 4);
        ReturnMultiParam returnMultiParam = (a, b) -> a + b;
        System.out.println("my return value is " + returnMultiParam.method(2, 2));
    }

    public static void main(String[] args) {
//        LambdaFunction1();
        LambdaFunction2();
    }
}
