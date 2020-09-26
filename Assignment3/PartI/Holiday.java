import java.util.*;

public class Holiday {
	private String name;
	private int day;
	private String month;

	public Holiday(String name, int day, String month) {
		this.name = name;
		this.day = day;
		this.month = month;
	}

	public static boolean isSameMonth(Holiday holiday1, Holiday holiday2) {
		return holiday1.month.equals(holiday2.month);
	}

	public static double avgDate(Holiday[] holidays) {
		return (double) Arrays.stream(holidays).mapToInt(holiday -> holiday.day).sum() / holidays.length;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDay() {
		return this.day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String toString() {
		return this.name + ": " + this.month + " " + this.day;
	}

	public static void main(String[] args) {
		Holiday[] holidays = new Holiday[5];
		holidays[0] = new Holiday("May Day", 1, "May");
		holidays[1] = new Holiday("July Day", 23, "July");
		holidays[2] = new Holiday("Feb Day", 12, "Feb");
		holidays[3] = new Holiday("Sep Day", 25, "Sep");
		holidays[4] = new Holiday("Dec Day", 19, "Dec");
		System.out.println(holidays[3]);
		holidays[3].setDay(1);
		System.out.println(holidays[3]);
		System.out.println(avgDate(holidays));

		Holiday independenceDay = new Holiday("Independence Day", 4, "July");
		System.out.println(isSameMonth(independenceDay, holidays[1]));

	}
}
