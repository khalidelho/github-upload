package HW02;

/*  Khalid Elhousieny 
 * HW02
 * CS 211 James Livingston 
 * April 24th 2021
 * 
 * A client program that tests out the compareTo method in the Point class which compares two points to each other 
 * First I will show an example of coordinates with different Y values 
 * Next will be coordinates with the same Y values which will then test the X values 
 */

public class PointMainMin {
    public static void main(String[] args) { 
	
	// Creating instances of the Point class
	Point p1 = new Point(7, 2);
	Point p2 = new Point(4, 3);
	Point p3 = new Point(10, 5);
	Point p4 = new Point(3, 5);

	// Testing Y coordinates with different values
	System.out.println("Points with different Y values");
	System.out.println();
	
	System.out.println("p1 is " + p1); // Displays p1 to the console. Will display "p1 is (7, 2)"
	System.out.println("p2 is " + p2); // Displays p2 to the console. Will display "p2 is (4, 3)"
	
	// Spacer
	System.out.println();
	
	// Compares p1 to p2 using newly written method
	System.out.println("p1.compareTo(p2) = " + p1.compareTo(p2)); // Will return -1 because p1 is less than p2
	System.out.println("p1.compareTo(p1) = " + p1.compareTo(p1)); // Will return 0 because p1 is the same as p1
	System.out.println("p2.compareTo(p1) = " + p2.compareTo(p1)); // Will return 1 because p2 is less than p1
	
	// Spacers
	System.out.println("_________________________________");
	System.out.println();
	
	// Testing Y coordinates with the same values
	System.out.println("Points with the same Y values");
	System.out.println();
	
	System.out.println("p3 is " + p3); // Displays p3 to the console. Will display "p3 is (10, 5)"
	System.out.println("p4 is " + p4); // Displays p4 to the console. Will display "p4 is (3, 5)"
	
	// Spacer
	System.out.println();
	
	// Will test for Y value first, once it sees they have the same value it will compare the X values.
	System.out.println("p3.compareTo(p4) = " + p3.compareTo(p4)); //  It will return 7 because p3 has a X value that is greater than  and 7 away from p4's X value.
	System.out.println("p4.compareTo(p4) = " + p4.compareTo(p4)); //  It will return 0 because p4 the same X value as p4
	System.out.println("p4.compareTo(p3) = " + p4.compareTo(p3)); //  It will return -7 because p4 has a X value that is less than and 7 away from p3's X value.
    }
}
