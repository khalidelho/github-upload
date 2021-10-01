/*
 * Khalid Elhousieny
 * HW04 EX.#2,#5,#6,#8,#15
 * CS 211 (C) James Livingston
 * May 8th 2021
 * 
 * This Main class will include solutions to exercises #2,5,6,8,15
 * This class will also have method calls to each solution  to test
 * their output and those can be found in the main method. 
 * 
 * The first exercise #2 will take in an int as a parameter and print to the console
 * the first n integers starting with 1 in sequential order, separated by commas. 
 * 
 * The second exercise #5 will take in an int as a parameter and will output its binary 
 * representation to the console. The parameter will go through 2 recursive method calls
 * to determine if the next digit should be a 1 or a 0.
 * 
 * The third exercise #6 will take in an int n as a parameter and will print the first 
 * n squares separated by commas. It will display the odd squares in descending order 
 * followed by the even squares in ascending order. Two calls to the recursive method 
 * will be made to either display n at the beginning or the end.
 * 
 * The fourth exercise #8 takes in an int n as a parameter and returns the product 
 * of the first n even integers. This method will double each n and then multiply it 
 * by the return from the recursive method that takes in one less than n.
 * 
 * The fifth exercise #15 takes in a String word as a parameter and returns a string 
 * in which all of the vowels have been moved to the end. The vowels will appear in 
 * reverse order of what they were in the original word. similar to Ex. #6 depending 
 * on if the letter is a vowel or not the recursive call will either be first or after 
 * letter is returned.
 * 
 * A more in depth description of each method is written on top of the method declaration
 */

import java.util.*;

public class HW04Main {

    public static void main(String[] args) {
	// Exercise #2 example
	System.out.println("Testing Write Nums method. EX.#2");
	System.out.println();

	System.out.print("List of numbers until 5: ");
	writeNums(5); // int n == 1 ? print(n) : (writeNums(n-1), print("," + n)); ==> "1, 2, 3, 4, 5"
	System.out.println();

	System.out.print("List of numbers until 12: ");
	writeNums(12); // int n == 1 ? print(n) : (writeNums(n-1), print("," + n)); ==> "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12"
	System.out.println();

	// Spacers
	System.out.println("___________________________________");
	System.out.println();

	// Exercise #5 example
	System.out.println("Testing Print Binary method. EX.#5");
	System.out.println();

	System.out.print("44 in Binary is: ");
	printBinary(44); // int n < 0 ? (print("-"), printBinary(-n)) : n < 2 ? print(n) : (printBinary(n / 2), printBinary(n % 2)); ==> "101100"
	System.out.println();

	System.out.print("-7 in Binary is: ");
	printBinary(-7); // int n < 0 ? (print("-"), printBinary(-n)) : n < 2 ? print(n) : (printBinary(n / 2), printBinary(n % 2)); ==> "-111"
	System.out.println();

	// Spacers
	System.out.println("___________________________________");
	System.out.println();

	// Exercise #6 example
	System.out.println("Testing Write Squars. EX.#6");
	System.out.println();

	System.out.print("writeSquares(8): ");
	writeSquares(8); // int i == 1 ? print(i) : i % 2 == 1 ? ( System.out.print(i * i + ", "), writeSquares(i - 1)) : (writeSquares(i - 1), System.out.print(", " + i * i)); ==> "49, 25, 9, 1, 4, 16, 36, 64"
	System.out.println();

	System.out.print("writeSquares(15): ");
	writeSquares(15); // int i == 1 ? print(i) : i % 2 == 1 ? ( System.out.print(i * i + ", "), writeSquares(i - 1)) : (writeSquares(i - 1), System.out.print(", " + i * i)); ==> "225, 169, 121, 81, 49, 25, 9, 1, 4, 16, 36, 64, 100, 144, 196"
	System.out.println();

	// Spacers
	System.out.println("___________________________________");
	System.out.println();

	// Exercise #8 example
	System.out.println("Testing Multiply Evens EX.#8");
	System.out.println();

	System.out.print("multiplyEvens(1): ");
	System.out.println(multiplyEvens(1)); // int n <= 0 ?  throw new IllegalArgumentException() : n == 1 ? return 2 : return (2 * n) * multiplyEvens(n - 1); ==> "2"
	System.out.println();

	System.out.print("multiplyEvens(4): ");
	System.out.println(multiplyEvens(4)); // int n <= 0 ?  throw new IllegalArgumentException() : n == 1 ? return 2 : return (2 * n) * multiplyEvens(n - 1); ==> "384"
	System.out.println();

	// Spacers
	System.out.println("___________________________________");
	System.out.println();

	// Exercise #15 example
	System.out.println("Testing Vowels To End. EX.#15");
	System.out.println();

	System.out.print("Original Word beautifully: ");
	System.out.println(vowelsToEnd("beautifully")); // String word.length() <= 1 ? return word : word.charAt(0) == vowel ? return vowelsToEnd(word.substring(1)) + word.charAt(0) : word.charAt(0) + vowelsToEnd(word.substring(1)); ==> "btfllyuiuae"
	System.out.println();

	System.out.print("Original Word memorandum: ");
	System.out.println(vowelsToEnd("memorandum")); // String word.length() <= 1 ? return word : word.charAt(0) == vowel ? return vowelsToEnd(word.substring(1)) + word.charAt(0) : word.charAt(0) + vowelsToEnd(word.substring(1)); ==> "mmrndmuaoe"
    }

