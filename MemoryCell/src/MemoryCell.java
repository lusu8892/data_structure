import java.util.Objects;

/**
 * Created by sulu on 2/1/17.
 */
public class MemoryCell {

    // public methods
    public Object read() {
        return stored_value;
    }

    public void write (Object x) {
        stored_value = x;
    }

    // private internal data representation
    private Object stored_value;
}
