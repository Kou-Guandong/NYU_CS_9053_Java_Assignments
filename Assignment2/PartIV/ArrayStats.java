import java.util.Arrays;

public class ArrayStats {

	public static void main(String[] args) {
		int[] intArray = new int[50];

		/* initialize the source Array */
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int) (Math.random() * 100);
		}

		System.out.println(Arrays.toString(intArray));

		int smallestValue = Arrays.stream(intArray).min().getAsInt();
		int largestValue = Arrays.stream(intArray).max().getAsInt();
		double meanAverage = (double) Arrays.stream(intArray).sum() / intArray.length;

		System.out.println("Smallest value in the array is " + smallestValue);
		System.out.println("Largest value in the array is " + largestValue);
		System.out.println("Mean average value of array elements is " + meanAverage);
	}
}
