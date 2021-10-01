/*
 * Khalid Elhousieny 
 * CS 211 (C) James Livingston 
 * HW08
 * June 5th 2021
 * 
 * This is the client class which will have calls to the method solutions created and demonstrating what each one does
 * 
 * Exercise #1 countLeftNodes returns the number of left children in the tree. A left child is a node that appears 
 * as the root of the left-hand subtree of another node.
 * 
 * Exercise #5 printLevel will accept an integer parameter n and will print the values at level n from left to right
 * one per line. The method will use the convention that the overall root is at level 1. Its children are at level 2
 * and so on. If there are no values at the level, the method will not produce an output. The method will throw and 
 * IllegalArgumentException if it is passed a value for a level that is less than 1.
 * 
 * Exercise #8 toString. This method will return "empty" for an empty tree. For a leaf node, it will return the data 
 * in the node as a string. For a branch node, it will return a parenthesized String that has three elements separated 
 * by commas. The data at the root a string representation of the left subtree and then a string representation of the
 * right subtree. 
 */

public class HW08Client {
    public static void main(String[] args) {

	IntTree t = new IntTree(16); // Creating an instance of the IntTree object and passing in 10 as param

	System.out.println("Tree structure:");
	t.printSideways();

	System.out.println("_______________________________");
	System.out.println();

	// Testing Exercise #1 countLeftNodes (parameter of 10)
	System.out.println("Testing Exercise #1 countLeftNodes");
	System.out.println();

	// Input overallRoot = 16
	// if currentNode == null ? return 0 : (totalLeft = 0, if leftNode !=null ? totalLeft += countLeftNodes(leftNode) + 1, if rightNode !=null ? totalLeft += countleftNodes(rightNode)) return totalLeft
	System.out.println("Number of children in the left subtree: " + t.countLeftNodes()); // Will output "Number of children in the left subtree: 5"

	System.out.println("_______________________________");
	System.out.println();

	// Testing Exercise #5 printLevel
	System.out.println("Testing Exercise #5 printLevel");
	System.out.println();

	System.out.println("Values on the third level of the tree: ");
	System.out.println();

	// Input Level = 3, overallRoot = 16
	t.printLevel(3); // if level < 1 ? throw IllegalArgumentException : if currentNode == null ? return; : if level == 1 ? print(currentNode.data) : (printLevel(level - 1,leftNode), printLevel(level - 1,rightNode))   
	/*
	 * Will output 
	 * 4 
	 * 5 
	 * 6 
	 * 7
	 */

	System.out.println("_______________________________");
	System.out.println();

	// Testing Exercise #8 toString (parameter of 10)
	System.out.println("Testing Exercise #8 toString");
	System.out.println();

	// Input overallRoot = 16
	System.out.println(t.toString()); // if currentNode == null ? return "empty" : if leftNode && rightNode == null ? return currentNode.data + "" : return "(" + currentNode.data + ", " + toString(currentNode.left) + ", " + toString(currentNode.right) + ")"
	// Will output "(1, (2, (4, 8, 9), (5, 10, empty)), (3, 6, 7))"
    }
}
