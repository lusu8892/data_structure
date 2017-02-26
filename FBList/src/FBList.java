/**
 * Created by sulu on 2/16/17.
 */
public interface FBList {
    void clear();
    int size();
    void add(int idx, Person x);
    void set (int idx, Person x);
    Person get (int idx);

    Person remove (int idx);
    FBIterator iterator ();
}
