import java.io.Serializable;
import java.io.Serializable;

public class ExceptionWrongMatrixValues extends NumberFormatException implements Serializable {
	private static final long serialVersionUID = 4471652819744301692L;


	public ExceptionWrongMatrixValues() {

	}

	public ExceptionWrongMatrixValues(String msg) {
		super(msg);
	}

}
