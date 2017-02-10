/**
 * Created by sulu on 1/30/17.
 */
public class SumImplementation {

    public static void main(String [] args) {
        int [] a = {4, -3, 5, -2, -1, 2, 6, -2};

        MaxContiguousSubsequenceSum array_max_sum = new MaxContiguousSubsequenceSum(a);

        int sum1 = array_max_sum.maxSubSum1();
        System.out.println(sum1);
        int sum2 = array_max_sum.maxSubSum2();
        System.out.println(sum2);

    }
}
