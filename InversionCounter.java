import java.util.*;

public class InversionCounter {

	private static int inversions = 0;

	public InversionCounter( int[] A ) {

	
	}
	
	public void mergeSort( int[] A ) {
		
		if( A.length < 2) {
			return; //base case
		}
		
		int mid = (A.length / 2) - 1;
		//System.out.printf("mid: %d\n", mid);
		
		int leftLength = mid+1;
		int rightLength = A.length - (mid+1);
		
		int[] leftArray = new int[ leftLength ];
		int[] rightArray = new int[ rightLength ];
		
		for( int i = 0; i < leftLength; i++ ) {
			leftArray[i] = A[i];
		}
		
		for( int i = mid + 1, j = 0; i < A.length; i++, j++ ) {
			rightArray[j] = A[i];
		}
				

		mergeSort( leftArray ); 
		mergeSort( rightArray );
		merge( leftArray, rightArray, A );
	}
	
	public void merge( int[] leftArray, int[] rightArray, int[] A ) {
		
		System.out.printf("Merging %s and %s\n", Arrays.toString(leftArray), Arrays.toString(rightArray) );
		
		int i = 0, j = 0, k = 0, inversions = 0;
		
		while( i < leftArray.length && j < rightArray.length ) {
			
			if( leftArray[i] < rightArray[j] ) {
				A[k++] = leftArray[i++];
			}
			else {
				A[k++] = rightArray[j++];
				
				//This is only done once
				if( inversions == 0 ) {
					inversions = 1;
					InversionCounter.inversions += rightArray.length;//(leftArray.length - k );	
				}
				
	
			}
			
		}
		
		while( i < leftArray.length ) {
			A[k++] = leftArray[i++];
		}
		while( j < rightArray.length ) {
			A[k++] = rightArray[j++];
		}
		

	}
	
	public static void main( String[] args ) {
	
		int[] arr = { 1, 20, 6, 4, 5 };
		InversionCounter i = new InversionCounter( arr );
		
		i.mergeSort(arr);
		System.out.printf("Inversion count: %d\n", InversionCounter.inversions );
		System.out.printf("Final order: %s\n", Arrays.toString( arr ) );
	}

}