/* Khalid Elhousieny 
 * HW02
 * CS 211 James Livingston 
 * April 24th 2021
 * 
 * This class will be used as the TimeSpan class for exercises 19 and 20 for HW02
 * It will implement the comparable interface and add a comparable method 
 * to the time spans to each other and compare if each one has a greater or shorter length than the other
 */

public class TimeSpan implements Comparable<TimeSpan> {
    private int totalMinutes;

    // Constructor that initializes the hours and minutes parameters to 0 if nothing is entered from the client class
    public TimeSpan() {
    this(0,0);
    }

    // Constructs a time span with the given interval.
    // pre: hours >= 0 && minutes >= 0
    public TimeSpan(int hours, int minutes) {
	totalMinutes = 0;
	add(hours, minutes);
    }

    // Adds the given interval to this time span.
    // pre: hours >= 0 && minutes >= 0
    public void add(int hours, int minutes) {
	totalMinutes += 60 * hours + minutes;
    }

    // Returns a String for this time span such as "6h15m".
    public String toString() {
	return (totalMinutes / 60) + "h " + (totalMinutes % 60) + "m";
    }

    // Method that will compare time spans to each other and output the appropriate symbol and value
    public int compareTo(TimeSpan other) {
	if (this.totalMinutes != other.totalMinutes) { // If total minutes of first time-span is not equal to total minutes of the time-span it getting compared to
	    return this.totalMinutes - other.totalMinutes; // Then it will return the difference between them with the appropriate sign indicating if it is greater than or less than
	} else {
	    return 0; // If both time spans are equal then it will return 0
	}
    }
}
