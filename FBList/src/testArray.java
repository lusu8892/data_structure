/**
 * Created by sulu on 2/15/17.
 */
public class testArray {

    public testArray () {
    }

    public static void main (String [] args) {
//        double [] a1;

        testArray t1 = new testArray();
//        System.out.println(a1.length);

        double [] a2 = new double[10];

        double [] a3 = {1,2,3,4,5,6,7,8,0,0};

        int idx = 7;
        for (int i = idx; i < 8 - 1; i++) {  // shift elements to fill vacancy
            a3[i] = a3[i + 1];
        }

        System.out.println(a2.length);

    }
}
