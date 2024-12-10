package AssignmentsWeek1;

public class CheckNumberIsPositive {
	// Global variable
	int version = -5; // tested with 10, -1, 0

	// Method for positive checker
	public void positiveNumChecker() {
		if (version > 0) {
			System.out.println("Given number " + version + " is a positive number");
		} else {
			System.out.println("Given number " + version + " is not positive number");
		}
	}

	// Main method
	public static void main(String[] args) {
		CheckNumberIsPositive positiveCheck = new CheckNumberIsPositive();
		positiveCheck.positiveNumChecker();
		System.out.println(" The method executed successfully");
	}

}
