
public class GravityCalculator {

	public static double calculatePosition(double t, double xi, double vi) {
		double a = -9.81;
		return 1 / 2 * a * Math.pow(t, 2) + vi * t + xi;
	}

	public static void main(String[] args) {
		double t = 2.0;
		double xi = 0.0;
		double vi = 1.0;
		double finalPosition = calculatePosition(t, xi, vi);

		System.out.println("The object's position after " + t + " seconds is " + finalPosition + " m.");
	}
}
