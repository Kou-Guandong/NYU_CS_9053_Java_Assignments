
public class ArrayStats {

	public static void main(String[] args) {
		int[] intArray = new int[50];
		
		int smallestValue;
		int largestValue;
		double meanAverage;
		
		/* initialize the source Array */
		for (int i = 0;i < intArray.length; i++) {
			intArray[i] = (int)(Math.random()*100);
		}
		
		System.out.println("Smallest value in the array is " + 
							smallestValue);
		System.out.println("Largest value in the array is " + 
							largestValue);
		System.out.println("Mean average value of array elements is " + 
							meanAverage);
	}
}
