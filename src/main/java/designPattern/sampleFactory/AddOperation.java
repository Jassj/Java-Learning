package designPattern.sampleFactory;

public class AddOperation extends Operation {

    @Override
    public Double doOperation(double o1, double o2) {
        return o1 + o2;
    }

}
