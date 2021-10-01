/*
* Khalid Elhousieny
* CS 211 (C) James Livingston
* May 27th 2021
* HW07
* 
* This is the test client class where the homework problems will be solved.
* This class will have calls to the methods for exercises #8, and 12 from Ch.16
* 
* The first exercise #8 is a method called switchPairs. This method will switch the order 
* of the values in the list in a pairwise fashion. The method will switch the order of the 
* first two values, then switch the order of the next two, switch the order of the next two, 
* and so on. If the list contains an odd number of values, the final element is not moved. 
* Example if the list initially stores [10, 25, 31, 47, 52, 68, 77] the method will switch 
* the first pair (10 and 25) the second pair (31 and 47) and the third pair to output [25, 10, 47, 31, 68, 52, 77]
* 
* The second exercise #12 is a method called split. This method will rearrange the elements
* of a list so that all of the negative values appear before all of the nonnegative numbers. 
* Example a variable list stores [8, 7, -4, 19, 0, 43, -8, -7, 2]. Calling list.split() will 
* rearrange the list to output [-7, -8, -4, 8, 7, 19, 0, 43, 2]. This method will be solved
* by rearranging the links of the list. 
*/

public class ListClient {
    public static void main(String[] args) {
	LinkedIntList list1 = new LinkedIntList();
	processList(list1);

	// spacer
	System.out.println("___________________________________________");
	System.out.println();

	// Test for exercise #8
	LinkedIntList list2 = new LinkedIntList(); // Initialing a LinkedIntList list2
	list2.add(10);
	list2.add(25);
	list2.add(31);
	list2.add(47);
	list2.add(52);
	list2.add(68);
	list2.add(77);
	System.out.println("Testing Switch Pairs method #8");
	System.out.println();

	System.out.println("\nOriginal List: " + list2); // Will output Original List: [10, 25, 31, 47, 52, 68, 77]
	list2.switchPairs(); // for (i = 0; i < size() - 1; i += 2) if (i != size() - 1) ? (node1Value = nodeAt(i).data, node2Value = nodeAt(i + 1).data, remove(i), remove(i), add(i,node2Value)); --> [25, 10, 47, 31, 68, 52, 77]
	System.out.println("List after switched pairs: " + list2 + '\n'); // Will output List after switched pairs: [25, 10, 47, 31, 68, 52, 77]

	// spacer
	System.out.println("___________________________________________");
	System.out.println();

	// Test for exercise #12
	LinkedIntList list3 = new LinkedIntList(); // Initialing a LinkedIntList list3
	list3.add(8);
	list3.add(7);
	list3.add(-4);
	list3.add(19);
	list3.add(0);
	list3.add(43);
	list3.add(-8);
	list3.add(-7);
	list3.add(2);
	System.out.println("Testing Split method #12");
	System.out.println();

	System.out.println("Original List: " + list3); // Will output Original List: [8, 7, -4, 19, 0, 43, -8, -7, 2]
	list3.split(); // Listnode viewing = front if (viewing != null) ? while (viewing.next != null) if (viewing.next.data < 0) ? (tempNode = viewing.next.next, viewing.next.next = front, front = viewing.next, viewing.next = tempNode) : viewing = viewing.next;
	System.out.println("List after splitting negatives: " + list3 + '\n'); // Will output List after splitting negatives: [-7, -8, -4, 8, 7, 19, 0, 43, 2]

    }

    public static void processList(IntList list) {
	list.add(18);
	list.add(27);
	list.add(93);
	System.out.println(list);
	list.remove(1);
	System.out.println(list);
    }

}
