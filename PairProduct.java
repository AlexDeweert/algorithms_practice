/*
   Student: Alex L. Deweert
   Student ID: V00855767
   Assignment 1
*/

/* PairProduct.java
   CSC 225 - Spring 2017
   Programming Assignment 1 - Template for PairProduct
   
   This template includes some testing code to help verify the implementation.
   To interactively provide test inputs, run the program with
	java PairProduct
	
   To conveniently test the algorithm with a large input, create a 
   text file containing space-separated integer values and run the program with
	java PairProduct file.txt
   where file.txt is replaced by the name of the text file.

   B. Bird - 05/01/2014
   M. Simpson - 01/05/2015
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

//Do not change the name of the PairProduct class
public class PairProduct{
	/* PairProduct225()
		The input array A will contain non-negative integers. The function
		will search the array A for a pair of elements which multiply to 225.
		If such a pair is found, return true. Otherwise, return false.
		The function may modify the array A.
		Do not change the function signature (name/parameters).
	*/
	public static boolean PairProduct225(int[] A){

		/*Populate an array of length 226 (since we're including zero in the inputs)
		* so each value of the array A, not including zero or numbers greater than 225, 
		* is placed into the new array at index position equal to it's value */
		int n = A.length;
		int fifteenCount = 0;
		int[] arr = new int[226];
		for( int i = 0; i < A.length; i++ ) {
			if( A[i] != 0 && A[i] <= 225 ) {
				arr[ A[i] ] = A[i];

				/*Note the special case for 15*/
				if( A[i] == 15 ) {
					fifteenCount++;
				}
			}
		}

		/*Check the populated array. This array contains all values from the list passed in, 
		* located in its corresponding index, ie 15 is at arr[15]. 
		* We determine: 1) If the number is not zero, 2) If the number divides 225
		* If it does, the pair exists, and there are either no fifteens or at least 2;
		* This logic is extensible by determining if 225 or its analog is the product
		* of a perfect square. Here we take a shortcut and just recognize 15*15 == 225*/
		int complement = 0;
		for( int i = 0; i < arr.length; i++ ) {
			if( arr[i] > 0 && 225 % arr[i] == 0 ) {
				complement = 225 / arr[i];
				if( arr[complement] != 0 && fifteenCount != 1){
					return true;
				}
			}
		}
		return false;
	}

	/* main()
	   Contains code to test the PairProduct225 function. Nothing in this function 
	   will be marked. You are free to change the provided code to test your 
	   implementation, but only the contents of the PairProduct225() function above 
	   will be considered during marking.
	*/
	public static void main(String[] args){
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
		}
		Vector<Integer> inputVector = new Vector<Integer>();
		
		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			inputVector.add(v);
		
		int[] array = new int[inputVector.size()];
		
		for (int i = 0; i < array.length; i++)
			array[i] = inputVector.get(i);

		System.out.printf("Read %d values.\n",array.length);
		
		
		long startTime = System.currentTimeMillis();
		
		boolean pairExists = PairProduct225(array);
		
		long endTime = System.currentTimeMillis();
		
		double totalTimeSeconds = (endTime-startTime)/1000.0;
		
		System.out.printf("Array %s a pair of values which multiply to 225.\n",pairExists? "contains":"does not contain");
		System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
	}
}
