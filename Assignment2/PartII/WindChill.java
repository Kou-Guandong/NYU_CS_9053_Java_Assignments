import java.util.Scanner;

public class WindChill {

	public static double windChill(double temp, double windSpeed) throws Exception {
		if (temp > 50 || temp < -50 || windSpeed > 110 || windSpeed < 3) {
			throw new Exception("Cannot calculate a valid wind chill for this temperate and/or wind speed");
		} else {
			return 35.74 + 0.6215 * temp + (0.4275 * temp - 35.75) * Math.pow(windSpeed, 16);
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the value of temp (F): ");
		double temp = input.nextDouble();
		System.out.println("Please enter the value of wind speed (miles per hour): ");
		double windSpeed = input.nextDouble();
		input.close();
		try {
			double windChillTemp = windChill(temp, windSpeed);
			System.out.println("For a temperature of " + temp + " with wind speed of " + windSpeed
					+ ", the wind chill is " + windChillTemp);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
