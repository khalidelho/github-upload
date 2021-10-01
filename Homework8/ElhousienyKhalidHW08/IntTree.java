/*
 * Khalid Elhousieny 
 * CS 211 (C) James Livingston 
 * HW08
 * June 5th 2021
 * 
 * 
 * Simple binary tree class that includes methods to construct a  tree of ints, to print the structure, and to print the data
 * using a preorder, inorder or postorder traversal.  The trees built have nodes numbered starting with 1 and numbered
 * equentially level by level with no gaps in the tree.  The documentation refers to these as "sequential trees."
 * 
 * This is the IntTree class which conatins the definiton of the Binary Tree we use. It also conatins the solutions 
 * to Exercises # 1,5,8
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

import java.util.*;

public class IntTree {
    private IntTreeNode overallRoot;

    // pre : max > 0
    // post: constructs a sequential tree with given number of
    // nodes
    public IntTree(int max) {
	if (max < 0) {
	    throw new IllegalArgumentException("max: " + max);
	}
	overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    // n is greater than max, in which case it returns an
    // empty tree
    private IntTreeNode buildTree(int n, int max) {
	if (n > max) {
	    return null;
	} else {
	    return new IntTreeNode(n, buildTree(2 * n, max), buildTree(2 * n + 1, max));
	}
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
	System.out.print("preorder:");
	printPreorder(overallRoot);
	System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
	if (root != null) {
	    System.out.print(" " + root.data);
	    printPreorder(root.left);
	    printPreorder(root.right);
	}
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
	System.out.print("inorder:");
	printInorder(overallRoot);
	System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
	if (root != null) {
	    printInorder(root.left);
	    System.out.print(" " + root.data);
	    printInorder(root.right);
	}
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
	System.out.print("postorder:");
	printPostorder(overallRoot);
	System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
	if (root != null) {
	    printPostorder(root.left);
	    printPostorder(root.right);
	    System.out.print(" " + root.data);
	}
    }

    // post: prints the tree contents, one per line, following an
    // inorder traversal and using indentation to indicate
    // node depth; prints right to left so that it looks
    // correct when the output is rotated.
    public void printSideways() {
	printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    // root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
	if (root != null) {
	    printSideways(root.right, level + 1);
	    for (int i = 0; i < level; i++) {
		System.out.print("    ");
	    }
	    System.out.println(root.data);
	    printSideways(root.left, level + 1);
	}
    }

    // Public method for exercise #1 will return a call to its private pair with the
    // main root of the tree
    public int countLeftNodes() {
	return countLeftNodes(overallRoot); // returns a call to its private pair while passing in the overallRoot as a param
    }

    /*
     * Private method for exercise #1 which will traverse through the tree and
     * return the total number of values in the left subtree. It will do that by
     * first checking if the currentNode is 0 in which case it will return 0. If not
     * then it will initialize a totalLeft counter at 0 and have two if statements
     * to check if each node is not empty. if it is not empty then it will keep a
     * running total of the totalLeft by recursively calling itself and passing in
     * the left node first. After it runs through the left children it will then go
     * through the left children in the right subtree. Once all
     * the left nodes are accounted for it will return the total count.
     * 
     */
    private int countLeftNodes(IntTreeNode currentNode) {
	if (currentNode == null) { // if statement checking if the currentNode exists or not
	    return 0; // returns 0 if statement is true
	} else {
	    int totalLeft = 0; // initialized var for the total number of nodes in the left subtree
	    if (currentNode.left != null) { // if statement testing if a currentNode on the left exists
		totalLeft += countLeftNodes(currentNode.left) + 1; // if true then it adds it to the running total 
	    }
	    if (currentNode.right != null) { // another if statement testing if the currentNode left on the right subTree exists
		totalLeft += countLeftNodes(currentNode.right); // if exists then it adds it to the running total
	    }

	    return totalLeft; // returns total tally of left children
	}
    }

    /*
     * Public method for exercise #5: This method will accept an integer parameter n
     * and prints the values at level n from left to right, one per line.
     */
    public void printLevel(int level) {
	printLevel(level, overallRoot); // returns a call of its public pair passing in the level requested and the overallRoot
    }

    /*
     * Private method for exercise #5. This method will keep track of each level of
     * the tree while traversing through it. It does that by first going through two
     * if statements which tests if the param level is less than 1 meaning that the
     * tree doesn't exist and that will throw and IlleaglArgumentException. Next the
     * second if statement will check if the currentNode param is null which if true
     * it returns nothing. If it passes those first two then it goes in the base
     * case of a recursive function. Which sees if the level is equal to 1. until
     * then it will go through two recursive calls of itself which will run through
     * the left subtree first then the right subtree. Once it gets to level one it
     * will print out the number at each node of that chosen level.
     */
    private void printLevel(int level, IntTreeNode currentNode) {
	if (level < 1) { // if statement to check if the level requested is less than 1
	    throw new IllegalArgumentException(); // if true then throws an exception
	} else {
	    if (currentNode == null) { // if statement checking if the curentNode doesn't exist
		return; // if true then it will return nothing 
	    } else {
		if (level == 1) { // base case checking if level is 1
		    System.out.println(currentNode.data); // if true then it returns the currentNode data
		} else { // if not
		    printLevel(level - 1, currentNode.left); // then it will first recursively call the method for the nodes on the left subtree decreasing 1 each time 
		    printLevel(level - 1, currentNode.right); // then it will call the method for the nodes on the right subtree decreasing 1 each time 
		}
	    }
	}
    }

    /*
     * Public method for exercise #8. This method will call its private pair and
     * pass in the overall Root as a parameter.
     */
    public String toString() {
	return toString(overallRoot); // returns call to its private pair passing in the overallRoot as a param
    }

    /*
     * Private method for exercise #8. This method will return the tree as a String
     * output. It will do that with a couple of organizational requirements Such as
     * the overallRoot will be displayed first and separated by a comma and a
     * Parentheses. Next it will print the left subtree which will also print the
     * main root and then its children starting with the left. If they are not null
     * it will print each child left to right starting with the parent. If a node is
     * null it will print 'empty'. Each subtree is enclosed in a parentheses with
     * commas between each node. This will be done by using an if statement to check
     * if the currentNode is empty if not then it will test if the left node and the
     * right node are empty. if not then it will return the currentNode final
     * statement will be the formatting of the solution. Which will be parentheses
     * where needed and same with commas.
     */
    private String toString(IntTreeNode currentNode) {
	if (currentNode == null) { // if statement to check if the currentNode exists or not
	    return "empty"; //if it doesn't exist then it will return empty as a string
	} else if (currentNode.left == null && currentNode.right == null) { // else if checking if the left and right nodes exist or not 
	    return currentNode.data + ""; // if they do not then it will return the currentNode data and an empty space
	} else { //else statement to finally return the correct formatting as well as the currentNode data and a call to itself with the left and right nodes as params
	    return "(" + currentNode.data + ", " + toString(currentNode.left) + ", " + toString(currentNode.right) + ")";
	}
    }
}