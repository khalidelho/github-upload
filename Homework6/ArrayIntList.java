/*
 * Khalid ELhousieny 
 * CS 211 (C) James Livingston
 * MAY 20th 2021
 * HW06
 * 
 * The class will have solutions to exercises #1,2,5,8,11 from chapter 15
 * 
 * The first method for exercise #1 lastIndexOf. This method will accept an integer as a 
 * parameter and will return the index in the list of the last occurrence of that the param value. 
 * Or it will return -1 if the value is not found in the list. For example a list [1, 18, 2, 7, 18, 39, 18, 40]
 * a param of 18 is passed will return 6. If a param of 3 is passed in it returns -1. 
 * 
 * The second method for exercise #2 indexOfSubList will accept a list L as a parameter and return the starting index
 * of where L first appears in this list, it will return -1 if the value is not found All elements of L will appear in 
 * sequence and in the same order. Example if variables list1 and list2 store [11, -7, 3, 42, 0, 14] and [3, 42, 0]
 * respectively the call list1.indexOfSubList(list2) will return 2.
 * 
 * The third method for exercise #5 runningTotal which will return a new ArrayIntList that contains a running total
 * of the original list. The ith value in the new list should store the sum of the elements 0 through i of the original list.
 * a list storing [2, 3, 5, 4, 7, 15, 20, 7] then called ArrayIntList list2 = list.runningTotal(); list2 will become 
 * [2, 5, 10, 14, 21, 36, 56, 63] it will remain at the same capacity.
 * 
 * The fourth method for exercise #8 count that accepts an element value as a parameter and will return the numbers of 
 * occurrences of that value in the list. Example suppose a variable list stores [2, -3, 2, 0, 5, 2, 2, 6]. A call  of 
 * list.count(2) will return 4 because there are four occurrences of that value in the list.
 * 
 * The fifth method for exercise #11 removeLast this will remove and return the last value from a list of integers.  
 * Example if a variable list stores [8, 17, 42, 3, 8] a call of list.removeLast(); will return 8 and change the state
 * of the list to [8, 17, 42, 3]. Another call would return 3 and remove it from the end of list. When empty it will 
 * throw NoSuchElementException
 */

import java.util.*;

public class ArrayIntList {

    private int[] elementData; // list of integers
    private int size; // current number of elements in the list

    public static final int DEFAULT_CAPACITY = 100;

    // pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
    public ArrayIntList(int capacity) {
	if (capacity < 0) {
	    throw new IllegalArgumentException("capacity: " + capacity);
	}
	elementData = new int[capacity];
	size = 0;
    }

    // post: constructs an empty list of default capacity
    public ArrayIntList() {
	this(DEFAULT_CAPACITY);
    }

    // post: returns the current number of elements in the list
    public int size() {
	return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the integer at the given index in the list
    public int get(int index) {
	checkIndex(index);
	return elementData[index];
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
	if (size == 0) {
	    return "[]";
	} else {
	    String result = "[" + elementData[0];
	    for (int i = 1; i < size; i++) {
		result += ", " + elementData[i];
	    }
	    result += "]";
	    return result;
	}
    }

    // post : returns the position of the first occurrence of the given
    // value (-1 if not found)
    public int indexOf(int value) {
	for (int i = 0; i < size; i++) {
	    if (elementData[i] == value) {
		return i;
	    }
	}
	return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
	return size == 0;
    }

    // post: returns true if the given value is contained in the list,
    // false otherwise
    public boolean contains(int value) {
	return indexOf(value) >= 0;
    }

    // pre : size() < capacity (throws IllegalStateException if not)
    // post: appends the given value to the end of the list
    public void add(int value) {
	ensureCapacity(size + 1); // this public method throws the exception
	elementData[size] = value;
	size++;
    }

    // pre : size() < capacity (throws IllegalStateException if not) &&
    // 0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    // values right
    public void add(int index, int value) {
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException("index: " + index);
	}
	ensureCapacity(size + 1); // this public method throws the exception
	for (int i = size; i > index; i--) {
	    elementData[i] = elementData[i - 1];
	}
	elementData[index] = value;
	size++;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
	checkIndex(index);
	for (int i = index; i < size - 1; i++) {
	    elementData[i] = elementData[i + 1];
	}
	size--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the integer at the given index with the given value
    public void set(int index, int value) {
	checkIndex(index);
	elementData[index] = value;
    }

    // post: list is empty
    public void clear() {
	size = 0;
    }

    // post: ensures that the underlying array has the given capacity; if not,
    // the size is doubled (or more if given capacity is even larger)
    private void ensureCapacity(int capacity) {
	if (capacity > elementData.length) {
	    int newCapacity = elementData.length * 2 + 1;
	    if (capacity > newCapacity) {
		newCapacity = capacity;
	    }
	    elementData = Arrays.copyOf(elementData, newCapacity);
	}
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    // not a legal index of the current list
    private void checkIndex(int index) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException("index: " + index);
	}
    }

