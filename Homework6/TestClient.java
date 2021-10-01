/*
 * Khalid ELhousieny 
 * CS 211 (C) James Livingston
 * MAY 20th 2021
 * HW06
 * 
 * The class is the Test Client for chapter 15 containing test calls to methods in the ArrayIntList class
 * 
 * The first method for exercise #1 lastIndexOf. This method will accept an integer as a 
 * parameter and will return the index in the list of the last occurrence of that the param value. 
 * Or it will return -1 if the value is not found in the list. For example a list [1, 18, 2, 7, 18, 39, 18, 40]
 * a param of 18 is passed will return 6. If a param of 3 is passed in it returns -1. 
 * 
 * The second method for exercise #2 indexOfSubList will accept a list L as a parameter and return the starting index
 * of where L first appears in this list, it will return -1 if the value is not found All elements of L will appear in 
 * sequence and in the same order. Example if variables list1 and list2 store [11, -7, 3, 42, 0, 14] and [3, 42, 0]
 * the call list1.indexOfSubList(list2) will return 2.
 * 
 * The third method for exercise #5 runningTotal which will return a new ArrayIntList that contains a running total
 * of the original list. The ith value in the new list should store the sum of the elements 0 through i of the original list.
 * a list storing [2, 3, 5, 4, 7, 15, 20, 7] then called ArrayIntList list2 = list.runningTotal(); list2 will become 
 * [2, 5, 10, 14, 21, 36, 56, 63] it will remain at the same capacity.
 * 
 * The fourth method for exercise #8 count that accepts an element value as a parameter and will return the numbers of 
 * occurrences of that value in the list. Example suppose a variable list stores [2, -3, 2, 0, 5, 2, 2, 6]. A call  of 
 * list.count(2) will return 4 because there are four occurrences of that value in the list.
 * 
 * The fifth method for exercise #11 removeLast this will remove and return the last value from a list of integers.  
 * Example if a variable list stores [8, 17, 42, 3, 8] a call of list.removeLast(); will return 8 and change the state
 * of the list to [8, 17, 42, 3]. Another call would return 3 and remove it from the end of list. When empty it will 
 * throw NoSuchElementException
 */

public class TestClient {

    public static void main(String[] args) {
	 // Test for Exercise #1
        ArrayIntList list = new ArrayIntList(); // Initializing list to pass into the first method
        list.add(1);
        list.add(18);
        list.add(2);
        list.add(7);
        list.add(18);
        list.add(39);
        list.add(18);
        list.add(40);
        System.out.println("Testing lastIndexOf Method Ex: #1");
        System.out.println();
        
        System.out.println("Original List: " + list); // for (int = size - 1; i >= 0; i--) { if list[i] == 18 (parameter) ? return i : return -1} --> 6 
        System.out.println("Last occurring Index of 18: " + list.lastIndexOf(18)); // Will output 6
        System.out.println("Last occurring Index of 3: " + list.lastIndexOf(3) + " (does not exist)"); // Will output -1
        
        
        System.out.println("________________________________________");
        System.out.println();

        // Test for Exercise #2
        ArrayIntList list1 = new ArrayIntList(); // Initializing the first test list for the indexOfSubList method
        list1.add(11);
        list1.add(-7);
        list1.add(3);
        list1.add(42);
        list1.add(0);
        list1.add(14);
        ArrayIntList list2 = new ArrayIntList(); // Initializing the second test list for the indexOfSubList method
        list2.add(3);
        list2.add(42);
        list2.add(0);
        ArrayIntList list3 = new ArrayIntList(); // Initializing the third test list for the indexOfSubList method
        list3.add(-7);
        list3.add(10);
        list3.add(5);
        System.out.println("Testing indexOfSubList Method Ex: #2");
        System.out.println();
        
        System.out.println("Original List: " + list1); // [11, -7, 3, 42, 0, 14]
        System.out.println("Sublist1: " + list2); // [3, 42, 0]
        System.out.println("Sublist2: " + list3); // [-7, 10, 5]
        /*
         * for (i = 0; i <= list1.length - list2.size; i++){
         * totalCount = 0;
         * 	for ( j = 0; j < list2.size; j++){
         * 		if list1[i+j] == list2[j] ? totalCount++; 
         * }
         * 	if totalCount == list2.size ? return i : return -1;
         * }
         */
        System.out.println("Index of Sublist1: " + list1.indexOfSubList(list2)); // Will output 2 because the first value of 3 in list2 was found at index 2 in list1
        System.out.println("Index of Sublist2: " + list1.indexOfSubList(list3) + " sequence not found"); // Will output -1 because the sequence of -7,10,5 is not in the original list
        
        System.out.println("________________________________________");
        System.out.println();

        // Test for Exercise #5
        ArrayIntList list5 = new ArrayIntList(8); // Initializing the list for the runningTotal method 
        list5.add(2);
        list5.add(3);
        list5.add(5);
        list5.add(4);
        list5.add(7);
        list5.add(15);
        list5.add(20);
        list5.add(7);
        System.out.println("Testing runningTotal Method Ex: #5");
        System.out.println();
        
        System.out.println("Original List: " + list5); // [2, 3, 5, 4, 7, 15, 20, 7]
        /*
         for (int i = 0; i < list5.size; i++) { 
	     total = 0; 
	    for (int k = 0; k <= i; k++) { 
		total += list5[k];
	    }
	    newList.add(total); 
	  }
	  return newList; 
         */
        System.out.println("Running Total List: " + list5.runningTotal()); // Will output [2, 5, 10, 14, 21, 36, 56, 63]
       
        System.out.println("________________________________________");
        System.out.println();

        // Test for Exercise #8
        ArrayIntList list8 = new ArrayIntList(); // Initializing the list for the count method 
        list8.add(2);
        list8.add(-3);
        list8.add(2);
        list8.add(0);
        list8.add(5);
        list8.add(2);
        list8.add(2);
        list8.add(6);
        System.out.println("Testing count Method Ex: #8");
        System.out.println();
        
        System.out.println("Original List: " + list8); // [2, -3, 2, 0, 5, 2, 2, 6]
        System.out.println("2 occurres: " + list8.count(2) + " times"); // (total = 0, for (i = 0; i < list8.size; i++), if list8[i] == 2 (parameter) ? total++;): list8.count(2) --> 2 occurres: 4 times
      
        System.out.println("________________________________________");
        System.out.println();

        // Test for Exercise #11
        ArrayIntList list11 = new ArrayIntList(); // Initializing the list for the removeLast method 
        list11.add(8);
        list11.add(17);
        list11.add(42);
        list11.add(3);
        list11.add(8);
        System.out.println("Testing removeLast Method Ex: #11");
        System.out.println();
        
        System.out.println("Original List: " + list11); // [8, 17, 42, 3, 8]
        System.out.println("Removed: " + list11.removeLast()); // if list11.isEmpty() ? throw  NoSuchElementException() : ( lastElem = list11[size - 1], remove(size - 1), return lastElem;): list11.removeLast() --> 8
        System.out.println("New List: " + list11); // [8, 17, 42, 3]
        System.out.println("Removed: " + list11.removeLast()); // if list11.isEmpty() ? throw  NoSuchElementException() : ( lastElem = list11[size - 1], remove(size - 1), return lastElem;): list11.removeLast() --> 3
        System.out.println("New List: " + list11); // [8, 17, 42]
    }

}
