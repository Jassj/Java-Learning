package designPattern.sampleFactory;

public class Calculate {

    public static void main(String[] args) {
        Operation operation = OperationFactory.createOperation("-");
        Double result = operation.doOperation(2.0, 1.0);
        System.out.println(result);
    }

}
