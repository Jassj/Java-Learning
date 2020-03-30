package keyword;

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

    public static void main(String[] args) {
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
}
