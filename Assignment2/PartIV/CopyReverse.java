import java.util.Arrays;

public class CopyReverse {

	public static void main(String[] args) {

		int[] sourceArray = new int[50];
		int[] destArray = new int[50];

		/* initialize the source Array */
		for (int i = 0; i < sourceArray.length; i++) {
			sourceArray[i] = (int) (Math.random() * 100);
		}

		/*
		 * destArray should have the contents of sourceArary but in reverse, eg:
		 * sourceArray[0] should have the same value of destArray[destArray.length-1]
		 * sourceArray[1] should have the same value of destArray[destArray.length-2]
		 * 
		 * and so on
		 */

		for (int i = 0; i < sourceArray.length; i++) {
			destArray[i] = sourceArray[sourceArray.length - 1 - i];
		}
		System.out.println(Arrays.toString(sourceArray));
		System.out.println(Arrays.toString(destArray));

	}
}
