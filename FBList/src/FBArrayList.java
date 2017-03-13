/**
 * Created by sulu on 2/14/17.
 */
public class FBArrayList<AnyType> implements Iterable<AnyType>{

    private static final int DEFAULT_CAPACITY = 10;  // default CAPACITY.

    // NOTE: DO NOT TREAT CAPACITY AND SIZE ARE SAME THING, THEY ARE !!! NOT SAME !!!
    private int theSize;  // reflect the actually size (i,e., the number of element in the ArrayList)
    private AnyType [] personArray;

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
    public AnyType get (int idx) {
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
    public void set (int idx, AnyType x) {
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
    public boolean add (AnyType x) {
        add (size(), x);
        return true;
    }

    /**
     * Adds new element at certain position
     * @param idx the i-th position to insert the element in
     * @param x the element to insert in
     */
    public void add (int idx, AnyType x) {
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
    public AnyType remove (int idx) {
        if (idx > size()) {
            return null;
        }
        else{
            AnyType personToRemove = personArray[idx];  // remember the element to be removed

            for (int i = idx; i < size() - 1; i++) {  // shift elements to fill vacancy
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
            AnyType [] old = personArray;  // make old array reference
            personArray = (AnyType []) new Object[newCapacity];  // assign a new Person array to personArray
            for (int i = 0; i < size(); i++) {  // copy element piece by piece
                personArray[i] = old[i];
            }
        }
    }

    public java.util.Iterator<AnyType> iterator () {
        return new ArrayListIterator();
    }

    private class ArrayListIterator<AnyType>  implements java.util.Iterator<AnyType> {

        private int currentIdx;

        private ArrayListIterator () {
            currentIdx = 0;
        }

        public boolean hasNext() {
            return currentIdx < size();
        }

        public AnyType next () {
            if (! hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return (AnyType) personArray[currentIdx++];
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

    public static void printArrayList (FBArrayList inputArrayList) {
        java.util.Iterator<Integer> iterator = inputArrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println (integer);
        }
    }

//    public static void printArrayList (FBArrayList<Integer> inputArrayList) {
//        java.util.Iterator<Integer> iterator = inputArrayList.iterator();
//        while (iterator.hasNext()) {
//            Integer person = iterator.next();
//            System.out.println (person.getPersonName() + " " + person.getPhoneNumber());
////            System.out.println (person);
//
//        }
//    }

    public static void deletion (FBArrayList<Integer> inputArrayList) {
        java.util.Iterator<Integer> iterator = inputArrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            printArrayList(inputArrayList);
        }
    }

//    public static void deletion (FBArrayList<Integer> inputArrayList) {
//        java.util.Iterator<Integer> iterator = inputArrayList.iterator();
//        int i = 0;
//        for (Integer j: inputArrayList) {
//            System.out.println(inputArrayList.remove(i++));
//            printArrayList(inputArrayList);
//        }
//    }


    public static void main (String [] args) {
        FBArrayList fbArrayList = new FBArrayList();

//        String[] personName = {"Tom", "Jack", "Alex", "Andy", "Jason", "Will", "Jack", "Gay", "Alex", "Eason"};
//        Long[] phoneNumbers = {7892456789L, 48956241267L, 4653192724L, 9337789455L, 9223668009L, 7154028889L,
//                48956241267L, 5675579823L, 4653192724L, 4989098421L};
        Integer [] integers = {0,1,2,3,4,5,6,7,8,9};

        for (int i = 0; i < integers.length; i++) {
            fbArrayList.add(integers[i]);
        }

//        printArrayList(fbArrayList);
        deletion(fbArrayList);
    }
}
