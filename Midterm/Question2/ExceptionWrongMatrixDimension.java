import java.io.Serializable;

public class ExceptionWrongMatrixDimension extends ArrayIndexOutOfBoundsException implements Serializable {

	private static final long serialVersionUID = 7272363934478331115L;

	public ExceptionWrongMatrixDimension() {

	}

	public ExceptionWrongMatrixDimension(String msg) {
		super(msg);
	}
}
