/**
 * Created by sulu on 3/19/17.
 */
// interface

//// A class to represent a student.
//class Student {
//    Integer rollno;
//    String name, address;
//
//    Character marker;
//
//    // Constructor
//    public Student(int rollno, String name,
//                   String address, Character marker) {
//        this.rollno = rollno;
//        this.name = name;
//        this.address = address;
//        this.marker = marker;
//    }
//
//    // Used to print student details in main()
//    public String toString() {
//        return this.rollno + " " + this.name +
//                " " + this.address + " " + this.marker;
//    }
//}
//
//class Sortbyroll implements Comparator<Student> {
//    // Used for sorting in ascending order of
//    // roll number
//    private int k = -1;
//    private ArrayList<Integer> ar = new ArrayList<>();
////    Sortbyroll (ArrayList<Integer> ar) {
////        this.ar = ar;
//////        System.out.println(ar);
////    }
//    public int compare(Student a, Student b) {
////        System.out.println(ar);
////        if (a.rollno - b.rollno > 0) {
////            ar.add(k*1);
////            return k*1;
////        } else if (a.rollno - b.rollno < 0) {
////            ar.add(-k*1);
////            return -k*1;
////        } else if (a.rollno == b.rollno) {
////            ar.add(0);
////            return 0;
////        }
//        int result = b.rollno.compareTo(a.rollno);
//        if (result == 0) {
//            return b.marker.compareTo(a.marker);
//        }
//        return result;
//    }
////        return b.rollno - a.rollno;
//}
//
//class Sortbyname implements Comparator<Student> {
//    // Used for sorting in ascending order of
//    // roll name
//    Sortbyname (ArrayList<Student> ar) {
//        System.out.println(ar);
//    }
//    public int compare(Student a, Student b) {
//        return a.name.compareTo(b.name);
//    }
//}


// Driver class
class Main {
    public static void main(String[] args) {
//        ArrayList<Student> ar = new ArrayList<Student>();
//        ar.add(new Student(111, "bbbb", "london", 'a'));
//        ar.add(new Student(111, "aaaa", "nyc",'U'));
//        ar.add(new Student(121, "cccc", "jaipur",'z'));
//
//        System.out.println("Unsorted");
//        for (int i = 0; i < ar.size(); i++)
//            System.out.println(ar.get(i));
//
//        Collections.sort(ar, new Sortbyroll());
//        Collections.sort(ar, new Sortbyroll());
//        System.out.println("\nSorted by rollno");
//        for (int i = 0; i < ar.size(); i++)
//            System.out.println(ar.get(i));
//
//        Collections.sort(ar, new Sortbyname(ar));
//
//        System.out.println("\nSorted by name");
//        for (int i = 0; i < ar.size(); i++)
//            System.out.println(ar.get(i));
    int [] ar = {1,2,3,4,5}                      ;

//    insertionSort ( ar );
//    }
//    public static void insertionSort ( int[] ar ) {
//        for ( int i = 1; i < ar.length; i++ ) {
//            int tolnsert = ar[i];
//            int j;
//            for ( j = i; j > 0 && tolnsert < ar[j-1]; j--) {
//                ar[j] = ar[j-1];
//            }
//            ar[j] = tolnsert;
//        }
//    }
//        int i = 3;
        for ( int i = 0; i < 10; i++ ) {
            System.out.println(i);
            try {
                System.out.println ( "1111");

                System.out.println( ar[5] );

                System.out.println ( "aaaa");

            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Exception thrown  :" + e);

//                break;
            }
            System.out.println ( "dddd");
        }
        System.out.println ( "eeeee");
    }
}

