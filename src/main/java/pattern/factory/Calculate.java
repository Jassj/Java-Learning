package pattern.factory;

import pattern.samplefactory.Operation;

public class Calculate {

    public static void main(String[] args) {
        IFactory factory = new SubFactory();
        Operation operation = factory.createOperation();
        Double result = operation.doOperation(2.0, 1.0);
        System.out.println(result);
    }

}
