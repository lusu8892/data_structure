//public class MyFirstJavaProgram {
//
//   /* This is my first java program.
//    * This will print 'Hello World' as the output
//    */
//
//    public static void main(String []args) {
//        System.out.println("Hello World"); // prints Hello World
//    }
//}

//class FreshJuice {
//    enum FreshJuiceSize { SMALL, MEDIUM, LARGE }
//    FreshJuiceSize size;
//}
//
//public class FreshJuiceTest {
//
//    public static void main (String args[]) {
//        FreshJuice juice = new FreshJuice();
//        juice.size = FreshJuice.FreshJuiceSize.MEDIUM;
//        System.out.println("Size: " + juice.size);
//    }


public class Puppy {
    int puppyAge;

    Puppy() {
        // This constructor has one parameter, name.
        System.out.println("Name chosen is :");
    }

    public void setAge(int age) {
        puppyAge = age;
    }

    public int getAge() {
        System.out.println("Puppy's age is :" + puppyAge);
        return puppyAge;
    }

    public static void main(String []args) {
//        /* Object creation */
//        Puppy myPuppy = new Puppy();
//
//        /* Call class method to set puppy's age */
//        myPuppy.setAge(2);
//
//        /* Call Another class method to get puppy's age */
//        myPuppy.getAge();
//
//        /* You can access instance variable as follows as well */
//        System.out.println("Variable Value :" + myPuppy.puppyAge);

//        Puppy myPuppy = new Puppy();
//        Puppy myPuppy = new Puppy();
        Puppy myPuppy = new Puppy();
//        for (int i=0; i<3; i++) {
//            Puppy myPuppy = new Puppy();
//            System.out.println("wait");
//        }
        Puppy myPuppy2;
        myPuppy2 = myPuppy;

        System.out.println("wait");

    }
}