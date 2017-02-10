/**
 * Created by sulu on 1/29/17.
 */
public class EuclidAlgorithm {

    public static int gcd (int m, int n) {
        while (n != 0) {
            int rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    public static int gcdRecursion (int m, int n) {
        if (n == 0)
        {
            return m;
        }
        else
        {
            int rem = m % n;
            m = n;
            n = rem;
            return gcdRecursion(m, n);
        }

    }

    public static void main (String[] args) {

        int x = gcd (3 ,4);
        int m = gcdRecursion(3,4);
        System.out.println(m);
    }
}
