import java.util.ArrayList;
import java.util.Collection;
import javafx.util.Pair;

public class ResultPrinter {

	MathOperation op;

	public ResultPrinter() {

	}

	public ResultPrinter(MathOperation op) {
		this.op = op;
	}

	public static void printResult(Object result) {
		System.out.println("The result is " + result.toString());
	}

	public void go(double a, double b) {
		printResult(this.op.operation(a, b));
	}

	public static void go(double a, double b, MathOperation op) {
		printResult(op.operation(a, b));
	}

	public static void go(Collection<Pair<Double, Double>> c, MathOperation op) {
		for (Pair<Double, Double> pair : c) {
			printResult(op.operation(pair.getKey(), pair.getValue()));
		}
	}

	public static void main(String[] args) {
		ResultPrinter rp = new ResultPrinter(new MathOperation() {
			public double operation(double a, double b) {
				// default operation is set as addition
				return a + b;
			}
		});

		rp.go(3.0, 4.0);

		ResultPrinter.go(24.0, 8.0, (a, b) -> a / b); // 3.0
		ResultPrinter.go(3.0, 7.0, (a, b) -> a * b); // 21.0

		ArrayList<Pair<Double, Double>> pairsArrayList = new ArrayList<Pair<Double, Double>>();

		double[][] values = { { 3, 2 }, { 1, 4 }, { 7, 9 } };

		for (int i = 0; i < values.length; i++) {
			pairsArrayList.add(new Pair<Double, Double>(values[i][0], values[i][1]));
		}

		ResultPrinter.go(pairsArrayList, (a, b) -> a * b);

	}
}
