import java.util.*;

public class InsertionSort {

	public InsertionSort(){}


	//Sort a randomized array using the insertion sort algorithm
	/* PSEUDO
		    for <-- 0 to arrayLength do
				curr <-- i
				val <-- array[i]
				
			while curr > 0 and val < array[curr-1] do
				array[curr] <-- array[curr-1]
				curr <-- curr-1
				
			array[curr] <-- val
	*/
	public void sort( int[] arr ) {
		
		int val = 0;
		int curr = 0;
		
		for( int i = 0; i < arr.length; i++ ) {
			
			//On every iteration the val in question is updated
			//Current index is i
			val = arr[i];
			curr = i;
			
			//While the current index > zero && 
			//the val being tested is larger that it's left neighor,
			//shift all items right to make space
			while( curr > 0 && val < arr[curr-1] ) {
				
				arr[ curr ] = arr[ curr - 1 ]; //move the left value one to the right (which is the current position)
				curr--;
			}
			
			//Shifting no longer necessary, put the value into its rightful spot
			arr[curr] = val;
			
		}
		
	}
	
	/*Makes a random array of size n*/
	public void randomizeArray( int[] arr ) {
		Random rand = new Random(System.currentTimeMillis());
		for( int i = 0; i < arr.length; i++ ) {	
			arr[i] = rand.nextInt(arr.length) + 1;
		}
	}
	
	
	/*Main*/
	public static void main( String[] args ) {
		InsertionSort in = new InsertionSort();
		int[] randomArray = new int[25];
		in.randomizeArray( randomArray );		
		System.out.println( Arrays.toString( randomArray ) );
		
		int sum1 = 0;
		int sum2 = 0;
		for( int i = 0; i < randomArray.length; i++ ) {
			sum1 += randomArray[i];
		}
	
		in.sort( randomArray );
		System.out.println( Arrays.toString( randomArray ) );
		for( int i = 0; i < randomArray.length; i++ ) {
			sum2 += randomArray[i];
		}
		
		if( sum1 == sum2 ) {
			System.out.println("Array contents are equal");
		}
		else {
			System.out.println("Arrays NOT equal");
		}
	
	}

}