    /*
     * Solution for exercise #1 this method will take in an integer as a parameter
     * and will return the index in the list of the last occurrence of that value. A
     * for loop will iterate through an the elementData array and then test each
     * Element if it is equal to the param. if it is then it will return the index
     * of which it was compared to. If the value is not found it will return -1
     * 
     * Post: Returns the index in the list of the last occurrence of that value, or
     * -1 if the value is not found in the list
     */
    public int lastIndexOf(int target) {
	for (int i = size - 1; i >= 0; i--) { // for loop iterating through array
	    if (elementData[i] == target) { // if statement to see if the element at index i is equal to the target value
		return i; // returns i if values are the same
	    }
	}
	return -1; // if target doesn't exist returns -1
    }

    /*
     * Solution for exercise #2 this method will take in a list L as a param and
     * will return the index of where L first appears in list 1. A for loop will
     * iterate through a single element from the first list then through another for
     * loop it will iterate through all the elements within the second list and if
     * the value at the index i + j == the index at j in the second list it will
     * keep a total count of the index of where a value first appears in list1. Then
     * it will jump to an if statement which sees if the total count has reached the
     * end of list L if yes then it will return the index at which totalCount
     * reached the max size.
     * 
     * Post: Accepts another list L as a parameter and returns the starting index of
     * where L first appears in this list, or -1 if it is not found.
     */
    public int indexOfSubList(ArrayIntList L) {
	for (int i = 0; i <= elementData.length - L.size; i++) { // for loop iterating through first array
	    int totalCount = 0; // sets totalCount to 0 each loop
	    for (int j = 0; j < L.size; j++) { // another for loop iterating through subList
		if (elementData[i + j] == L.elementData[j]) { // if statement testing if value in list1 is same as value in subList
		    totalCount++; // if they are the same value it increments totalCount by 1
		}
	    }
	    if (totalCount == L.size) { // if statement testing if totalCount is the same value as the size of the subList
		return i; // if true then it returns the index i of the first list
	    }
	}

	return -1; // Will return -1 if the sequence of the sublist is not found
    }

    /*
     * Solution for exercise #5 this method will create a new list which takes in
     * the size of another initialized list and the new list will store the sum of 0
     * through i in each element. It will do that using two for loops. The first for
     * loop will iterate through the original list and set a var total to 0. Next
     * another for loop will run through each element of the original list and keep
     * a running total of each element from 0 to that element. Then it will add that
     * total to the newList.
     * 
     * Pre: list.size > 0 (returns empty list if not) Post: Returns a new
     * ArrayIntList that contains a running total of the original list
     */
    public ArrayIntList runningTotal() {
	ArrayIntList newList = new ArrayIntList(size); // Initializing new ArrayIntList
	for (int i = 0; i < size; i++) { // for loop iterating though array
	    int total = 0; // total variable set to 0 with each loop to keep the totals accurate
	    for (int k = 0; k <= i; k++) { // for loop iterating through same array and adding each element from 0 to i
		total += elementData[k];
	    }
	    newList.add(total); // once for loop is done it adds it to the new list
	}
	return newList; // returns the newList as is and if empty return it empty
    }

    /*
     * Solution for exercise #8 this method will accept a value as a parameter and
     * will return the number of occurrences of that value in the list. It will do
     * that using a for loop which will iterate through the elements of the array
     * and use an if statement to see if at a certain index the value equals that of
     * the parameter. If yes then it will keep a running total of how many times it
     * occurred. Once the for loop has run through the whole list it will return the
     * total.
     * 
     * Post: Accepts an element value as a parameter and returns the number of
     * occurrences of that value in the list.
     */
    public int count(int target) {
	int total = 0; // Variable total initialized to 0
	for (int i = 0; i < size; i++) { // for loop iterating through array
	    if (elementData[i] == target) { // if statement to see if value of array at index i is equal to the target value
		total++; // if true then total is incremented by 1 each time
	    }
	}
	return total; // returns total
    }

    /*
     * Solution for exercise #11 this method will remove the last value from the
     * array. If the list is empty then it will throw a NoSuchElementException().
     * First an if statement will check if the array is empty if not then it will
     * set a var last to the last element in the array then call the remove method
     * from within the class and remove the last element from the list then return
     * the value stored in last.
     * 
     * Post: Removes and returns the last value from a list of integers.
     */
    public int removeLast() {
	if (isEmpty()) { // if statement testing if array is empty
	    throw new NoSuchElementException(); // if true then throws an exception
	}
	int last = elementData[size - 1]; // variable last is initialized to the last element in the array
	this.remove(size - 1); // removes the last element from the array
	return last; // returns the value removed
    }
}
