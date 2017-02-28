/**
 * Created by sulu on 2/26/17.
 */
public class MyIntStack implements IntStack {
    private int top;
    private int max_size;
    private int[] the_array;

    MyIntStack(int max) {  // constructor
        the_array = new int[max];
        top = -1;
        max_size = max;
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public boolean isFull() {
        return (top == max_size - 1);
    }

    @Override
    public boolean push(int x) {
        if (isFull()) {
            return false;
        }
        else {
            the_array[++top] = x;
            return true;
        }
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        else {
            return the_array[top--];
        }
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        else {
            return the_array[top];
        }
    }
}
