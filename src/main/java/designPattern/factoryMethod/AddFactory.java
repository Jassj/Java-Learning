package designPattern.factoryMethod;

import designPattern.sampleFactory.AddOperation;
import designPattern.sampleFactory.Operation;

public class AddFactory implements IFactory {

	@Override
	public Operation createOperation() {
		return new AddOperation();
	}

}
