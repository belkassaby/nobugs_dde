package nobugs.myoperation;

import org.eclipse.january.dataset.Dataset;
import org.eclipse.january.dataset.DatasetUtils;
import org.eclipse.january.dataset.IDataset;
import org.eclipse.january.dataset.Maths;
import org.eclipse.january.IMonitor;
import org.eclipse.dawnsci.analysis.dataset.operations.AbstractOperation;
import org.eclipse.dawnsci.analysis.api.processing.OperationData;
import org.eclipse.dawnsci.analysis.api.processing.OperationException;
import org.eclipse.dawnsci.analysis.api.processing.OperationRank;

public class MyOperation extends AbstractOperation<MyOperationModel, OperationData> {

	@Override
	protected OperationData process(IDataset input, IMonitor monitor) throws OperationException {
		Dataset data = DatasetUtils.convertToDataset(input);
		// retrieve the ui input from the model for the derivative spread parameter
		int spread = model.getDerivSpread();
		// apply derivative using Maths class in Eclipse January
		Dataset indices = data.getIndices().squeeze();
		Dataset deriv = Maths.derivative(indices, data, spread);
		deriv.setName("Derivative Data");
		copyMetadata(input, deriv);
		// return derivative
		return new OperationData(deriv);
	}


	@Override
	public String getId() {
		return "nobugs.myoperation.operation";
	}

	@Override
	public OperationRank getInputRank() {
		return OperationRank.ANY;
	}

	@Override
	public OperationRank getOutputRank() {
		return OperationRank.SAME;
	}

	

}