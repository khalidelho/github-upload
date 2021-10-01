/*
 * Khalid Elhousieny 
 * CS211 HW01 (Chapter 9, work exercise 5,6,7,8)
 * 4/15/2021
 * This class will act as the superclass and include basic methods that will be inherited by the rest of the classes. 
 */
public class Ticket {
    
    // Declaring private field variables that can only be used in this class.
    private int ticketNumber; // The unique number that each ticket has
    private double price; // The price that each ticket costs

    public Ticket(int ticketNumber) { // Constructor with ticket number parameter which will be updated every time a subclass has a ticket number input and gets called
	this.ticketNumber = ticketNumber;
    }

    // Accessor method
    public double getPrice() { // Get method to return price of ticket as a decimal
	return price;
    }

    // To String method
    public String toString() { // Method that returns price and number of ticket as String
	return "Number: " + this.ticketNumber + ", Price: " + this.getPrice();
    }
}
