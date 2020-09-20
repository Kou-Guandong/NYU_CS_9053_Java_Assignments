import java.util.Arrays;

public class TwoDimensionalArray {

	public static void main(String[] args) {

		int[][] twoDimArray = new int[2][5];
		int[] arrayOne = { 5, 9, 55, 23, 89 };
		int[] arrayTwo = { 15, 3, 23, 19, 64 };
		int[][] arrays = { arrayOne, arrayTwo }; // stores the reference of the two 1-d arrays

		/* copy arrayOne and arrayTwo into twoDimArray */
		/*
		 * print out the first list of 5 numbers in twoDimArray on one line, and the
		 * second list of 5 numbers in twoDimArray on the next line
		 */

		/*
		 * the solution should use nested loops: one loop to loop over each array in
		 * twoDimArray, and one loop to loop over each element in that array
		 */

		for (int j = 0; j < arrays.length; j++) {
			for (int i = 0; i < arrayOne.length; i++) {
				twoDimArray[j][i] = arrays[j][i];
			}
		}

		System.out.println("The first line of twoDimArray is " + Arrays.toString(twoDimArray[0]));
		System.out.println("The second line of twoDimArray is " + Arrays.toString(twoDimArray[1]));
	}
}