    /*
     * Method for exercise #2 This method takes in n as a parameter and will return
     * the first n integers. Through an if statement n will be evaluated for its
     * value if it is greater than 1 then the method will call itself until n is 1.
     * At which point it will begin returning the first n integers sequentially.
     */
    public static void writeNums(int n) {
	// If statement to evaluate the value of n
	if (n == 1) { // Base case to test is n is 1
	    System.out.print(n);
	} else { // Recursive case
	    writeNums(n - 1); // Method calling itself and passing in 1 less than n
	    System.out.print(", " + n); // Printing the first n integers with comma separator
	}
    }

    /*
     * Method for exercise #5 This method takes in an int n as a parameter and
     * converts it to Binary Using an if statement it will evaluate the value of n
     * to see if it is negative or positive. Then to speed up the process it will
     * evaluate if n is less than 2. If not then it will
     */
    public static void printBinary(int n) {
	if (n < 0) { // recursive case for negative numbers
	    System.out.print("-");
	    printBinary(-n);
	} else if (n < 2) { // base case; same as base 10
	    System.out.print(n);
	} else {
	    // recursive case; break number apart
	    printBinary(n / 2); // Will divide each time by two until n is less than 2 then it will print either 1 or 0 
	    printBinary(n % 2); // Will start after the recursive method above has ran through and reached an n less than 2
	}
    }

    /*
     * Method for exercise #6 This method will calculate the square for the
     * parameter passed in and the squares of all the int preceding the parameter
     * entered. It will also display the odd squares at the front in descending order
     * and the positive squares in ascending order.
     */
    public static void writeSquares(int n) {
	if (n == 1) { // Base case testing if param equals 1
	    System.out.print(n);
	} else if (n % 2 == 1) { // else if added to speed recursion up and find odd numbers
	    System.out.print(n * n + ", "); // Will print out the square of odd numbers with a comma
	    writeSquares(n - 1); // Recursive method calling itself after displaying odd square
	} else {
	    writeSquares(n - 1); // Recursive method calling itself if number is even
	    System.out.print(", " + n * n); // Will print out the square of the odd numbers with a comma before each one
	}
    }

    /*
     * Method for exercise #8 This method will return the product of the first n
     * even integers The method will have two bas cases testing if input is 0 or 1
     * then if they pass the base case the input is multiplied by two then passed
     * into the recursive method subtracting 1 from the input it will keep running
     * until n is 1 which will return 2 then unfold
     */
    public static int multiplyEvens(int n) {
	if (n <= 0) { // check for illegal input
	    throw new IllegalArgumentException();
	} else if (n == 1) { // base case
	    return 2; // returns 2 once n is 1
	} else {
	    return (2 * n) * multiplyEvens(n - 1); // will double the input every time then pass back one less which will get doubled again until n is 1
	}
    }

    /*
     * Method for exercise #15 This method will take in a word as a parameter and
     * display constants at the front of the word and the place the vowels in
     * reversed order at the end of the word. The if statement will check if the
     * word is of greater length than 1 and then will check if the letter at the
     * position it is check is a vowel. If not then it will display the constant
     * first then call the recursive method which will remove the letter from the
     * word then pass it back in with one less letter.
     */
    public static String vowelsToEnd(String word) {
	if (word.length() <= 1) { // base case
	    return word; // returns original string
	} else { // recursive case
	    char letter = word.charAt(0); // assign the fist position of the input to the variable letter
	    if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') { // will check if the letter is a vowel
		return vowelsToEnd(word.substring(1)) + letter; // if the letter is a vowel then it will call the recursive case first so it can display the vowels last
	    } else {
		return letter + vowelsToEnd(word.substring(1)); // if the letter is not a vowel then it will display the constant first so it is at the front of the word
	    }
	}
    }

}
