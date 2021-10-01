/*
 * Khalid Elhousieny 
 * CS211 HW01 (Chapter 9, work exercise 5,6,7,8)
 * 4/15/2021
 * This program considers the task of representing types of tickets to campus events. 
 * Each ticket has a unique number and a price. 
 * There are three types of tickets: walk-up tickets, advance tickets, and student advance tickets.
 * This is the Client Test class with the main method where we run input different numbers to test the ticket classes I wrote
 */
public class TicketClient {

    public static void main(String[] args) {
	// Client test for tickets
	
	Ticket t1 = new WalkupTicket(1); //Testing the WalkupTicket class by entering a ticket number of 1
	System.out.println("Testing Walk-up Ticket");
	System.out.println(t1); //The output will be "Number: 1, Price: 50.0"
	
	System.out.println("__________________________________");
	System.out.println();
	
	Ticket t2 = new AdvanceTicket(2, 14); //Testing the AdvanceTicket class by entering a ticket number of 2 and setting number of days to 14
	System.out.println("Testing Advance Ticket: more than 10 days");
	System.out.println(t2); //The output will be "Number: 2, Price: 30.0"
	
	System.out.println("__________________________________");
	System.out.println();
	
	Ticket t3 = new AdvanceTicket(3, 6); //Testing the AdvanceTicket class by entering a ticket number of 3 and setting number of days to 6
	System.out.println("Testing Advance Ticket: less than 10 days");
	System.out.println(t3); //The output will be "Number: 3, Price: 40.0"
	
	System.out.println("__________________________________");
	System.out.println();
	
	Ticket t4 = new StudentAdvanceTicket(4, 13); //Testing the StudentAdvanceTicket class by entering a ticket number of 4 and setting number of days to 13
	System.out.println("Testing Student Advance Ticket: more than 10 days");
	System.out.println(t4); //The output will be "Number: 4, Price: 15.0 (ID Required)"
	
	System.out.println("__________________________________");
	System.out.println();
	
	Ticket t5 = new StudentAdvanceTicket(5, 5); //Testing the StudentAdvanceTicket class by entering a ticket number of 5 and setting number of days to 5
	System.out.println("Testing Student Advance Ticket: less than 10 days");
	System.out.println(t5); //The output will be "Number: 5, Price: 20.0 (ID Required)"

    }

}
