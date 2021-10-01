/*
 * Khalid Elhousieny 
 * CS211 HW01 (Chapter 9, work exercise 5,6,7,8)
 * 4/15/2021
 * This class will include a set price for the Walk-up Tickets as well as inherit methods from the Ticket superclass
 */

public class WalkupTicket extends Ticket {

    public WalkupTicket() { // Constructor that sets an initial value for Walk-up ticket
	this(0);
    }

    public WalkupTicket(int ticketNumber) { // Constructor with parameter value
	super(ticketNumber); // Updates ticket number in the super constructor
    }

    public double getPrice() { // Method to return the price of Walk-up ticket overwriting the getPrice method in the super class
	return 50.0;
    }

}
