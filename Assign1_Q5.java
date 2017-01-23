import java.util.*;

public class Assign1_Q5 {
        public Assign1_Q5 () {
        }

        public int[] populateArray( int n ) {

                int[] arr = new int[ n ];

                for( int i = 0; i < n; i++) {
                        arr[i] = i;
                }

                return arr;

        }

        public int[] removeRandomInteger( int[] arr ) {

                /*A smaller array is not necessary, this is just a test for an alternate algorithm*/
                int[] smallerArray = new int[ arr.length - 1 ];

                int len = arr.length;
                Random rand = new Random( System.currentTimeMillis() );
                int randomInt = Math.abs( rand.nextInt() % len );
                System.out.printf("Removing from index %d", randomInt);
                System.out.println();
                System.out.printf("Removed value %d", arr[randomInt]);
                System.out.println();
                arr[randomInt] = -1;

                /*Create the smaller array here without the missing value*/
                int index = 0;
                for(int i = 0; i < arr.length; i++ ) {
                        if( arr[i] != -1 ) {
                                smallerArray[index] = arr[i];
                                index++;
                        }
                }

                System.out.printf("\nMissing value is %d", findMissingValue( arr ));

                return smallerArray;
        }

        /* Missing number = (sum of range [0 - n]) - (sum of array [0-n] with missing number) */
        public int findMissingValue( int[] arr ) {
                int arraySum = 0;
                int rangeSum = 0;

                for( int i = 0; i < arr.length; i++ ) {
                        rangeSum += i;

                        if( arr[i] >= 0 ) {
                                arraySum += arr[i];
                        }
                }

                return rangeSum - arraySum;
        }

        public int findMissingValue2( int[] smallerArr )  {
                int arraySum = 0;
                int rangeSum = 0;

                for( int i = 0; i < smallerArr.length; i++ ) {
                        arraySum += smallerArr[i];
                }
                for( int i = 0; i < smallerArr.length + 1; i++ ) {
                        rangeSum += i;
                }

                return rangeSum - arraySum;
        }

        public static void main(String[] args) {

                Assign1_Q5 a1 = new Assign1_Q5();
                int[] arr = a1.populateArray(40);
                System.out.print( "Original array: \n" );
                System.out.println(Arrays.toString( arr ));
                System.out.println("Removing a random integer from array");
                int[] smallerArr = a1.removeRandomInteger( arr );
                System.out.println(Arrays.toString( arr ));

                System.out.println();
                System.out.println(Arrays.toString( smallerArr ));

                System.out.printf("Alternate method missing val is: %d\n", a1.findMissingValue2( smallerArr));
        }


}