/*
* Khalid Elhousieny
* CS 211 (C) James Livingston
* May 27th 2021
* HW07
* 
* Class LinkedIntList can be used to store a list of integers.
* This class will also contain the solutions to exercises #8, 12 from Ch.16
* 
* The first exercise #8 is a method called switchPairs. This method will switch the order 
* of the values in the list in a pairwise fashion. The method will switch the order of the 
* first two values, then switch the order of the next two, switch the order of the next two, 
* and so on. If the list contains an odd number of values, the final element is not moved. 
* Example if the list initially stores [10, 25, 31, 47, 52, 68, 77] the method will switch 
* the first pair (10 and 25) the second pair (31 and 47) and the third pair to output [25, 10, 47, 31, 68, 52, 77]
* 
* The second exercise #12 is a method called split. This method will rearrange the elements
* of a list so that all of the negative values appear before all of the nonnegative numbers. 
* Example a variable list stores [8, 7, -4, 19, 0, 43, -8, -7, 2]. Calling list.split() will 
* rearrange the list to output [-7, -8, -4, 8, 7, 19, 0, 43, 2]. This method will be solved
* by rearranging the links of the list. 
 */

public class LinkedIntList implements IntList {
    private ListNode front; // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
	front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
	int count = 0;
	ListNode current = front;
	while (current != null) {
	    current = current.next;
	    count++;
	}
	return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
	return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
	if (front == null) {
	    return "[]";
	} else {
	    String result = "[" + front.data;
	    ListNode current = front.next;
	    while (current != null) {
		result += ", " + current.data;
		current = current.next;
	    }
	    result += "]";
	    return result;
	}
    }

    // post : returns the position of the first occurrence of the given
    // value (-1 if not found)
    public int indexOf(int value) {
	int index = 0;
	ListNode current = front;
	while (current != null) {
	    if (current.data == value) {
		return index;
	    }
	    index++;
	    current = current.next;
	}
	return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
	if (front == null) {
	    front = new ListNode(value);
	} else {
	    ListNode current = front;
	    while (current.next != null) {
		current = current.next;
	    }
	    current.next = new ListNode(value);
	}
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
	if (index == 0) {
	    front = new ListNode(value, front);
	} else {
	    ListNode current = nodeAt(index - 1);
	    current.next = new ListNode(value, current.next);
	}
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
	if (index == 0) {
	    front = front.next;
	} else {
	    ListNode current = nodeAt(index - 1);
	    current.next = current.next.next;
	}
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
	ListNode current = front;
	for (int i = 0; i < index; i++) {
	    current = current.next;
	}
	return current;
    }

    /*
     * Exercise #8: This method will switch the order of values in the list in a
     * pairwise fashion. It will do that by using a main for loop to traverse
     * through the list then an if statement will take into account if the list has
     * an odd number of elements once that is true the first and second node will be
     * saved in two separate variables. Then it will remove the two nodes and add
     * them back in reverse order.
     */
    public void switchPairs() {
	for (int i = 0; i < size() - 1; i += 2) {
	    if (i != size() - 1) { // Accounts for the possibility that the list has an odd number of elements
		// Gets the values of the two nodes
		int node1 = nodeAt(i).data;
		int node2 = nodeAt(i + 1).data;
		remove(i); // Will remove node 1
		remove(i); // Will remove node 2
		add(i, node2); // Will add node 2 back first
		add(i + 1, node1); // Will add node 1 back
	    }
	}
    }

    /*
     * Exercise #12: Rearranges the elements of a list so that all of the negative
     * values appear before all of the nonnegatives. It will do that by first
     * checking if the node we are looking at is not null. If it passes then it will
     * go through a while loop which will parse through the entire LinkedIntList. An
     * if statement will test if the data in the next node is negative in that case
     * it will create a var temp which will be switch the nodes with the front. If
     * it is positive then it will move it through the list since a switch will not
     * be needed.
     */
    public void split() {
	ListNode viewing = front;
	if (viewing != null) { // Tests if either the LinkedIntList is empty of if the
	    while (viewing.next != null) { // Parses through the entire LinkedIntList
		if (viewing.next.data < 0) { // Tests the case in which the links would need to be switched
		    // Switches the nodes
		    ListNode tempNode = viewing.next.next; // sets tempNode to front.next.next
		    viewing.next.next = front; // Then refers the front.next.next to front
		    front = viewing.next; // now front will be set to front.next
		    viewing.next = tempNode; // finally will refer front.next to tempNode
		} else {
		    viewing = viewing.next; // Moves through the LinkedIntList if a switch is not necessary
		}
	    }
	}
    }
}
