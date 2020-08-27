package pattern.factory;

import pattern.samplefactory.Operation;
import pattern.samplefactory.SubOperation;

public class SubFactory implements IFactory {

	@Override
	public Operation createOperation() {
		return new SubOperation();
	}

}
