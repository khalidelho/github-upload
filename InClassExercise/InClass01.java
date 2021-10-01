/*
 * Khalid Elhousieny 
 * CS 211 
 * April 21st 2021
 * This program prints a list of numbers with a count, computes the averages
 * as well as finds max's and min's and filters out the even numbers
 */

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

public class InClass01 {

    public static void main(String[] args) throws FileNotFoundException {

	ArrayList<Integer> numbers = new ArrayList<Integer>();

	Scanner input = new Scanner(new File("Numbers.txt"));
	while (input.hasNextInt()) {
	    int n = input.nextInt();
	    numbers.add(n);
	}

	
	//Beginning of Count method call
	System.out.println("Print a number with a count: ");
	int count = countNumber(numbers); // Initializes a variable called count and then sets it to the return value of the countNumber method which takes in a parameter of the ArrayList numbers. 
	System.out.println("Count of numbers in the list: " + count); //Will print out the full list of numbers and then at the bottom "Count of numbers in the list: 34"

	//Spacers
	System.out.println("__________________________________");
	System.out.println();

	//Beginning of Average method call
	System.out.println("Print average of numbers: ");
	System.out.println();
	
	double avg = findAvg(numbers);  // Initializes a variable called avg and then sets it to the return value of the findAvg method which takes in a parameter of the ArrayList numbers. 
	System.out.println("Average of numbers: " + avg); // Will print out the full list of numbers and then at the bottom "Average of numbers: 63.23529411764706"
	
	//Spacers
	System.out.println("__________________________________");
	System.out.println();

	//Beginning of findMin method call
	System.out.println("Print the minumum number within the list: ");
	System.out.println();
	
	int min = findMin(numbers); // Initializes a variable called min and then sets it to the return value of the findMin method which takes in a parameter of the ArrayList numbers. 
	System.out.println("Minimum number is: " + min); // Will print out the full list of numbers and then at the bottom "Minimum number is: 6"
	
	//Spacers
	System.out.println("__________________________________");
	System.out.println();

	//Beginning of findMax method call
	System.out.println("Print the maximum number within the list: ");
	System.out.println();
	
	int max = findMax(numbers);  // Initializes a variable called max and then sets it to the return value of the findMax method which takes in a parameter of the ArrayList numbers. 
	System.out.println("Maximum number is: " + max); //Will print out the full list of numbers and then at the bottom "Maximum number is: 99"
	
	//Spacers
	System.out.println("__________________________________");
	System.out.println();
	
	//Beginning of Filtering method call
	System.out.println("Print unfiltered list then the filtred list: ");
	System.out.println();
	
	System.out.println("List before filtering: " + numbers); // Will print out the full list of numbers and then at the bottom 
	//"List before filtering: [98, 58, 48, 70, 66, 70, 98, 59, 36, 92, 95, 97, 54, 83, 90, 68, 36, 99, 96, 6, 52, 50, 22, 52, 15, 79, 82, 76, 27, 13, 48, 95, 37, 83]
	System.out.println();

	filterEvens(numbers); // Calls the filterEvens method and passes in the ArrayList numbers
	System.out.println("List after filtering: " + numbers); // Will print out the full list of numbers and then at the bottom 
	// "List after filtering: [59, 95, 97, 83, 99, 15, 79, 27, 13, 95, 37, 83]"
    }
    

    // This method will print the list of numbers with a count
    private static int countNumber(ArrayList<Integer> numberList) {
	int count = 0; //Initialize count variable and sets it to 0
	for (int i = 0; i < numberList.size(); i++) { // for loop to cycle through numberList and print each number as well as keep a running total of the count within the ArrayList
	    count++; // running total of count in the ArrayList
	    System.out.println(numberList.get(i)); // print each number in the ArrayList
	}
	return count; //returns count of the ArrayList
    }

    // This method computes the average of the numbers
    private static double findAvg(ArrayList<Integer> numberList) {
	double sum = 0; //Initialize sum variable and sets it to 0
	for (int i = 0; i < numberList.size(); i++) { // for loop to cycle through numberList and keep a running total of the sum of all the numbers 
	    sum += numberList.get(i); // Keeps a running total of the sum to use in the Average formula 
	}
	double average = sum / numberList.size(); // Formula for calculating Average
	return average; // Returns the value average of the ArrayList
    }

    // These methods will find the max and min numbers within the numbers ArrayList
    private static int findMin(ArrayList<Integer> numberList) {
	int min = numberList.get(0); // Initialize min variable and calls the numberList and uses the get method to set it to start at the 0 index
	for (int i = 0; i < numberList.size(); i++) { // for loop to cycle through numberList and set the minimum to each number that is smaller than the number in the 0 index
	    if (min > numberList.get(i)) { // If statement testing if the next index value is less than the current value 
		min = numberList.get(i); // if true then it sets min to the smaller number until it goes through the whole list
	    }
	}
	return min;
    }

    // These methods will find the max and min numbers within the numbers ArrayList
    private static int findMax(ArrayList<Integer> numberList) {
	int max = numberList.get(0); // Initialize max variable and calls the numberList and uses the get method to set it to start at the 0 index
	for (int i = 0; i < numberList.size(); i++) { // for loop to cycle through numberList and set the maximum to each number that is larger than the number in the 0 index
	    if (max < numberList.get(i)) { // If statement testing if the next index value is greater than the current value 
		max = numberList.get(i); // if true then it sets max to the larger number until it goes through the whole list
	    }
	}
	return max;
    }

    // Removes all elements with even values from the given list.
    public static void filterEvens(ArrayList<Integer> list) {
	for (int i = list.size() - 1; i >= 0; i--) { // for loop reading the list backwards and passes each number through the variable n
	    int n = list.get(i); // This grabs the value at index i then uses it to the if statement
	    if (n % 2 == 0) { //if statement testing if the value at each index is divisible by two
		list.remove(i); //if that is true and value is even then it removes it from the list
	    }
	}
    }

}
