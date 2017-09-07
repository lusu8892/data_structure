
/**
 * Created by mercis on 9/7/17.
 */
public class QuickSortAlgorithm {

    public static void quickSort(int [] ar){
        quickSort(ar, 0, ar.length - 1);
    }

    private static void quickSort(int [] ar, int start, int end){
        if ( start >= end) {
            return;  // base case
        }
        int pivot_index = partition(ar, start, end);
        quickSort(ar, start, pivot_index);
        quickSort(ar, pivot_index + 1, end);
    }

    private static int partition(int [] ar, int start, int end){
        int pivot = (ar[start] + ar[end]) / 2;
        int i = start - 1;
        int j = end + 1;

        while( true ){
            do {
                i++;
            } while ( ar[i] < pivot);

            do {
                j--;
            } while ( ar[j] > pivot);

            if(i < j){
                swap(ar, i, j);
            } else {
                return j;
            }
        }
    }

    private static void swap(int [] ar, int i, int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main( String[] args ){
        int [] ar = {4, 6, 4, 2, 1, 7, 3, 1};
        QuickSortAlgorithm.quickSort(ar);

        for (int num : ar) {
            System.out.println(num);
        }
    }
}
