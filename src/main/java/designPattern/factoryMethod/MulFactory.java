package designPattern.factoryMethod;

import designPattern.sampleFactory.MulOperation;
import designPattern.sampleFactory.Operation;

public class MulFactory implements IFactory {

	@Override
	public Operation createOperation() {
		return new MulOperation();
	}

}
