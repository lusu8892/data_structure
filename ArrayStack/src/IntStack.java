/**
 * Created by sulu on 2/26/17.
 */
public interface IntStack {

    boolean isEmpty();

    boolean isFull();

    boolean push(int x);

    int pop();

    int peek();
}
