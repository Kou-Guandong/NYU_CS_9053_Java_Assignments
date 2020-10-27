import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
	double[][] mtx = null;

	public Matrix(int m, int n) {
		this.mtx = new double[m][n];
	}

	public int numRows() {
		return mtx.length;
	}

	public double[] getRow(int i) {
		return mtx[i];
	}

	public double getElement(int i, int j) {
		return mtx[i][j];
	}

	public void setElement(int i, int j, double val) {
		mtx[i][j] = val;
	}

	public int numColumns() {
		return mtx[0].length;
	}

	public void save(String filename) {

		try {
			FileWriter outputWriter = new FileWriter(filename);
			outputWriter.write(this.mtx.length + " " + this.mtx[0].length + "\n");
			for (int i = 0; i < this.mtx.length; i++) {
				for (int j = 0; j < this.mtx[0].length; j++) {
					outputWriter.write(this.mtx[i][j] + " ");
				}
				outputWriter.write("\n");
			}
			outputWriter.close();
			System.out.println("Successfully wrote to " + filename);
		} catch (IOException e) {
			System.out.println("An error occurred while writting to " + filename);
			e.printStackTrace();
		}

	}

	public static Matrix read(String filename) throws ExceptionWrongMatrixDimension {
		Matrix matrix = null;
		// System.out.println("Read file : " + filename);

		try {
			File inputFile = new File(filename);
			Scanner inputReader = new Scanner(inputFile);

			if (inputReader.hasNextLine()) {
				String headline = inputReader.nextLine().trim();
				int[] size = Arrays.stream(headline.split(" ")).mapToInt(Integer::parseInt).toArray();
				int m = size[0];
				int n = size[1];
				matrix = new Matrix(m, n);
				// System.out.println(m);
				// System.out.println(n);
				int rowIndex = 0;
				double[] values;
				while (inputReader.hasNextLine()) {
					try {
						values = Arrays.stream(inputReader.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
						if (values.length != n || rowIndex >= m) {
							throw new ExceptionWrongMatrixDimension("wrong dimension");
						}
						for (int j = 0; j < n; j++) {
							matrix.mtx[rowIndex][j] = values[j];
						}
						// System.out.println(Arrays.toString(matrix.mtx[rowIndex]));
						rowIndex++;
					} catch (NumberFormatException e) {
						System.out.println("wrong number format: " + e.getMessage());
						e.printStackTrace();
					}
				}
			}

			inputReader.close();

			return matrix;

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return matrix;
	}

	public Matrix sum(Matrix m) {
		if (m.numRows() != this.numRows() || m.numColumns() != this.numColumns()) {
			return null;
		}
		Matrix result = new Matrix(this.numRows(), this.numColumns());
		for (int i = 0; i < this.numRows(); i++) {
			for (int j = 0; j < this.numColumns(); j++) {
				result.mtx[i][j] = this.mtx[i][j] + m.mtx[i][j];
			}
		}
		return result;
	}

	// this will come in handy for the multiplication part
	public double[] getColumn(int j) {
		if (j >= this.numColumns()) {
			return null;
		}
		double[] col = new double[this.numRows()];
		for (int i = 0; i < mtx.length; i++) {
			col[i] = mtx[i][j];
		}
		return col;
	}

	public Double dotproduct(double[] v1, double[] v2) {
		Double result = null;
		if (v1.length == v2.length) {
			result = 0.0;
			for (int i = 0; i < v1.length; i++) {
				result += v1[i] * v2[i];
			}
		}
		return result;
	}

	public Matrix product(Matrix m) {
		int m1 = this.numRows();
		int n1 = this.numColumns();
		int m2 = m.numRows();
		int n2 = m.numColumns();
		if (n1 != m2) {
			return null;
		}

		Matrix result = new Matrix(m1, n2);
		for (int i = 0; i < m1; i++) {
			for (int j = 0; j < n2; j++) {
				for (int k = 0; k < n1; k++) {
					result.mtx[i][j] += this.mtx[i][k] * m.mtx[k][j];
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Matrix m1 = new Matrix(2, 3);
		m1.setElement(0, 0, 1.0);
		m1.setElement(0, 1, 1.0);
		m1.setElement(0, 2, 1.0);
		m1.setElement(1, 0, 1.0);
		m1.setElement(1, 1, 1.0);
		m1.setElement(1, 2, 1.0);

		Matrix m2 = new Matrix(3, 2);
		m2.setElement(0, 0, 2.0);
		m2.setElement(0, 1, 2.0);
		m2.setElement(1, 0, 2.0);
		m2.setElement(1, 1, 3.0);
		m2.setElement(2, 0, 3.0);
		m2.setElement(2, 1, 3.0);

		Matrix result = m1.product(m2);
		m1.save("m1");
		m2.save("m2");
		result.save("result");

		try {
			m1 = Matrix.read("m1");
			m2 = Matrix.read("m1");
			// Matrix m3 = Matrix.read("result");
			Matrix m3 = m1.sum(m2);

		} catch (Exception e) {
			System.err.println("error: " + e);
		}

		try {
			Matrix badMatrix = Matrix.read("wrongcolumns");
		} catch (ExceptionWrongMatrixDimension e1) {
			System.err.println("wrong dimensions: " + e1);
		} catch (ExceptionWrongMatrixValues e2) {
			System.err.println("wrong matrix values: " + e2);
		}

		try {
			Matrix badMatrix2 = Matrix.read("wrongrows");
		} catch (ExceptionWrongMatrixValues e) {
			System.err.println("wrong dimensions: " + e);
		} catch (ExceptionWrongMatrixDimension e) {
			System.err.println("wrong matrix values: " + e);
		}

		try {
			Matrix badMatrix3 = Matrix.read("wrongvalues");
		} catch (ExceptionWrongMatrixValues e) {
			System.err.println("wrong dimensions: " + e);
		} catch (ExceptionWrongMatrixDimension e) {
			System.err.println("wrong matrix values: " + e);
		}

		return;

	}

}
