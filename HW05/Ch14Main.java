import java.util.*;

/*
 * Khalid Elhousieny 
 * CS 211 (C) James Livingston 
 * May 15th 2021
 * HW05
 * 
 * This is a main class with solutions to exercises from Ch 14.
 * 
 * The first exercise #6 Rearrange. This method will accept a queue of integers as a parameter and will rearrange 
 * the order of the values so that all of the even values appear before the odd values and that will preserve the general order of the original queue 
 * For example, if the queue stores [3, 5, 4, 17, 6, 83, 1, 84, 16, 37],the method will rearrange it to store [4, 6, 84, 16, 3, 5, 17, 83, 1, 37]. 
 * The method will also use one stack as an auxiliary storage.
 * 
 * The second exercise #13 Expunge. This method will accept a stack of integers as a parameter and makes sure that the stack’s elements are in nondecreasing order from top to bottom, 
 * by removing from the stack any element that is smaller than any element(s) on top of it. For example, if the stack stores [4, 20, 15, 15, 8, 5, 7, 12, 3, 10, 5, 1], 
 * the element values 3, 7, 5, 8, and 4 should be removed because each has an element above it with a larger value. So the method will change the stack to store [20, 15, 15, 12, 10, 5, 1]. 
 * It will also check if the stack is empty or has just one element, so nothing will change. It will use a stack as an auxiliary storage
 */

public class Ch14Main {

    public static void main(String[] args) {

	// Example for exercise #6
	Queue<Integer> queue = new LinkedList<Integer>(); // Initializing a queue of integers
	// adding values to the queue from the back of the queue
	queue.add(3);
	queue.add(5);
	queue.add(4);
	queue.add(17);
	queue.add(6);
	queue.add(83);
	queue.add(1);
	queue.add(84);
	queue.add(16);
	queue.add(37);
	System.out.println("Testing Rearrange method");
	System.out.println();

	System.out.println("Original Queue: " + queue);
	/*
	 * First the method will reverse the entire queue to start backwards.
	 * auxStack.add(queue.remove()); ---> queue.add(auxStack.pop()); Then it will
	 * iterate through the values using a for loop inside of it an if statement for
	 * (int i; i < queueSize; i++) { int num % 2 == 1 ? (auxStack.push(num), itr.remove());} 
	 * Then it will reverse everything one more time to return the
	 * queue to the right order auxStack.push(queue.remove()); ---> queue.add(auxStack.pop());
	 */
	rearrange(queue); 
	System.out.println("Arranged Queue: " + queue); // output Arranged Queue: [4, 6, 84, 16, 3, 5, 17, 83, 1, 37]

	System.out.println("_________________________________________");
	System.out.println();

	// Example for exercise #13
	Stack<Integer> stack = new Stack<Integer>(); // Initializing a stack of integers
	// pushing values to the top of the stack
	stack.push(4);
	stack.push(20);
	stack.push(15);
	stack.push(15);
	stack.push(8);
	stack.push(5);
	stack.push(7);
	stack.push(12);
	stack.push(3);
	stack.push(10);
	stack.push(5);
	stack.push(1);
	System.out.println("Testing Expunge method");
	System.out.println();

	System.out.println("Original Stack: " + stack);
	/*
	 * Will check if stack size is greater than 1. If true then it will add the
	 * stack to an auxStack then it will pass through a while loop that will start
	 * removing value depending on if it is greater than the top value of the
	 * stack. The it will pass through another while loop to add it to the original
	 * stack which is then passed back. 
	 * stackSize > 1 ? ( auxStack.push(stack.pop()), while(!stackIsEmpty) { int value >= auxStack.peek() ? auxStack.push(value);}, while (!auxStackIsEmpty) { stack.push(auxStack.pop()); })
	 */
	expunge(stack);
	System.out.println("Final Stack: " + stack); // output Final Stack: [20, 15, 15, 12, 10, 5, 1]
    }

    /*
     * Exercise #6 method. This method will rearrange a queue of ints by placing the
     * even numbers at the beginning of the queue and odd numbers at the end while
     * maintaining the general order. This method will use a stack as an auxiliary
     * storage. First the method will reverse the order of the values in the queue
     * by adding them to the stack storage then adding them back into the queue
     * parameter. Once that is done the method will use an iterator to iterate
     * through each value within the queue. Inside the for loop an if statement is
     * used to see if the value within the queue is an odd number. If it is then it
     * gets added to the stack and removed from the queue. once all the odd values
     * have been determined then we reverse back the queue by adding it into the
     * stack. And then adding the stack into the queue.
     */
    public static void rearrange(Queue<Integer> queue) {
	Stack<Integer> auxStack = new Stack<Integer>(); // Initializing Stack to act as auxiliary storage

	// reverse the entire queue parameter
	while (!queue.isEmpty())
	    auxStack.add(queue.remove()); // adds the values of the queue into the auxStack
	while (!auxStack.empty())
	    queue.add(auxStack.pop()); // adds back the values within the auxStack into the queue now reversed

	// puts odd numbers into the stack, in reversed order
	int queueSize = queue.size();
	Iterator<Integer> itr = queue.iterator(); // Create iterator variable of for queue
	for (int i = 0; i < queueSize; i++) { // for loop to iterate through queue
	    int num = (int) itr.next(); // Declaring num to if the iterator has a another value and is not empty
	    if (num % 2 == 1) { // will check if each value is odd
		auxStack.push(num); // if true then value gets added to the auxStack
		itr.remove(); // it also gets removed from the queue
	    }
	}

	// re-reverse the queue in order to get the proper order
	while (!queue.isEmpty())
	    auxStack.push(queue.remove()); // adds the queue to the auxStack
	while (!auxStack.empty())
	    queue.add(auxStack.pop()); // adds back the auxStack to the queue now in the right order
    }

    /*
     * Exercise #13 method. This method will take in a stack as a parameter and use
     * another stack as an auxiliary storage to add the values we need. first it
     * will check if the stack size is greater than one then it will remove and
     * return the values from the top of the stack parameter and push it into the
     * auxiliary stack from there it will check if the stack is empty using a while
     * loop. Inside the while loop an int value will be set to the value at the top
     * of the parameter stack which will go through an if statement to test if the
     * value is greater than or equal to the value at the top of the auxiliary
     * stack. if true then it will push that value into the auxiliary stack. another
     * while loop will also be used to see if the auxiliary stack is empty. Inside
     * the loop the top values from the auxiliary stack will be pushed into the
     * stack parameter removing it from the storage.
     */
    public static void expunge(Stack<Integer> stack) {
	Stack<Integer> auxStack = new Stack<Integer>(); // Initializing Stack to act as auxiliary storage
	if (stack.size() > 1) { // if statement to check if the parameter has more than one value or not
	    auxStack.push(stack.pop()); // if true then the values within the stack parameter will be removed and added into the auxStack

	    while (!stack.isEmpty()) { // while loop keeps going until stack parameter is empty
		int value = stack.pop(); // creating variable to store each value from the top of the stack parameter
		if (value >= auxStack.peek()) { // if statement checking if the values at the top is greater than or equal to the value at the top of the auxStack
		    auxStack.push(value); // if true then it adds the value to the auxStack
		}
	    }

	    while (!auxStack.isEmpty()) {// while loop to keep going until the auxStack is empty
		stack.push(auxStack.pop()); // this will add the values of the auxStack back into the stack parameter with the updated list of numbers
	    }
	}
    }

}
