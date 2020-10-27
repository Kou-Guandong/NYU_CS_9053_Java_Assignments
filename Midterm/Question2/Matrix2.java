import java.io.File;

import java.io.FileWriter;

import java.io.BufferedWriter;

import java.io.IOException;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Matrix2 {
	double[][] mtx = null;

	public Matrix2(int m, int n) {
		this.mtx = new double[m][n];
		for(int i = 0; i < m ; ++i){
			for(int j = 0 ; j < n ; j++){
				this.mtx[i][j] = 0;
			}
		}
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
		File file = new File(filename);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fileWritter = new FileWriter(file.getName(), true);

			fileWritter.write(numRows() + ' ' + numColumns() + '\n');
			for (int i = 0; i < numRows(); ++i) {
				for (int j = 0; j < numColumns(); ++j) {
					if (j != 0) {
						fileWritter.write(' ');
					}
					fileWritter.write(String.valueOf(mtx[i][j]));
				}
				fileWritter.write('\n');
			}
			fileWritter.close();
		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public static Matrix2 read(String filename) throws ExceptionWrongMatrixValues, ExceptionWrongMatrixDimension {
		try {
			File file = new File(filename);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();
			String regex = "\\d+(\\.\\d+)?";
			String[] ts = line.split(" ");
			int m = Integer.parseInt(ts[0]);
			int n = Integer.parseInt(ts[1]);
			int linecount = 0;
			Matrix2 Matrix2 = new Matrix2(m, n);
			while (line != null) {
				line = br.readLine();
				if (line != null && line.equals(""))
					break;
				String[] token = line.split(" ");
				if (token.length != n) {
					throw ExceptionWrongMatrixDimension;
				}
				for (int i = 0; i < n; ++i) {
					if (!token[i].matches(regex)) {
						throw ExceptionWrongMatrixValues;
					}
					Matrix2.mtx[linecount][i] = Double.parseDouble(token[i]);

				}
				linecount++;
			}
			if (linecount != m) {
				throw new ExceptionWrongMatrixDimension();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Matrix2 sum(Matrix2 m) {
		return null;
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

	public Matrix2 product(Matrix2 m) {

		return null;
	}

	public static void main(String[] args) {
		Matrix2 m1 = new Matrix2(2, 3);
		m1.setElement(0, 0, 1.0);
		m1.setElement(0, 1, 1.0);
		m1.setElement(0, 2, 1.0);
		m1.setElement(1, 0, 1.0);
		m1.setElement(1, 1, 1.0);
		m1.setElement(1, 2, 1.0);

		Matrix2 m2 = new Matrix2(3, 2);
		m2.setElement(0, 0, 2.0);
		m2.setElement(0, 1, 2.0);
		m2.setElement(1, 0, 2.0);
		m2.setElement(1, 1, 3.0);
		m2.setElement(2, 0, 3.0);
		m2.setElement(2, 1, 3.0);

		Matrix2 result = m1.product(m2);
		m1.save("m1");
		m2.save("m2");
		result.save("result");

		try {
			m1 = Matrix2.read("m1");
			m2 = Matrix2.read("m2");
			Matrix2 m3 = Matrix2.read("result");
		} catch (Exception e) {
			System.err.println("error: " + e);
		}

		try {
			Matrix2 badMatrix2 = Matrix2.read("wrongcolumns");
		} catch (ExceptionWrongMatrixDimension e1) {
			System.err.println("wrong dimensions: " + e1);
		} catch (ExceptionWrongMatrixValues e2) {

			System.err.println("wrong Matrix2 values: " + e2);
		}

		try {
			Matrix2 badMatrix2 = Matrix2.read("wrongrows");
		} catch (ExceptionWrongMatrixValues e) {

			System.err.println("wrong dimensions: " + e);
		} catch (ExceptionWrongMatrixDimension e) {
			System.err.println("wrong Matrix2 values: " + e);
		}

		return;

	}

}
