import java.util.NoSuchElementException;

/**
 * Created by sulu on 2/14/17.
 */
public class FBArrayList implements FBList{

    private static final int DEFAULT_CAPACITY = 10;  // default CAPACITY.

    // NOTE: DO NOT TREAT CAPACITY AND SIZE ARE SAME THING, THEY ARE !!! NOT SAME !!!
    private int theSize;  // reflect the actually size (i,e., the number of element in the ArrayList)
    private Person [] personArray;

    /**
     * Constructor
     */
    public FBArrayList () {
        doClear();
//        personArray = new Person[size];  // initialize personArray by input size
    }

    /**
     * Clear the ArrayList
     */
    public void clear () {
        doClear();
    }

    /**
     * Helper Function for clear(), the size of ArrayList reset to zero
     * and the Capacity of ArrayList reset to DEFAULT_CAPACITY and elements will be cleaned
     */
    private void doClear () {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    /**
     * Returns the size of the ArrayList
     */
    public int size () {
        return theSize;
    }

    /**
     * Trims the CAPACITY of the ArrayList
     */
    public void trimToSize () {
        ensureCapacity(size());
    }

    /**
     * Lookups the i-th position element
     * @param idx i-th position
     * @return the element at i-th position
     */
    public Person get (int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return personArray[idx];
    }

    /**
     * Sets the i-th element as input element
     * @param idx i-th position
     * @param x the element to which user want to set
     */
    public void set (int idx, Person x) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        personArray[idx] = x;
    }

    /**
     * Adds new element at the end of ArrayList
     * @param x the element to be added
     * @return always return true
     */
    public boolean add (Person x) {
        add (size(), x);
        return true;
    }

    /**
     * Adds new element at certain position
     * @param idx the i-th position to insert the element in
     * @param x the element to insert in
     */
    public void add (int idx, Person x) {
        if (personArray.length == size()) {  // if FBArrayList size is as large as its capacity
            // then expanding the capacity by double current capacity
            ensureCapacity(2*size() + 1);  // +1 is used in case of theSize = 0
        }
        for (int i = theSize; i > idx; i--) {  // shift element
            personArray[i] = personArray[i - 1];
        }
        personArray[idx] = x;
        theSize++;
    }

    /**
     * Removes the element at certain position
     * @param idx the i-th element to be removed in ArrayList
     * @return the removed elements
     */
    public Person remove (int idx) {
        if (idx > size()) {
            return null;
        }
        else{
            Person personToRemove = personArray[idx];  // remember the element to be removed

            for (int i = idx; i < size(); i++) {  // shift elements to fill vacancy
                personArray[i] = personArray[i + 1];
            }
            theSize--;
            return personToRemove;
        }
    }

    /**
     * Ensures the Capacity of ArrayList is enough for other operation
     * @param newCapacity the new Capacity user wants to assign to
     */
    public void ensureCapacity (int newCapacity) {
        if (newCapacity < size()) {  // the new declared FBArrayList capacity smaller than the current FBArrayList size
            return;
        }

        else {  // create a new FBArrayList and copy the data in old one to this new one
            Person [] old = personArray;  // make old array reference
            personArray = new Person[newCapacity];  // assign a new Person array to personArray
            for (int i = 0; i < size(); i++) {  // copy element piece by piece
                personArray[i] = old[i];
            }
        }
    }

    public FBIterator iterator () {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements FBIterator {

        private int currentIdx;

        private ArrayListIterator () {
            currentIdx = 0;
        }

        public boolean hasNext() {
            return currentIdx < size();
        }

        public Person next () {
            if (! hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return personArray[currentIdx++];
        }

        /**
         * Removes the last element returned by next() call
         * also means you cannot call remove() again until another after call to next()
         * this explain why currentIdx is being subtracted by 1 before remove.
         */
        public void remove () {
            FBArrayList.this.remove(--currentIdx);
        }
    }
}
