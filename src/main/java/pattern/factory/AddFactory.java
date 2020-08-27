package pattern.factory;

import pattern.samplefactory.AddOperation;
import pattern.samplefactory.Operation;

public class AddFactory implements IFactory {

	@Override
	public Operation createOperation() {
		return new AddOperation();
	}

}
