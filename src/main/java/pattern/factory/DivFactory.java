package pattern.factory;

import pattern.samplefactory.DivOperation;
import pattern.samplefactory.Operation;

public class DivFactory implements IFactory {

	@Override
	public Operation createOperation() {
		return new DivOperation();
	}

}
