/*
 * Khalid Elhousieny 	
 * CS 211 (C) James Livingston 
 * June 13th 2021
 * HW09
 * 
 * This client program will contain calls to the method solutions for the exercises #1,2,3,9,11 from HW09
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

import java.util.*;

public class HW09Client {
    public static void main(String[] args) {

	// Test for exercise #1  
	HashIntSet set1 = new HashIntSet();
	set1.add(56);
	set1.add(1);
	set1.add(2);
	set1.add(3);
	HashIntSet set2 = new HashIntSet();
	set2.add(2);
	set2.add(3);
	set2.add(68);
	set2.add(44);
	set2.add(79);
	set1.addAll(set2); 
	System.out.println("Test for exercise #1 addAll");
	System.out.println();
	
	// Input: [2, 3, 68, 44, 79]. Expected output is [1, 2, 3, 44, 56, 68, 79]
	System.out.println("[56, 1, 2, 3].addAll([2, 3, 68, 44, 79]) = " + set1); // for (i < set2.length), HashEntry element = set2.elements[i], while (elements != null), add(element.data), element = next; 
	
	//spacer
	System.out.println("_____________________________________________");
	System.out.println();

	// Test for exercise #2. 
	HashIntSet set3 = new HashIntSet();
	set3.add(-2);
	set3.add(3);
	set3.add(5);
	set3.add(6);
	set3.add(8);
	HashIntSet set4 = new HashIntSet();
	set4.add(3);
	set4.add(6);
	set4.add(8);
	System.out.println("Test for exercise #2 containsAll");
	System.out.println();
	
	// Input: [3, 6, 8]. Expected output: true
	System.out.println("[-2, 3, 5, 6, 8].containsAll([3, 6, 8]): " + set3.containsAll(set4)); // for (i < set4.length), HashEntry element = set4.elementData[i], while (element != null) if set1.contains(element.data) == false ? return false : element = next, return true; 

	//spacer
	System.out.println("_____________________________________________");
	System.out.println();

	// Test for exercise #3. 
	HashIntSet set5 = new HashIntSet();
	set5.add(3);
	set5.add(6);
	set5.add(8);
	System.out.println("Test for exercise #3 equals");
	System.out.println();
	
	// Input: [3, 6, 8]. Expected output: true
	System.out.println("[3, 6, 8].equals([3, 6, 8]): " + set4.equals(set5));// return (set4.elementData.length == set5.elementData.length) && set4.containsAll(set5);

	//spacer
	System.out.println("_____________________________________________");
	System.out.println();

	// Test for exercise #9. 
	PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();
	queue1.add(42);
	queue1.add(50);
	queue1.add(45);
	queue1.add(78);
	queue1.add(61);
	System.out.println("Test for exercise #9 kthSmallest");
	System.out.println();
	
	// Input: ([42, 50, 45, 78, 61], 4). Expected output 61
	System.out.println("4th smallest int from [42, 50, 45, 78, 61] = " + kthSmallest(queue1, 4)); // if (4 <= 0 || 4 > queue1.size) ? throw new Exception : (Stack<Integer> temp, while (i < 4 - 1) temp.add(queue1.remove), i++, kthSmallest = queue1.peak(), while (tempStack.size() > 0) queue.add(tempStack.pop()), return kthSmallest;

	//spacer
	System.out.println("_____________________________________________");
	System.out.println();

	// Test for exercise #11.
	PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>();
	queue2.add(7);
	queue2.add(8);
	queue2.add(8);
	queue2.add(8);
	queue2.add(10);
	queue2.add(45);
	queue2.add(45);
	removeDuplicates(queue2);
	System.out.println("Test for exercise #11 removeDuplicates");
	System.out.println();
	
	// Input: [7, 7, 8, 8, 8, 10, 45, 45]. Expected output [7, 8, 10, 45]
	System.out.println("removeDuplicates([7, 7, 8, 8, 8, 10, 45, 45]) = " + queue2); // Stack <Integer> temp, while ( queue2.size > 0) int current = queue2.remove(), if !temp.contains(current) ? temp.add(current), while (temp.size > 0)  queue.add(tempStack.pop());

    }

    /*
     * Solution for exercise #9 this method will take a an int and a priority queue
     * as a parameter and will return the kth (parameter int) smallest int of the
     * queue. It will do that by first having an if statement that will check if the
     * int k is 0 and less or it is greater then the size of the queue. if any of
     * those are true it will throw and IllegalArgumentException. Then a Stack
     * auxiliary storage is is instantiated. An int i is set to 0 and a while loop
     * is used to remove from the queue and add to the stack. Then a variable
     * kthSmallest which will be returned later will store the element at the front
     * of the queue. Then another while loop will add the elements back to the queue
     * while removing it from the stack
     */
    public static int kthSmallest(PriorityQueue<Integer> queue, int k) {
	if (k <= 0 || k > queue.size()) { // if statement seeing if param is less than or equal to 0 or it is greater than the queue size
	    throw new IllegalArgumentException(); // will throw exception if previous statement is true 
	}
	Stack<Integer> tempStack = new Stack<Integer>(); // stack auxiliary storage 
	int i = 0; // var initialized to  0 for iteration 
	while (i < k - 1) { // while loop to keep running as long as the elements in stack are same as one less than param
	    tempStack.add(queue.remove());  // adding elements of queue into stack and removing from queue
	    i++; // keeping track of how many elements are added 
	}
	int kthSmallest = queue.peek(); // var to find the kthSmallest int 
	while (tempStack.size() > 0) { // while loop to go through stack and remove elements from it and add it into queue
	    queue.add(tempStack.pop()); // adding elements back into queue 
	}
	return kthSmallest; // will return the kthSmallest int from the queue
    }

    /*
     * Solution for exercise #11 this method will remove duplicates from a priority
     * queue. It will do that by first creating a Stack as an auxiliary storage.
     * Then inside a while loop a variable current will store the elements of the
     * queue then an if statement will will go through the elements in current and
     * see if the tempStack also does not contain any of the elements stored in
     * current. If it doesn't then current will be added to the stack. Then a final
     * while loop will go through the stack and remove the elements and add it into
     * the queue.
     */
    public static void removeDuplicates(PriorityQueue<Integer> queue) {
	Stack<Integer> tempStack = new Stack<Integer>(); // stack auxiliary storage 
	while (queue.size() > 0) { // while loop to keep going as queue size is greater than 0
	    int current = queue.remove(); // will keep a var current and set to the elements of queue that are being removed
	    if (!tempStack.contains(current)) { // if statement to check if the stack does not contain the current element 
		tempStack.add(current); // if not then it will get added to the stack 
	    }
	}
	while (tempStack.size() > 0) { // while loop to keep going as elements from stack are added into queue
	    queue.add(tempStack.pop()); // adding elements back into queue and removing from stack
	}

    }

}
