import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * Created by sulu on 2/14/17.
 */
public class FBLinkList {

    private Person head;
    private Person tail;
    private int theSize;

    // represents the number of changes to Linklist since construction
    // each call to add(), remove(), or clear() will update modCount
    private int modCount = 0;

    FBLinkList () {
        doclear();
    }

    public int size () {
        return theSize;
    }

    public boolean isEmpty() { return size() == 0; }

    public void clear () {
        doclear();
    }


    public Person get( int idx ) { return getNode( idx ); }

    public Person set( int idx, Person newVal) {
        Person p = getNode( idx );
        Person oldVal = new Person(p, null);
        p.setData(newVal.getPersonName(), newVal.getPhoneNumber());
        return oldVal;
    }

    /**
     * Adds an item at the end of this collection.
     * @param x
     * @return return true if adding is successful
     */
    public boolean add( Person x ) {
        add( size( ), x );
        return true;
    }

    /**
     * Adds an item to this collection, at specified position p.
     * @param idx the position to add
     * @param x the item needs to be added
     */
    public void add (int idx, Person x) {
        if ( idx == 0 ) {
            addFisrt(x);
        }
        else if ( idx == size() ) {
            addLast(x);
        }
        else{
            addBefore(getNode(idx - 1, 0, size()), x);
        }
    }

    /**
     * Removes an item from this collection, after specific position p
     * @param idx the position to remove before
     * @return the item removed from this collection
     */
    public Person remove (int idx) {
        if (idx == 0) {
            return removeFirst();
        }
        else {
            return removeAfter(getNode(idx - 1));
        }
    }

    private void doclear () {
        theSize = 0;
        head = new Person (null, null, null);
        tail = new Person (null, null, null);
        tail = head;
        modCount++;
    }

    /**
     * Adds an item at the very beginning of this collection
     * @param x the item needs to be added
     */
    private void addFisrt (Person x) {
        if ( isEmpty() ) {
            Person newNode = new Person(x, null);
            head = newNode;
            tail = newNode;
        }
        else {
            Person newNode = new Person(x, head);
            head = newNode;
        }
        theSize++;
        modCount++;
    }

    private void addLast (Person x) {
        Person newNode = new Person(x, null);
        if ( isEmpty() ) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.setNext(newNode);
            tail = newNode;
        }
        theSize++;
        modCount++;
    }

    /**
     * Adds an item to this collection, at specified position p.
     * Items at or after that position are slid one position higher.
     * @param p Node to add before.
     * @param x Anything needs to be added
     * @throws IndexOutOfBoundsException if idx is not between 0 and size(),
     */
    private void addBefore (Person p, Person x) {

        // create a newNode for insert after Node p, set newNode's next link = Node p's old next Node
        Person newNode = new Person(x, p.getNext());
        p.setNext(newNode);  // set Node p's next link = current newNode
        theSize++;
        modCount++;
    }

    /**
     * Removes the first node
     * @return first node
     */
    private Person removeFirst () {
        if ( isEmpty() ) {
            return null;
        }
        else {
            theSize--;
            modCount++;
            Person firstNode = new Person(head, null);
            if (head == tail) {  // when linklist only has one node
                head = null;
                tail = null;
            }
            else {
                head = head.getNext();
            }
            return firstNode;
        }
    }

    /**
     * Remove an item from this collection, after specific position p
     * Items after that position are slide one position lower.
     * @param p Node to remove after
     * @return the removed node
     */
    private Person removeAfter (Person p) {
        Person nodeNeedRemove = new Person (p.getNext(), null);
        p.setNext(p.getNext().getNext());  // set Node p's next link = Node p's next next link
        theSize--;
        modCount++;
        return nodeNeedRemove;
    }

    /**
     * Gets the Node at position idx, which must range from 0 to size() - 1.
     * @param idx index to search at.
     * @return  internal node corresponding to idx
     * @throws IndexOutOfBoundsException if idx is not
     *         between 0 and size() - 1, inclusive.
     */
    private Person getNode (int idx) {
        return getNode(idx, 0, size() - 1);
    }

    /**
     * Gets the Node at position idx, which must range from lower to upper.
     * @param idx index to search at.
     * @param lower lowest valid index.
     * @param upper highest valid index.
     * @return internal node corresponding to idx.
     * @throws IndexOutOfBoundsException if idx is not
     *         between lower and upper, inclusive.
     */
    private Person getNode (int idx, int lower, int upper) {
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Person p = head;
            for (int i = lower; i < idx; i++) {
                p = p.getNext();
            }
            return p;
        }
    }

    private class LinkListIterator implements FBIterator {

        private Person current;
        private int expectedModCount;
        private boolean okToRemove;

        /**
         * Constructor
         */
        private LinkListIterator () {
            current = head;
            expectedModCount = modCount;
            okToRemove = false;
        }

        public boolean hasNext () {
            return current.getNext() != null;
        }

        public Person next() {
            if (modCount != expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            Person personToBeReturn = new Person (current, null);
            current = current.getNext();
            okToRemove = true;

            return personToBeReturn;
        }

        public void remove() {
            if (modCount != expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new java.lang.IllegalStateException();
            }
            FBLinkList.this.removeAfter( current );
            expectedModCount++;
            okToRemove = false;
        }

    }
}
