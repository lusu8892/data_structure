/**
 * Created by sulu on 1/19/17.
 */
public class This_Example {
    // Instance Variable Num
    int num = 10;

    This_Example() {
        System.out.println("This is an example program on keyword this");
    }

    This_Example (int num) {
        // Invoking the default constructor
        this();

        // Assigning the local variable num to the instance variable num
        this.num = num;
    }

    public void greet() {
        System.out.println("Hi Welcome to Tutorialspoint");
    }
    public void print() {
        // local variable num
        int num = 20;

        // printing the instance variable
        System.out.println("value of local variable num is : "+num);

        // print the local variable
        System.out.println("value of instance variable num is : "+this.num);

        // Invoking the greet method of a class
        this.greet();
    }

    public static void main(String[] args) {
        // Instantiating the class
        This_Example obj1 = new This_Example();

        // Invoking the print method
        obj1.print();

        This_Example obj2 = new This_Example(30);
        obj2.print();
    }
}
