
public class PrintResults {

	public static void main(String[] args) {

		System.out.println("The value of 1+1 is " + (1 + 1));
		int a = 10 + 5;
		int b = 50 - 23;
		int c = 12 * 13;
		double d = 20.0 / 3.0;
		int e = 100 % 7;
		double f = Math.pow(4, 3);
		// the value of a is [Value]
		System.out.format("The value of a is %s\n", a);
		System.out.format("The value of b is %s\n", b);
		System.out.format("The value of c is %s\n", c);
		System.out.format("The value of d is %s\n", d);
		System.out.format("The value of e is %s\n", e);
		System.out.format("The value of f is %s\n", f);
		System.out.println();
	}
}
