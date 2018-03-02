public class CalendarDate implements Comparable<CalendarDate> {
	private int month;
	private int day;
	private int year;

	public CalendarDate(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}

	// leap years are divisible by 4 but not 100 or are divisible by 400
	// or || and && divisible % not !
	// 10 % 5 == 0;
	// 10 % 4 == 2;

	public boolean isLeapYear() {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValidDate() {

		return false;
	}

	// Compares this calendar date to another date.
	// Dates are compared by month and then by day.
	public int compareTo(CalendarDate other) {
		if (this.year != other.year) {
			return this.year - other.year;
		} else if (this.month != other.month) {
			return this.month - other.month;
		} else {
			return this.day - other.day;
		}
	}

	public int getMonth() {
		return this.month;
	}

	public int getDay() {
		return this.day;
	}

	public int getYear() {
		return this.year;
	}

	public String toString() {
		return this.month + "/" + this.day + "/" + this.year;
	}
}
