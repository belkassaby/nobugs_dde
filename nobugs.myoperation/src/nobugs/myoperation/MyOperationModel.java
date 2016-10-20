package nobugs.myoperation;

import org.eclipse.dawnsci.analysis.api.processing.model.AbstractOperationModel;
import org.eclipse.dawnsci.analysis.api.processing.model.OperationModelField;

public class MyOperationModel extends AbstractOperationModel {

	@OperationModelField(hint = "Enter value for operation", label = "Value")
	private int derivSpread = 1;

	public int getDerivSpread() {
		return derivSpread;
	}

	public void setDerivSpread(int derivSpread) {
		firePropertyChange("derivSpread", this.derivSpread, this.derivSpread = derivSpread);
	}
}