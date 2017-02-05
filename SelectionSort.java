import java.util.*;

public class SelectionSort {

	public SelectionSort( ) {
		
	}

	/*
	*	PSEUDO (Selection Sort)
	*	min <-- 0
	*	for i <-- 0 to n do
	*		min <-- i
	*		for j <-- i+1 do
	*			if arr[j] < arr[min]
	*				min <-- j
	*		
	*		swap arr[i], arr[min]
	*/
	public void sort( int[] arr ) {
		
		int min = 0;
		
		for( int i = 0; i < arr.length; i++ ) {
			min = i;
			
			for( int j = i+1; j < arr.length; j++ ) {
				if( arr[j] < arr[min] ) {
					min = j;
				}
			}
	
			int temp1 = arr[i];
			int temp2 = arr[min];
			arr[i] = temp2;
			arr[min] = temp1;
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
		SelectionSort s = new SelectionSort();
		int[] randomArray = new int[25];
		s.randomizeArray( randomArray );		
		System.out.println( Arrays.toString( randomArray ) );
		
		int sum1 = 0;
		int sum2 = 0;
		for( int i = 0; i < randomArray.length; i++ ) {
			sum1 += randomArray[i];
		}
	
		s.sort( randomArray );
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