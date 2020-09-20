
public class SumToOneHundred {

	public static void main(String[] args) {
		
		int sum = 0;
		int counter = 0;

		/* first while loop */
		
		while(true) {
			sum += counter;
			counter++;
		}
		// there should be an error here that says "unreachable code"
		// you need a condition that causes the while loop the exit so you
		// can reach this.
		System.out.println("Sum is " + sum);
		
		sum = 0;
		counter = 0;
		/* second while loop */
		/* your while loops should look like this:
		 * 
		 * 
		 * while (condition) {
		 * 	sum += counter;
		 * 	counter++;
		 * }
		 * 
		 */
		
		System.out.println("Sum is " + sum);
		
	}
}
