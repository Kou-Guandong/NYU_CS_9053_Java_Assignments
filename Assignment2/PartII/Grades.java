import java.util.Scanner;

public class Grades {

	public static String letterGrade(float score) {
		if (score > 100 || score < 0) {
			return null;
		} else if (score >= 90) {
			return "A";
		} else if (score >= 80) {
			return "B";
		} else if (score >= 70) {
			return "C";
		} else if (score >= 60) {
			return "D";
		} else {
			return "F";
		}
	}

	public static void main(String[] args) {
		/*
		 * you probably want to use user input for the score using Scanner because you
		 * will have to convert a command line argument to a float, and we haven't
		 * gotten to string parsing yet
		 * 
		 * But you can also just set the "score" variable to whatever you want in the
		 * code, and that's fine too
		 */
		Scanner input = new Scanner(System.in);
		float score = input.nextFloat();
		input.close();
		String grade = letterGrade(score);
		// if the grade is not null print this out:
		if (grade != null) {
			System.out.println("The grade for a score of " + score + " is " + grade);
		} else {
			// if the grade is null, print this out:
			System.out.println("invalid score");
		}
	}
}
