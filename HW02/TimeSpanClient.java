/* Khalid Elhousieny 
 * HW02
 * CS 211 James Livingston 
 * April 24th 2021
 * 
 * A client program that tests out the compareTo method from the TimeSpan class
 * The compareTo method will compare two time-spans to each other and return the appropriate value and sign
 * This test client will create multiple instances of the TimeSpan class and use the compareTo method to compare those objects
 */

public class TimeSpanClient {
    public static void main(String[] args) {
	
	// Creating instances of the TimeSpan class
	TimeSpan s1 = new TimeSpan(3, 20);
	TimeSpan s2 = new TimeSpan(1, 20);
	TimeSpan s3 = new TimeSpan(5, 25);
	TimeSpan s4 = new TimeSpan(5, 25);
	
	// Test for objects with different times
	System.out.println("Test for objects with different times");
	
	// Spacers
	System.out.println();
	
	System.out.println("Time Span 1: " + s1); // Will print out the instance of s1. "Time Span 1: 2h 59m"
	System.out.println("Time Span 2: " + s2); // Will print out the instance of s2. "Time Span 2: 1h 20m"
	System.out.println("s1.compareTo(s2) = " + s1.compareTo(s2) + "m"); // Will compare time span 1 to time span 2 and print out "s1.compareTo(s2) = 120m". It is +120 because the s1 Time Span is greater than s2
	System.out.println("s2.compareTo(s1) = " + s2.compareTo(s1) + "m"); // Will compare time span 2 to time span 1 and print out "s2.compareTo(s1) = -120m" It is -120 because the s2 Time Span is less than s2
	
	// Spacers
	System.out.println();
	
	// Test for objects with the same times
	System.out.println("Test for objects with the same times");
	
	// Spacers
	System.out.println();
	
	System.out.println("Time Span 3: " + s3); // Will print out the instance of s3. "Time Span 3: 5h 25m"
	System.out.println("Time Span 4: " + s4); // Will print out the instance of s4. "Time Span 4: 5h 25m"
	System.out.println("s3.compareTo(s4) = " + s3.compareTo(s4)); // Will compare time span 3 to time span 4 and print out "s3.compareTo(s4) = 0". It is 0 since both Time Spans are the same
	System.out.println("s4.compareTo(s3) = " + s4.compareTo(s3)); // Will compare time span 4 to time span 3 and print out "s4.compareTo(s3) = 0". It is 0 since both Time Spans are the same

	// Spacers
	System.out.println("_________________________________");
    }
}
