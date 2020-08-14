package designPattern.sampleFactory;

/**
 * 简单工厂模式
 * @author jie2.yuan
 */
public class OperationFactory {

    public static Operation createOperation(String operator) {
        switch (operator) {
            case "+" :
                return new AddOperation();
            case "-" :
                return new SubOperation();
            case "*" :
                return new MulOperation();
            case "/" :
                return new DivOperation();
            default:
                return new Operation();
        }
    }

}
