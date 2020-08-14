package designPattern.factoryMethod;

import designPattern.sampleFactory.Operation;
import designPattern.sampleFactory.SubOperation;

public class SubFactory implements IFactory {

	@Override
	public Operation createOperation() {
		return new SubOperation();
	}

}
