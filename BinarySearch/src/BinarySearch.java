import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sulu on 2/6/17.
 */
/**
 * Performs the standard binary search.
 * @return index where item is found, or -1 if not found.
 */
public class BinarySearch {

    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType [] a, AnyType x) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            System.out.println(high-low+1);
//            System.out.println(a[low]);
//            System.out.println(a[high]);
            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            }
            else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            }
            else return mid;
        }
        return -1;
    }

    public static void main (String [] args) {

        Integer [] c = new Integer[128];

        for (int i = 0; i < 128; i++) {
            c[i] = i + 1;
        }

//        Integer [] c = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};

        int b = binarySearch(c, 128);
        System.out.println(b);
    }
}
