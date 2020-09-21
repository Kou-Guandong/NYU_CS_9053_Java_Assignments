import java.util.Scanner;

public class MuayThai {

	public static int getMinWeight(int weight) {
		// this takes a weight and returns the "min weight" for the weight class
		if (weight < 0) {
			return -1;
		} else if (weight >= 220) {
			return 220;
		} else if (weight >= 190) {
			return 190;
		} else if (weight >= 183) {
			return 183;
		} else if (weight >= 175) {
			return 175;
		} else if (weight >= 167) {
			return 167;
		} else if (weight >= 160) {
			return 160;
		} else if (weight >= 154) {
			return 154;
		} else if (weight >= 147) {
			return 147;
		} else if (weight >= 140) {
			return 140;
		} else if (weight >= 135) {
			return 135;
		} else if (weight >= 130) {
			return 130;
		} else if (weight >= 126) {
			return 126;
		} else if (weight >= 122) {
			return 122;
		} else if (weight >= 118) {
			return 118;
		} else if (weight >= 115) {
			return 115;
		} else if (weight >= 112) {
			return 112;
		} else {
			return 0;
		}
	}

	public static String getWeightClass(int weight) throws Exception {
		// use a switch statement to assign the correct
		// value to weightClass and return the result
		if (weight < 0) {
			throw new Exception("Invalid weight value");
		}

		String weightClass = null;

		switch (weight) {
			case 220: {
				return "Super heavyweight";
			}
			case 190: {
				return "Heavyweight";
			}
			case 183: {
				return "Cruiserweight";
			}
			case 175: {
				return "Super light heavyweight";
			}
			case 167: {
				return "Light heavyweight";
			}
			case 160: {
				return "Super middleweight";
			}
			case 154: {
				return "Middleweight";
			}
			case 147: {
				return "Super welterweight";
			}
			case 140: {
				return "Welterweight";
			}
			case 135: {
				return "Super lightweight";
			}
			case 130: {
				return "Lightweight";
			}
			case 126: {
				return "Super featherweight";
			}
			case 122: {
				return "Featherweight";
			}
			case 118: {
				return "Super bantamweight";
			}
			case 115: {
				return "Bantamweight";
			}
			case 112: {
				return "Super flyweight";
			}
			case 0: {
				return "Flyweight";
			}
			default:
				return weightClass;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Input weight in pounds: ");
		int pounds = in.nextInt();
		in.close();

		// if pounds is greater than zero
		System.out.println("Weight class for " + pounds + " is ");

		// if for some reason you put in a negative number of pounds:
		if (pounds < 0) {
			System.out.println("Invalid weight value");
			return;
		}

		int minWeight = getMinWeight(pounds);
		try {
			String weightClass = getWeightClass(minWeight);
			System.out.println("Weight class is: " + weightClass);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
