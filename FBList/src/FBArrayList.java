/**
 * Created by sulu on 2/14/17.
 */
public class FBArrayList {

    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private Person personArray[];

    /**
     * Constructor
     */
    public FBArrayList () {
        doClear();
//        personArray = new Person[size];  // initialize personArray by input size
    }

    /**
     * Function
     */
    public void clear () {
        doClear();
    }

    /**
     * Function to insert new element at certain position
     * @param position
     * @param person
     */
    public void insert (int position, Person person) {

    }


    private void doClear () {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    /**
     * Function to return the size of the ArrayList
     */
    public int size () {
        return theSize;
    }

    /**
     *
     */
    public void ensureCapacity (int newCapacity) {
        if (newCapacity < theSize) {  // the new declared FBArrayList size smaller than the current one
            return;
        }

        else {  // create a new FBArrayList and copy the data in old one to this new one
            Person [] old = personArray;  // make old array reference
            personArray = new Person[newSize];  // assign a Person array to personArray
            for (int i = 0; i < theSize; i++) {  // copy element piece by piece
                personArray[i] = old[i];
            }
        }
    }
}
