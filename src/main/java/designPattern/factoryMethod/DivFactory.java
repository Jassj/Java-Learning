package designPattern.factoryMethod;

import designPattern.sampleFactory.DivOperation;
import designPattern.sampleFactory.Operation;

public class DivFactory implements IFactory {

	@Override
	public Operation createOperation() {
		return new DivOperation();
	}

}
