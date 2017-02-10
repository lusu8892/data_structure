/**
 * Created by sulu on 1/30/17.
 */
public class MaxContiguousSubsequenceSum {

    int [] input_array;

    MaxContiguousSubsequenceSum (int [] input_array) {
        this.input_array = input_array;
    }

    public int maxSubSum1 () {

        int max_sum = 0;
        int iter_num = input_array.length;

        for ( int i = 0; i < iter_num; i++ ) {
            for ( int j = i; j < iter_num; j++ ) {
                int this_sum = 0;

                int [] sub_sequence = new int[iter_num];

                for ( int k = i; k <= j; k++ ) {
                    this_sum += input_array[k];
//                    for (int l = 0; l <= k; l++) {
//                        sub_sequence[l] = input_array[l];
//                    }
                    sub_sequence[k] = input_array[k];

                }

                if (this_sum > max_sum) {
                    max_sum = this_sum;
                }
            }
        }
        return max_sum;
    }

    public int maxSubSum2 () {
        int max_sum = 0;
        int iter_num = input_array.length;

        for ( int i = 0; i < iter_num; i++ ) {

            int this_sum = 0;

            for ( int j = i; j < iter_num; j++ ) {

                this_sum += input_array[j];

                if (this_sum > max_sum) {
                    max_sum = this_sum;
                }
            }
        }
        return max_sum;
    }
}
