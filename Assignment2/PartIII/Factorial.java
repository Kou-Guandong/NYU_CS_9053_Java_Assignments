import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the value n: ");
		int n = input.nextInt();
		int val = n;
		input.close();
		int result = 1;
		while (val > 1) {
			result *= val;
			val -= 1;
		}
		System.out.format("The factorial of %d is: %d\n", n, result);
	}
}
