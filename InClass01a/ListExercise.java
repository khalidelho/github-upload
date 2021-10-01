/*
 * Khalid Elhousieny 
 * CS 211
 * April 21st 2021
 * This program will use two hard coded lists and compare them against each other to find numbers within the lists that are the same
 * Then the repeated numbers get added to a third list 
 */

import java.util.*;

public class ListExercise {

    public static void main(String[] args) {
	// Creating list 1 and 2
	List<Integer> list1 = Arrays.asList(1, 4, 8, 9, 11, 15, 17, 28, 41, 59);
	List<Integer> list2 = Arrays.asList(4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81);
	List<Integer> list3 = intersect(list1, list2); // Initializing list 3 and setting it to the return value of the intersect method

	System.out.println("list1: " + list1); // Will output list1: [1, 4, 8, 9, 11, 15, 17, 28, 41, 59]

	// Spacers
	System.out.println("__________________________________");
	System.out.println();

	System.out.println("list2: " + list2);// Will output list2: [4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81]

	// Spacers
	System.out.println("__________________________________");
	System.out.println();

	System.out.println("intersect list aka list 3: " + list3); // Will output intersect list aka list 3: [4, 11, 17, 28, 59]

    }

    // Method that creates a third list with the numbers that can be found in both List 1 and List 2
    private static List<Integer> intersect(List<Integer> list1, List<Integer> list2) {
	List<Integer> list3 = new ArrayList<Integer>(); // Creating an new list of integers called list 3 

	for (int i = 0; i < list1.size(); i++) { //for loop that cycles through list 1 as many times as the size of the list 
	    if (list2.contains(list1.get(i))) { // if statement to test if each index value 
		list3.add(list1.get(i)); // if there is a number that passes this condition then it gets added to list 3
	    }
	}
	return list3; //returning list 3 as a list 
    }

}
