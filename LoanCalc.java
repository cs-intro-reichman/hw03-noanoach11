/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation
	
    /** 
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).  
     */
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
	
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
	/**
	* Uses a sequential search method  ("brute force") to compute an approximation
	* of the periodical payment that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    
	double loanKeep = loan;	
	double increment = 0.001;
	double annualPay = (loan/n)+0.001;
	iterationCounter = 0;

	while (loan>epsilon) {
		loan = loanKeep;
		for (int i=0; i<n; i++){
			loan =(loan-annualPay)*((rate/100)+1);
		}
		annualPay += increment;
		iterationCounter++;
	}

	if (annualPay > loanKeep) {
		System.out.println("Failed to find a solution" + annualPay);
	}
		return annualPay;
    }
    
    /**
	* Uses bisection search to compute an approximation of the periodical payment 
	* that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
    	double loanKeep = loan;	
		double upperBound = loan; 
		double lowerBound = 0;
		double annualPay = 0;
		iterationCounter = 0;

	while (upperBound-lowerBound>=epsilon) {
		annualPay = ((lowerBound+upperBound)/2);
		loan = loanKeep;

		if (endBalance(loan, rate, n, annualPay)>0){
			lowerBound = annualPay;
		}

		if(endBalance(loan, rate, n, annualPay)<0){
			upperBound= annualPay;
		}

		iterationCounter++;	
	}

	if (annualPay > loanKeep) {
		System.out.println("Failed to find a solution" + annualPay);
	}

		return annualPay;
    }
	
	
	private static double endBalance(double loan, double rate, int n, double annualPay) {
		for (int i=0; i<n; i++){
			loan =(loan-annualPay)*((rate/100)+1);
		}
    	return loan;
	}
}