package HW02;

/* Khalid Elhousieny 
 * HW02
 * CS 211 James Livingston 
 * April 24th 2021
 * 
 * This class will be used as the point class for exercises 19 and 20 for HW02
 * It will implement the comparable interface and add a comparable method 
 * to compare Y coordinates and return a value based on if the value is greater than or less than another Y coordinate
 * 
 * A Point object represents a pair of (x, y) coordinates. 
 * Class invariant: x >= 0 && y >= 0. (Quadrant I only) 
 */

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    // Constructs a new point at the given (x, y) location.
    // pre: x >= 0 && y >= 0
    public Point(int x, int y) {
	if (x < 0 || y < 0) {
	    throw new IllegalArgumentException();
	}
	this.x = x;
	this.y = y;
    }

    // Constructs a new point at the origin, (0, 0).
    public Point() {
	this(0, 0); // calls Point(int, int) constructor }
    }

    // Returns the distance between this Point and (0, 0).
    public double distanceFromOrigin() {
	return Math.sqrt(x * x + y * y);
    }

    // Returns whether o refers to a point with the same (x, y)
    // coordinates as this point. Robust version.
    public boolean equals(Object o) {
	if (o instanceof Point) {
	    Point other = (Point) o;
	    return this.x == other.getX() && this.y == other.getY();
	} else { // not a Point object
	    return false;
	}
    }

    // Returns the x-coordinate of this point.
    public int getX() {
	return this.x;
    }

    // Returns the y-coordinate of this point.
    public int getY() {
	return this.y;
    }

    // Returns a String representation of this point.
    public String toString() {
	return "(" + this.x + ", " + this.y + ")";
    }

    // Returns a new point, shifted from this one by dx and dy.
    // pre: x + dx >= 0 && y + dy >= 0
    public Point translate(int dx, int dy) {
	return new Point(this.x + dx, this.y + dy);
    }

    /*
     * This comparable method will first test to see if the Y component of each
     * point is not equal to each other. If that is true then it will calculate the
     * difference and return the appropriate value along with a + or - If the Y's
     * are the same then it will test the X coordinates as a tie breaker If the X
     * coordinates do not equal each other than it will return the difference If any
     * points are the same it will return 0
     */
    public int compareTo(Point other) {
	if (this.y != other.y) { // If statement will check if the y of the first point is not equal to the y of the second point
	    return this.y - other.y; // If the Y's do not equal each other then it will return the difference with the appropriate sign indicating either greater than or less than
	} else {
	    if (this.x != other.x) { // If the Y's equal each other then the method will test the X coordinates. If the X coordinates do not equal each other
		return this.x - other.x; // Then it will return the difference with the appropriate sign
	    }
	}
	return 0; // If either point equals the other point then it will return 0
    }
}
