/**
 * Created by sulu on 2/8/17.
 */
public class ArrayStack {

    private int top;
    private int max_size;
    private int[] the_array;

    ArrayStack(int max) {  // constructor
        the_array = new int[max];
        top = -1;
        max_size = max;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == max_size - 1);
    }

    public boolean push(int x) {
        if (isFull()) {
            return false;
        } else {
            top += 1;
            the_array[top] = x;
            return true;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            return the_array[top--];
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        } else {
            return the_array[top];
        }
    }

    public static void main (String [] args) {
        int num_item = 10;

        ArrayStack arrayStack = new ArrayStack(num_item);
        System.out.println(arrayStack.isEmpty());
        System.out.println(arrayStack.isFull());

        for (int i = 0; i < 100; i++) {
            arrayStack.push(i);
        }

        System.out.println(arrayStack.isFull());

        for (int i = 0; i < num_item; i++) {
            int k = arrayStack.pop();
            System.out.println(k);
        }
        int d = 1; System.out.println(d++ + ++d);
    }
}
