/*
 * Khalid Elhousieny 
 * CS211 HW01 (Chapter 9, work exercise 5,6,7,8)
 * This class determines the price of the tickets if the customer is buying the tickets in advance. It is also setting constant variables that will be used in the StudentAdvanceTicket class
 */
public class AdvanceTicket extends Ticket {

    // Constant variables that define the number of days we will be comparing against in the getPrice method
    public static final int NUMBER_OF_DAYS = 10; //The set number of days I will be comparing the days input variable too
    public static final int GREATER_THAN_TEN_DAYS_PRICE = 30; // Price for tickets ordered 10 days or more from the day of the event
    public static final int LESS_THAN_TEN_DAYS_PRICE = 40; // Price for tickets ordered 10 days or less from the day of the event
    private int days;

    // Constructor that initializes the days and value parameters to 0 if nothing is entered from the client class
    public AdvanceTicket() {
	this(0, 0);
    }

    // Second constructor that initializes the value param through the super class Ticket and also sets the number of days
    public AdvanceTicket(int ticketNumber, int day) {
	super(ticketNumber);
	this.days = day;
    }

    // Accessor methods this method will be used to call on the number of days the customer is ordering ahead.
    public int getDays() {
	return days;
    }

    public double getPrice() {// This method will call on the getPrice method in the super class and add the correct price of advanced tickets for the method to return
	//if else statement to correctly return the price based on the number of days in advance the ticker was ordered
	if (days > NUMBER_OF_DAYS) {
	    return GREATER_THAN_TEN_DAYS_PRICE;
	} else {
	    return LESS_THAN_TEN_DAYS_PRICE;
	}
    }

}
