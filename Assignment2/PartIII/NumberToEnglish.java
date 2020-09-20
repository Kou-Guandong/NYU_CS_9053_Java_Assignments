import java.util.Scanner;

public class NumberToEnglish {

	public static String numberToEnglish(int num) {
		
		return null;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number: " );
		
		int number = in.nextInt();
		
		System.out.println("The number " + number + " in English is " + NumberToEnglish.numberToEnglish(number));
	
	}
}
