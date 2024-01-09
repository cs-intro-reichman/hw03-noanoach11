/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	static int SundayCount = 0;
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
	    int debugDaysCounter = 0; 
	    //// Write the necessary initialization code, and replace the condition
	    //// of the while loop with the necessary condition 
	 	while ( month<13 && year<=1999 && dayOfMonth<=31) {
	 		System.out.print(dayOfMonth + "/" + month + "/" + year + "  " + dayOfWeek);

			if (dayOfWeek==1) {
				System.out.print(" Sunday");
				if (dayOfMonth==1){
					SundayCount++;
				}
			}
			System.out.println();
			advance();

			debugDaysCounter++;
			if (debugDaysCounter==3000) { 
	 			break;
	 		}
		}	
		System.out.println("During the 20th century, " + SundayCount + " Sundays fell on the first day of the month");	
	 		//// If you want to stop the loop after n days, replace the condition of the
	 		//// if statement with the condition (debugDaysCounter == n)
	 		
        }
	
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		
		if (dayOfMonth<=nDaysInMonth(month,year)){
			if (month==12 && dayOfMonth==nDaysInMonth(month,year) &&  year<1999) {
			year++;
			month=1;
			dayOfMonth=1;
			}

				dayOfMonth++;
			 if (dayOfMonth>nDaysInMonth(month,year) && month<12){
				month++;
				dayOfMonth=1;
			}
			

			if (dayOfWeek<7){
				dayOfWeek++;
			}else {
				dayOfWeek= 1;
			}	
		}
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear (int year) {
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
	private static int nDaysInMonth(int month, int year) {
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


