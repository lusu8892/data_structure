import java.util.Collection;

/**
 * Created by sulu on 2/16/17.
 */
public interface FBList<AnyType> extends Collection<AnyType>{
    void clear();
    int size();
    void add(int idx, AnyType x);
    void set (int idx, AnyType x);
    AnyType get (int idx);

    
    AnyType remove (int idx);
//    FBIterator iterator ();
}
