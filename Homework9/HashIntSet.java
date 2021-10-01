/*
 * Khalid Elhousieny 	
 * CS 211 (C) James Livingston 
 * June 13th 2021
 * HW09
 * 
 * Implements a set of integers using a hash table.// The hash table uses separate chaining to resolve collisions.
 * 
 * Exercise #1 addAll will accept another Hash Set as a parameter and adds all of the elements from 
 * the other set into current set. For example, if the set stores [-5, 1, 2, 3] and the method is passed [2, 3, 6, 44, 79], 
 * the set would store [-5, 1, 2, 3, 6, 44, 79]
 * 
 * Exercise #2 containsAll will accept another has set as a parameter and returns true if the set contains every element from the other set. 
 * For example, if the set stores [-2, 3, 5, 6, 8] and the method is passed [3, 6, 8], the method would return true. If the method were passed [3, 6, 7, 8]
 * the method will return false because the set does not contain the value 7.
 * 
 * Exercise #3 equals will accept another has set as a parameter and return true if the two sets contain exactly the same elements. 
 * The internal has table size and ordering of the elements does not matter, only the sets of elements themselves.
 * 
 * Exercise #9 kthSmallest will accept a PriortyQueue of integers and an integer k as a parameter and returns the kth-smallest integer from the priority queue
 * For example, if  the queue passed stores the integers [42, 50, 45, 78, 61] and k is 4, it will return the fourth-smallest integer, which is 61. if k is 0 or 
 * negative or greater than the size of the queue, it will throw and IllegalArgumentException. The method will also contain a stack as an auxiliary storage.
 * 
 * Exercise #11 removeSuplicates will accept a PriortyQueue of integers as a parameter and will modify the queue's state so that any elements that is equal 
 * to another element in the queue is removed. For example, if the queue stores [7, 7, 8, 8, 8, 10, 45, 45], the method will modify the queue to store [7, 8, 10, 45]
 * The method will use a stack as an auxiliary storage.
 */

public class HashIntSet {
    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry[] elementData;
    private int size;

    // Constructs an empty set.
    public HashIntSet() {
	elementData = new HashEntry[10];
	size = 0;
    }

    // Adds the given element to this set, if it was not already
    // contained in the set.
    public void add(int value) {
	if (!contains(value)) {
	    if (loadFactor() >= MAX_LOAD_FACTOR) {
		rehash();
	    }

	    // insert new value at front of list
	    int bucket = hashFunction(value);
	    elementData[bucket] = new HashEntry(value, elementData[bucket]);
	    size++;
	}
    }

    // Removes all elements from the set.
    public void clear() {
	for (int i = 0; i < elementData.length; i++) {
	    elementData[i] = null;
	}
	size = 0;
    }

    // Returns true if the given value is found in this set.
    public boolean contains(int value) {
	int bucket = hashFunction(value);
	HashEntry current = elementData[bucket];
	while (current != null) {
	    if (current.data == value) {
		return true;
	    }
	    current = current.next;
	}
	return false;
    }

    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
	return size == 0;
    }

    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    public void remove(int value) {
	int bucket = hashFunction(value);
	if (elementData[bucket] != null) {
	    // check front of list
	    if (elementData[bucket].data == value) {
		elementData[bucket] = elementData[bucket].next;
		size--;
	    } else {
		// check rest of list
		HashEntry current = elementData[bucket];
		while (current.next != null && current.next.data != value) {
		    current = current.next;
		}

		// if the element is found, remove it
		if (current.next != null && current.next.data == value) {
		    current.next = current.next.next;
		    size--;
		}
	    }
	}
    }

    // Returns the number of elements in the queue.
    public int size() {
	return size;
    }

    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
	String result = "[";
	boolean first = true;
	if (!isEmpty()) {
	    for (int i = 0; i < elementData.length; i++) {
		HashEntry current = elementData[i];
		while (current != null) {
		    if (!first) {
			result += ", ";
		    }
		    result += current.data;
		    first = false;
		    current = current.next;
		}
	    }
	}
	return result + "]";
    }

    // Returns the preferred hash bucket index for the given value.
    private int hashFunction(int value) {
	return Math.abs(value) % elementData.length;
    }

    private double loadFactor() {
	return (double) size / elementData.length;
    }

    // Resizes the hash table to twice its former size.
    private void rehash() {
	// replace element data array with a larger empty version
	HashEntry[] oldElementData = elementData;
	elementData = new HashEntry[2 * oldElementData.length];
	size = 0;

	// re-add all of the old data into the new array
	for (int i = 0; i < oldElementData.length; i++) {
	    HashEntry current = oldElementData[i];
	    while (current != null) {
		add(current.data);
		current = current.next;
	    }
	}
    }

    /*
     * Solution for exercise #1 this method will store all of the elements of a
     * given set into the current set it will do that by having a for loop iterate
     * through the elements of the parameter set. Then it will have an element
     * variable of the HashEntry class which set the elements to the parameter set.
     * Then a while loop will make sure that the elements exist and then will use
     * the add method from this class to add the elements to one set
     */
    public void addAll(HashIntSet parameterSet) {
	for (int i = 0; i < parameterSet.elementData.length; i++) { //for loop to iterate through param set
	    HashEntry element = parameterSet.elementData[i]; // element instance created to set to the param set values
	    while (element != null) { // while loop detecting whether the element exists 
		this.add(element.data); // will add the element data to the set 
		element = element.next; // will grab the next element
	    }
	}
    }

    /*
     * Solution for exercise #2 this method will return either a true or false
     * depending on whether the parameter set contains the values of another set. It
     * will accomplish that by having a for loop iterate through the elements of the
     * parameter set then an element of the HasEntry class will gather each element
     * of the parameter set. Then while loop will check if the element exists and
     * will have an if statement that checks if the set contains all the elements of
     * the parameter set. If not then it will return false else it will return true.
     */
    public boolean containsAll(HashIntSet parameterSet) {
	for (int i = 0; i < parameterSet.elementData.length; i++) { // for loop to iterate through param set 
	    HashEntry element = parameterSet.elementData[i]; // element instance created to set to the param set values
	    while (element != null) {// while loop detecting whether the element exists 
		if (this.contains(element.data) == false) { // if statement to see whether the set contains does not contain a specific element 
		    return false; // returns false when true 
		}
		element = element.next; // moves onto next element
	    }
	}
	return true; // returns true if the param set is contained within another set
    }

    /*
     * Solution for exercise #3 this method will return either true or false
     * depending in whether the parameter set equals another set. It will do that by
     * first checking the lengths of the two sets if they are the same lengths then
     * we move on and use the conatinsAll method from this class to see if all the
     * values are the same. If they are it will return true if not false
     */
    public boolean equals(HashIntSet parameterSet) {
	/*
	 Will return true or false based on if the set passes these two statements
	 first statement is if both sets have the same length 
	 second is if all the same values are within both sets 
	 */
	return (this.elementData.length == parameterSet.elementData.length) && this.containsAll(parameterSet);
    }

    // Represents a single value in a chain stored in one hash bucket.
    private class HashEntry {
	public int data;
	public HashEntry next;

	public HashEntry(int data) {
	    this(data, null);
	}

	public HashEntry(int data, HashEntry next) {
	    this.data = data;
	    this.next = next;
	}
    }
}
