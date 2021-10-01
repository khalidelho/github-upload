/*
 * Khalid Elhousieny
 * HW03
 * CS 211 (C), James Livingston 
 * May 1st 2021
 * 
 * This class will contain 3 different exercises from chapter 11.
 * 
 * The first exercise (#5) will use an ArrayList to pass in a list 
 * of numbers that are in random order and contain duplicates. That 
 * list will be passed into a method that will sort and remove any 
 * duplicates within the list and output a new sorted set of numbers.
 * 
 * The second exercise (#11) will use two separate sets of numbers 
 * that contain some duplicates and it will pass those sets into 
 * a method that will return the Symmetric Difference. Meaning it will 
 * add all the unique values within each list into a separate set. 
 * 
 * The third exercise (#15) will use an ArrayList of numbers that has 
 * a value that occurs more than once and it will pass it to a method 
 * that will return the most occurring value within that list aka the "Mode"
 */

import java.util.*;

public class Ch11Main {

    public static void main(String[] args) {

	// Exercise #5 example
	System.out.println("Testing the Sort and Remove Duplicates method");

	// Initializing ArrayList to contain the list of numbers we will sort and remove from
	List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9));

	// List before sort and remove is called and spacers
	System.out.println();
	System.out.println("Pre-sorted list: " + numbers); // Will output the list of numbers "[7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9]"
	System.out.println();

	/*
	 * sortAndRemoveDuplicates takes in "[7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9]" 
	 * that list is added to a TreeSet by iterating through each value the TreeSet converts 
	 * the set to "[-9, -5, 4, 7, 8, 11, 15, 27, 32]" because it automatically sorts and
	 * removes duplicates. That set is stored in a variable and returned back here
	 */
	System.out.println("Sorted List: " + sortAndRemoveDuplicates(numbers)); // Will pass in a list of numbers, "[7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9]" and output: "Sorted List: [-9, -5, 4, 7, 8, 11, 15, 27, 32]"
	System.out.println("__________________________________________________");
	System.out.println();

	// Exercise #11 example
	System.out.println("Testing the Symmetric Set Difference method");
	System.out.println();

	// Initializing two sets of numbers to pass into the Symmetric method
	Set<Integer> set1 = new TreeSet<Integer>();
	set1.add(1);
	set1.add(4);
	set1.add(7);
	set1.add(9);
	Set<Integer> set2 = new TreeSet<Integer>();
	set2.add(2);
	set2.add(4);
	set2.add(5);
	set2.add(6);
	set2.add(7);

	System.out.println("Set 1: " + set1); // Will output a set of numbers: "Set 1: [1, 4, 7, 9]"
	System.out.println("Set 2: " + set2); // Will output a set of numbers: "Set 2: [2, 4, 5, 6, 7]"

	/*
	 * symmetricSetDifference takes in set1: [1, 4, 7, 9] and set2: [2, 4, 5, 6, 7] 
	 * the first set is added into a TreeSet called "example". Then we use 
	 * example.addAll(set2) to add all the elements of set2 into the example TreeSet. 
	 * Then we use a second TreeSet called exampleTwo and use exampleTwo.retainAll(set2) 
	 * to store the values that occur in both sets. Then finally we do
	 * example.removeAll(exampleTwo) which removes all the non unique values from
	 * the set. We then return that final set back here.
	 */
	System.out.println("Symmetric Difference: " + symmetricSetDifference(set1, set2)); // Will take in two sets, "Set 1: [1, 4, 7, 9]" and "Set 2: [2, 4, 5, 6, 7]" and output: "Symmetric Difference : [1, 2, 5, 6, 9]"

	// Spacer
	System.out.println("__________________________________________________");
	System.out.println();

	// Exercise #15 example
	System.out.println("Testing the Max Occurrence method");
	System.out.println();

	/*
	 * maxOccurremces takes in the list
	 * "[7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9]" it will pass through an if
	 * statement which iterates through the list if(itr.hasNext()) to check if the
	 * list is empty if not then it will go through a while loop
	 * while(itr.hasNext()) that adds each element to a HashMap. The HashMap will
	 * also store the value of each element which is how many times that element
	 * appears map.put(number, map.get(number) + 1). Once stored in the map a for
	 * loop for(int number : map.keySet()) will iterate through each key and compare
	 * its value to the greatest value within the map. Whichever key has the
	 * greatest value is the mode and we return the number of times it appears.
	 */
	System.out.println("The mode occurs " + maxOccurrences(numbers) + " times in the list"); // Will use the list of numbers, "[7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9]" and output: "The mode occurs 3 times in the list"
    }

    /*
     * HW #5 This method will take in a list of numbers that are out of order and
     * has duplicates. It will then pass that list through a TreeSet and the TreeSet
     * will return a set that has sorted the list and removed any duplicate numbers.
     */
    public static Set<Integer> sortAndRemoveDuplicates(List<Integer> list) {
	Set<Integer> finalSet = new TreeSet<>(); // Initializing TreeSet
	Iterator<Integer> i = list.iterator(); // Initializing Iterator

	// While loop to iterate through list of numbers and add each number to the TreeSet
	while (i.hasNext()) {
	    int number = i.next();
	    finalSet.add(number);
	}
	return finalSet; // Returns Set of numbers
    }

    /*
     * HW #11 This method will take in two sets with some number similarities then
     * it will use a couple of Set Operations to unionize then intersect then output
     * the difference between the two sets.
     */
    public static Set<Integer> symmetricSetDifference(Set<Integer> set1, Set<Integer> set2) {
	// Initializing two TreeSets and adding the values of set1 into each TreeSet
	Set<Integer> symmetricDiff = new TreeSet<>(set1);
	Set<Integer> intersectSet = new TreeSet<>(set1);

	symmetricDiff.addAll(set2); // This TreeSet which already has all the values of set1 will add all the values of set2 into it
	intersectSet.retainAll(set2); // This TreeSet will find the values within both sets that are the same
	symmetricDiff.removeAll(intersectSet); // This will remove all the duplicate values within both sets and return a Symmetric Difference set

	return symmetricDiff; // Returns set of numbers that are Symmetrically Differentiated
    }

    /*
     * HW #15 This method will take in a list of integers as a parameter then it
     * will test if the list is empty if not then it will iterate through the list
     * and add it to the map while adding each number's value. Then it will test for
     * the number with the greatest value which is the mode.
     */
    public static int maxOccurrences(List<Integer> list) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // Initialize HasMap with an Integer key and value
	Iterator<Integer> itr = list.iterator(); // Initialize Iterator to go through the list of numbers
	int numberOfOccurrences = 0; // Initialize numOfOccurences which will keep track of how many times a number appears in the list

	// If statement to check if the list is empty or not
	if (itr.hasNext()) {
	    // While loop to iterate through list and add all elements within the list to the HashMap
	    while (itr.hasNext()) {
		int number = itr.next(); // Stores each elements from the list
		if (map.containsKey(number)) { // Checks the map to see if the key exists
		    map.put(number, map.get(number) + 1); // If the key exists then it will keep a running total of its value
		} else {
		    map.put(number, 1); // If key only appears once then its value will be 1
		}
	    }

	    // For loop to iterate through map and find the number of times the mode appears
	    for (int number : map.keySet()) {
		if (map.get(number) > numberOfOccurrences) { // If statement to compare the value of each key to the number of times a key appears
		    numberOfOccurrences = map.get(number); // Sets numberOfOccurrences to the value of each key
		}
	    }
	} else {
	    return 0; // Will return 0 if list is empty
	}

	return numberOfOccurrences; // Returns the number of times the mode appears
    }
}
