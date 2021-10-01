/*
 * Khalid Elhousieny 
 * CS211 HW01 (Chapter 9, work exercise 5,6,7,8)
 * 4/15/2021
 * This is class is a subclass of the AdvanceTicket class. It takes into account customers who order tickets ahead of time but modifies it by adding the student discount when ID is shown
 */
public class StudentAdvanceTicket extends AdvanceTicket {

    //Constructor that initializes the number of the ticket as well as the number of days by calling onto the second constructor which calls the super constructor
    public StudentAdvanceTicket() { 
	this(0, 0);
    }

    // Constructor that passes the ticketNumber and the day to the AdvanceTicket class
    public StudentAdvanceTicket(int ticketNumber, int day) {
	super(ticketNumber, day);
    }

    // Accessor Method 
    public double getPrice() {// Method that returns the price of the Ticket ordered in advance by students. The difference between this and AdvanceTicket is the student discount which is 50% of regular price.
	//if else statement to correctly return the price based on the number of days in advance the ticker was ordered
	if (super.getDays() > AdvanceTicket.NUMBER_OF_DAYS) { //The reason I use AdvanceTicket instead of "super" is because the constants are static variables and by convention the class name should be called then the variable name
	    return AdvanceTicket.GREATER_THAN_TEN_DAYS_PRICE / 2; // Could also write super.GREATER_THAN_TEN_DAYS_PRICE. This line calls the constant variable in the super class and divides it by 2 for student price
	} else {
	    return AdvanceTicket.LESS_THAN_TEN_DAYS_PRICE / 2; // Could also write super.LESS_THAN_TEN_DAYS_PRICE.
	}
    }

    // To String method
    public String toString() { // Method that returns price and number of ticket as String by adding onto the toString method in the super class
	return super.toString() + " (ID Required)";
    }

}
