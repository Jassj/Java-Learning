package pattern.factory;

import pattern.samplefactory.MulOperation;
import pattern.samplefactory.Operation;

public class MulFactory implements IFactory {

	@Override
	public Operation createOperation() {
		return new MulOperation();
	}

}
