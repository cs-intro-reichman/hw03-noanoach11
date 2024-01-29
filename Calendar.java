public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	public static void main(String args[]) {
        int givenYear = Integer.parseInt(args[0]);

        ///not advencing the day of the week correctly
	 	while ( month<=12 && year<givenYear && dayOfMonth<=31) {
			advance();
		}

        while ( month<=12 && dayOfMonth<=31 && givenYear==year) {

            System.out.print(dayOfMonth + "/" + month + "/" + year);
           if (dayOfWeek==1) {
               System.out.print(" Sunday");
           }
           System.out.println();
           advance();
       }	
    }
	
	 private static void advance() {
	 // # feedback: try to use correct indentation, this will help the code for better readability.
         if (dayOfMonth<=nDaysInMonth(month,year)){
			dayOfMonth++;
		}

        if (month==12 && dayOfMonth>nDaysInMonth(month,year)) {
			year++;
			month=1;
			dayOfMonth=1;
		}

		
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


