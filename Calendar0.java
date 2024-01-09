/*
 * Checks if a given year is a leap year or a common year,
 * and computes the number of days in a given month and a given year. 
 */
public class Calendar0 {	
	
	// Gets a year (command-line argument), and tests the functions isLeapYear and nDaysInMonth.
	public static void main(String args[]) {
		int year = Integer.parseInt(args[0]);
		isLeapYearTest(year);
		nDaysInMonthTest(year);
	}
		 
	// Tests the isLeapYear function.
	private static void isLeapYearTest(int year) {
		String commonOrLeap = "common";
		if (isLeapYear(year)) {
			commonOrLeap = "leap";
		}
		System.out.println(year + " is a " + commonOrLeap + " year");  
	}

	// Tests the nDaysInMonth function.
	private static void nDaysInMonthTest(int year) {
		for (int month =1; month<=12; month++){
			nDaysInMonth(month,year);
			System.out.println("Month "+ month + " has " + nDaysInMonth(month,year) + " days");
		}
	}

	// Returns true if the given year is a leap year, false otherwise.
	public static boolean isLeapYear(int year) {

	    if (year%400==0 || (year%4==0 && year%100!=0)){
			return true;
		}else{
			return false;
		}
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	public static int nDaysInMonth(int month, int year) {
		int numOfDays = 0;

		/// months with 31 days
		if (month==1){
			numOfDays = 31;
		}
		if (month==3){
			numOfDays = 31;
		}
		if (month==5){
			numOfDays = 31;
		}
		if (month==7){
			numOfDays = 31;
		}
		if (month==8){
			numOfDays = 31;
		}
		if (month==10){
			numOfDays = 31;
		}
		if (month==12){
			numOfDays = 31;
		}

		/// checking if febuary id leap or not

		if (month==2){
			if (isLeapYear(year)){
				numOfDays = 29;
			} else {
				numOfDays = 28;
			}
		}

		/// months with 30 days
		if (month==4){
			numOfDays = 30;
		}
		if (month==6){
			numOfDays = 30;
		}
		if (month==9){
			numOfDays = 30;
		}
		if (month==11){
			numOfDays = 30;
		}


		return numOfDays;
	}
}
