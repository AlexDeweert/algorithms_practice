import java.util.*;

public class MergeSort {

	public MergeSort() {
		int[] A = { 7, 12, 8, 6, 9, 1, 4, 3, 5, 10, 11, 2 };
		sort(A, 0, A.length-1);
	}
	
	public static void sort( int[] arr, int low, int high ) {
		
		for( int i = 0; i < high; i++) {
			System.out.printf( arr[i] + " ");
		}
		System.out.println();
		//If the arr size (index from low to high) is 1 or 0, it's "sorted", so return (go back up the recursive branch)
		if( high <= low ) 
			return;		
		
		int mid = low + (high - low) / 2;
		
		//sort left recursively
		sort( arr, low, mid);
		//sort right recursively
		sort( arr, mid+1, high);
		
		return;
	}
	
	public static void main( String[] args ) {
		MergeSort m = new MergeSort();
	}

}