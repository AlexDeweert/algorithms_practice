import java.util.*;

public class Algorithms_1_4_6 {
        
        public static void main( String[] args ) {
                System.out.print("Question a: ");

                Algorithms_1_4_6 al1 = new Algorithms_1_4_6();

                System.out.println( al1.question_a( 100 ) );

                System.out.print("Question b: n = 1000000: ");
                System.out.println( al1.question_b( 1000000 ) );

                for( int i = 0; i < 35; i++ ) {
                        System.out.printf("Question c: n = %d: ", i);
                        System.out.println( al1.question_c( i ) );
                }

        }

        public Algorithms_1_4_6() {}

        /*
        Complexity estimated at O(n)
        */
        public int question_a( int n ) {

                int sum = 0;
                for( int k = n; k > 0; k /= 2 ) {
                        for( int i = 0; i < k; i++ ) {
                                sum++;
                        }
                }
                return sum;
        }

        /*
        Complexity estimated at O(n)
        */
        public int question_b( int n ) {
                int sum = 0;
                for( int i = 1; i < n; i *= 2) {
                        for( int j = 0; j < i; j++ ) {
                                sum++;

                                //System.out.printf("Sum: %d, i: %d, j: %s", sum, i, j);
                                //System.out.println();

                        }
                }
                return sum;
        }

        /*
        Complexity estimated at O(nlogn)
        */
        public int question_c( int n ) {
                int sum = 0;
                for( int i = 1; i < n; i *= 2) {
                        for( int j = 0; j < n; j++ ) {
                                //System.out.printf("\n     i == %d, sum == %d", i, sum);
                                sum++;
                        }
                }

                return sum;
        }

}

/*
k = 10:
        10 times (n)

k = 5:
        5 times (n/2)

k = 2:
        2 times (n/4)

*/