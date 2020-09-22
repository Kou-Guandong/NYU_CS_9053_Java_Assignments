/*
This script takes an integer in the range of [-999999999, 999,999,999] as input, and returns the English text of that number.
*/

import java.util.Scanner;

public class NumberToEnglish {

	public static String numberToEnglish(int num) throws Exception {
		if (Math.abs(num) >= Math.pow(10, 9)) {
			throw new Exception("value out of range");
		}
		if (num == 0) {
			return "Zero";
		}
		return helper(num);
	}

	public static String helper(int num) {
		String[] words = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
				"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
				"Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		StringBuilder res = new StringBuilder();

		if (num < 0) {
			res.append(" Negative ").append(helper(-num));
		} else if (num >= 1000000) {
			res.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
		} else if (num >= 1000) {
			res.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
		} else if (num >= 100) {
			res.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
		} else if (num >= 20) {
			res.append(words[(num - 20) / 10 + 20]).append(" ").append(words[num % 10]);
		} else {
			res.append(words[num]);
		}
		return res.toString().trim();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = in.nextInt();
		in.close();
		try {
			System.out.println("The number " + number + " in English is: " + numberToEnglish(number));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
