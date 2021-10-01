/* CS 211 (C), Spring Quarter
 * Khalid Elhousieny, April 28th 2021
 * Exercise #2
 * This program will read from mobydick text file and display 
 * all words that occur at least 2000 times in the text in alphabetical order.
 * Then it will ask for user input to search for a word and it will 
 * return the number of occurrences that word appears in the text file
 */

import java.io.*;
import java.util.*;

public class WordCount {
    private static boolean userDone = false; // Boolean variable for whether the user is finished with the program
    private static final int OCCURRENCES = 2000; // Constant variable of 2000 for the number of occurrences of a word

    public static void main(String[] args) throws FileNotFoundException {

	// Program Introduction
	System.out.println("This program displays words that occur \nat least 2000 times from the book Moby Dick");
	System.out.println("___________________________________________");
	System.out.println();

	// Creating new scanner object and having it read from the mobydick.txt file
	Scanner input = new Scanner(new File("mobydick.txt"));

	// Delimiter for parsing purposes
	input.useDelimiter("[^a-zA-Z']+");

	// Initialize new map and set it to the output of wordCount method
	Map<String, Integer> wordCountMap = wordCount(input);

	// Call the getCount method and pass in the Map object as a parameter
	getCount(wordCountMap);
	System.out.println("___________________________________________");
	System.out.println();

	// Calls the userInput method which prompts the user to enter a word to search
	// for and return its count
	userInput(wordCountMap);
    }

    /*
     * This method will take in a Scanner object as a parameter and initialize a
     * Treemap to input the words in a map and assign a value to each key. It will
     * keep a running total of the amount of times it reads a certain word and then
     * add it to the map. Finally it will return the Treemap once it reads whole
     * file which we will use on other methods.
     */

    public static Map<String, Integer> wordCount(Scanner input) {
	// reads file into a map of [word --> number of occurrences]
	Map<String, Integer> wordCount = new TreeMap<>();
	while (input.hasNext()) { // While loop to keep code running until its reads all of mobydick
	    String word = input.next().toLowerCase(); // Will convert each word into lower case letters
	    if (wordCount.containsKey(word)) { // If statement to keep track of how many times a word occurs in the txt file
		// seen this word before; increase count by 1
		int count = wordCount.get(word); // Count variable to get the value of each word/key
		wordCount.put(word, count + 1); // Adding the key value pair to the Treemap
	    } else {
		// never seen this word before
		wordCount.put(word, 1);
	    }
	}
	return wordCount;
    }

    /*
     * User Interaction Method. This method will create a scanner object and have a
     * while loop that will check if the User quit the program or not. If the User
     * did not quit the program then it will keep asking for user input. Once the
     * users types a word it will return how many times that word Occurred in the
     * book.
     */

    public static void userInput(Map<String, Integer> wordCount) {
	Scanner console = new Scanner(System.in); // Initializing Scanner object
	while (!userDone) { // While loop to keep running as long as userDone is true
	    // Question to ask the user
	    System.out.print(
		    "What word would you like to search for (Please enter a word. Type 'Quit' to exit program.)? ");
	    String word = console.next().toLowerCase(); // Will grab input and save it in the word variable
	    // If statement to test if the user entered the word Quit to leave the program
	    if (word.equalsIgnoreCase("Quit")) {
		System.out.println("The Program Has Ended"); // Message that will display if the program is ended
		userDone = true; // Sets userDone to true to stop the while loop from running
		console.close(); // Closes the Scanner object
	    } else {
		// If statement to test if the word that the user entered does not exist within the txt file
		if (wordCount.get(word) == null) {
		    System.out.println(word + " Does not exist in the book. Please try another word."); // If the word does not exist this is the message that will appear
		    System.out.println(); // Spacer
		} else {
		    System.out.println(word + " appears " + wordCount.get(word) + " times."); // If the word exists this message will appear displaying the word and number of occurrences
		    System.out.println(); // Spacer
		}
	    }
	}
    }

    /*
     * This method will take a map as a parameter and iterate through the keySet of
     * the map and set the value of the word into the variable count. Then it will
     * test if the count is greater than or equal to 2000. If that is true then it
     * will print out the word and the number of times the word occurs.
     */
    public static void getCount(Map<String, Integer> wordCount) {
	// For loop to iterate through the wordCount keySet 
	for (String word : wordCount.keySet()) {
	    int count = wordCount.get(word); // Grabs the value of each word and sets it to the count variable
	    // Is statement that will test if the count is greater than or equal to Occurrence which is 2000
	    if (count >= OCCURRENCES) {
		System.out.println(word + " occurs " + count + " times."); // If that is true then it will display the word and the count
	    }
	}
    }
}
