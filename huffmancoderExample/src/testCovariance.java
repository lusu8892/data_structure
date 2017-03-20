/**
 * Created by sulu on 3/18/17.
 */
public class testCovariance {

    static class Class {
    }

    static class SubClass extends Class {
    }

    static class SubClass2 extends Class {
    }

    static class SubSubClass extends SubClass {

    }

    public static void makeClass (Class[] ss){
        return;
    }
    public static void main(String args[]) {


//        Class[] array = new Class[10];
//        array[0] = new SubClass();

        Class[] array = new SubClass[10];
//        array[0] = new Class();
        SubClass[] sss = new SubClass[10];

        makeClass(sss);
    }

}
